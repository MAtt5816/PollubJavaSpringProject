package pl.kwojcik.project_lab.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String passwordHash;
    private AppRole role;

    public UserEntity(String username, String passwordHash, AppRole role) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
    }
}
