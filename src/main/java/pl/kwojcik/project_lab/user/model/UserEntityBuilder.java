package pl.kwojcik.project_lab.user.model;

// #Zadanie__1_3
//start L1 Builder
public class UserEntityBuilder {

    private Long id;
    private String username;
    private String passwordHash;
    private AppRole role;

    public static UserEntityBuilder newUser() {
        return new UserEntityBuilder();
    }

    public static UserEntityBuilder existingUser(long id) {
        var builder = new UserEntityBuilder();
        builder.id = id;
        return builder;
    }

    public UserEntityBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserEntityBuilder setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    public UserEntityBuilder setRole(AppRole role) {
        this.role = role;
        return this;
    }

    public UserEntity build() {
        var user =  new UserEntity(username, passwordHash, role);
        user.setId(id);
        return user;
    }
}
