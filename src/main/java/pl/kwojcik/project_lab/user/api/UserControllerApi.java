package pl.kwojcik.project_lab.user.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.kwojcik.project_lab.gen.api.UserApi;
import pl.kwojcik.project_lab.gen.api.dto.CreateUserCmdDTO;
import pl.kwojcik.project_lab.user.UserService;

@RestController
public class UserControllerApi implements UserApi {
    private final UserService userService;

    public UserControllerApi(UserService userService) {
        this.userService = userService;
    }


    @Override
    public ResponseEntity<Void> createUser(CreateUserCmdDTO createUserCmdDTO) {
        userService.createUser(createUserCmdDTO);
        return ResponseEntity.ok().build();
    }
}
