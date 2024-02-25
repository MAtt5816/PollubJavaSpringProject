package pl.kwojcik.project_lab.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import pl.kwojcik.project_lab.gen.api.dto.LoginCmdDTO;
import pl.kwojcik.project_lab.user.UserService;

import java.util.Date;

@Service
public class AuthService implements AuthenticationManager  {
    //todo this should not be hard coded
    private final String secret = "gsgsdgasdgehberhnrst4t6ergvea";
    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public String login(LoginCmdDTO cmd) {
        var user = userService.loadUserByUsername(cmd.getUsername());
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

        return null;
    }
}
