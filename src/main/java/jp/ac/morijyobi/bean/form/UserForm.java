package jp.ac.morijyobi.bean.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserForm {
    @NotBlank
    @Size(min=5, max=64)
    private String username;

    @NotBlank
    @Size(min=5, max=64)
    private String password;

    @NotBlank
    private String name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
