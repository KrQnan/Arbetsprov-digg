package org.acme.DTO;

import jakarta.validation.constraints.NotBlank;


public class User {
    @NotBlank
    public String name;
    @NotBlank
    public String address;
    @NotBlank
    public String email;
    @NotBlank
    public String telephone;

    public User() {

    }
}
