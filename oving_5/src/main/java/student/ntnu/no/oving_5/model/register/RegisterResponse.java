package student.ntnu.no.oving_5.model.register;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterResponse {

    private String registerStatus;
    private String name;
    private String address;
    private String username;
    private String password;
    private String email;
    private int phone;

    @JsonCreator
    public RegisterResponse(@JsonProperty("registerStatus") String registerStatus,
                            @JsonProperty("name") String name,
                            @JsonProperty("address") String address,
                            @JsonProperty("username") String username,
                            @JsonProperty("password") String password,
                            @JsonProperty("email") String email,
                            @JsonProperty("phone") int phone) {
        this.registerStatus = registerStatus;
        this.name = name;
        this.address = address;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    @JsonCreator()
    public RegisterResponse(@JsonProperty("registerStatus") String registerStatus) {
        this.registerStatus = registerStatus;
    }

    public String getRegisterStatus() {
        return registerStatus;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }
}
