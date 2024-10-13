package pl.kwojcik.project_lab.user.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.kwojcik.project_lab.gen.api.UserApi;
import pl.kwojcik.project_lab.gen.api.dto.CreateUserCmdDTO;
import pl.kwojcik.project_lab.user.UserService;

import java.math.BigDecimal;

@RestController
public class UserControllerApi implements UserApi {
    private final UserService userService;

    public UserControllerApi(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<Void> createUser(CreateUserCmdDTO createUserCmdDTO) {
        if (createUserCmdDTO == null || createUserCmdDTO.getRole() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        userService.createUser(createUserCmdDTO);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<BigDecimal> checkUserDiscount(Long id){
        var user = userService.getUserById(id);
        BigDecimal discount = userService.checkUserDiscount(user);
        return ResponseEntity.ok(discount);
    }
}
