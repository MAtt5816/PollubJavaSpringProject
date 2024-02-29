package pl.kwojcik.project_lab.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pl.kwojcik.project_lab.gen.api.dto.CreateUserCmdDTO;
import pl.kwojcik.project_lab.user.model.AppRole;
import pl.kwojcik.project_lab.user.model.UserEntity;

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
        var user = userRepository.findByUsername(username).orElseThrow();
        return new AppUser(user.getUsername(), user.getPasswordHash(), user.getRole());

    }

    @PreAuthorize("cmd.role.name().equals('CUSTOMER') or hasAnyRole('ADMIN')")
    public UserDetails createUser(CreateUserCmdDTO cmd) {
        var passwHash = passwordEncoder.encode(cmd.getPassword());
        var appRole = AppRole.valueOf(cmd.getRole().name());
        var user = new UserEntity(cmd.getUsername(), passwHash, appRole);
        var createdUser = this.userRepository.save(user);
        return mapUser(createdUser);
    }

    private UserDetails mapUser(UserEntity user) {
        return new AppUser(user.getUsername(), user.getPasswordHash(), user.getRole());
    }

}
