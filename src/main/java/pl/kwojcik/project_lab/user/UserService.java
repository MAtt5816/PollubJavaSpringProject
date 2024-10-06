package pl.kwojcik.project_lab.user;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import pl.kwojcik.project_lab.gen.api.dto.CreateUserCmdDTO;
import pl.kwojcik.project_lab.user.model.AppRole;
import pl.kwojcik.project_lab.user.model.UserEntity;
import pl.kwojcik.project_lab.user.model.UserEntityBuilder;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username: %s not found".formatted(username)));
        return new AppUser(user.getUsername(), user.getPasswordHash(), user.getRole());
    }

    @PreAuthorize("#createUserCmdDTO.role.name().equals('CUSTOMER') or hasAnyRole('ADMIN')")
    public UserDetails createUser(@P("createUserCmdDTO") CreateUserCmdDTO cmd) {
        return this.createUserNoAuthChecked(cmd);
    }

    public UserDetails createUserNoAuthChecked( CreateUserCmdDTO createUserCmdDTO) {
        if (userRepository.existsByUsername(createUserCmdDTO.getUsername())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        var passwHash = passwordEncoder.encode(createUserCmdDTO.getPassword());
        var appRole = AppRole.valueOf(createUserCmdDTO.getRole().name());
        var user = UserEntityBuilder.newUser()
                .setRole(appRole)
                .setUsername(createUserCmdDTO.getUsername())
                .setPasswordHash(passwHash)
                .build();
        var createdUser = this.userRepository.save(user);
        return mapUser(createdUser);
    }

    private UserDetails mapUser(UserEntity user) {
        return new AppUser(user.getUsername(), user.getPasswordHash(), user.getRole());
    }

}
