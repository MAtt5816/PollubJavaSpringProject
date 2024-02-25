package pl.kwojcik.project_lab.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.kwojcik.project_lab.gen.api.LoginApi;
import pl.kwojcik.project_lab.gen.api.dto.LoginCmdDTO;

@RestController
public class AuthApi implements LoginApi {
    private final AuthService authService;

    public AuthApi(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<Void> login(LoginCmdDTO loginCmdDTO) {
        var token = authService.login(loginCmdDTO);
        return ResponseEntity.ok()
                .header("JWT", token)
                .build();
    }
}
