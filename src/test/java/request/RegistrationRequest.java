package request;

public class RegistrationRequest {
    public String email;
    public String password;
    public String name;

    public RegistrationRequest(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}