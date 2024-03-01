package pl.kwojcik.project_lab;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.kwojcik.project_lab.gen.api.dto.CreateUserCmdDTO;
import pl.kwojcik.project_lab.gen.api.dto.UserRoleDTO;
import pl.kwojcik.project_lab.user.UserService;

@Profile("dev")
@Component
public class DevGenerator {
    private static final String ADMIN_USERNAME = "admin";
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(DevGenerator.class);

    public DevGenerator(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void createAdminDev() {
        try {
            this.userService.loadUserByUsername(ADMIN_USERNAME);
            logger.info("User admin already exist.");
        } catch (UsernameNotFoundException ignore) {
            this.userService.createUserNoAuthChecked(
                    new CreateUserCmdDTO()
                            .username(ADMIN_USERNAME)
                            .password("123")
                            .role(UserRoleDTO.ADMIN)
            );
            logger.info("User admin created");
        }
    }

}
