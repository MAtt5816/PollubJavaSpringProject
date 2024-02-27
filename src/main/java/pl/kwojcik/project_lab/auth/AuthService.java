package pl.kwojcik.project_lab.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kwojcik.project_lab.gen.api.dto.LoginCmdDTO;
import pl.kwojcik.project_lab.user.UserService;

import java.util.Date;
import java.util.List;

@Service
public class AuthService implements AuthenticationManager  {
    //todo this should not be hard coded
    private final String secret = "gsgsdgasdgehberhnrst4t6ergvea";
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }




    public String login(LoginCmdDTO cmd) {
        var user = userService.loadUserByUsername(cmd.getUsername());
        var passwordIsCorrect = passwordEncoder.matches(cmd.getPassword(), user.getPassword());
        if (!passwordIsCorrect) {
            throw new BadCredentialsException("bad password");
        }

        return JWT.create()
                .withIssuedAt(new Date())
                .withSubject(user.getUsername())
                .sign(Algorithm.HMAC512(secret));

    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var rawJwt = (String) authentication.getPrincipal();
        var jwt = JWT.decode(rawJwt);
        var username = (String) jwt.getSubject();
        JWT.require(Algorithm.HMAC512(secret))
                .build()
                .verify(jwt);

        var user = userService.loadUserByUsername(username);
        return UsernamePasswordAuthenticationToken.authenticated(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities()
        );
    }
}
