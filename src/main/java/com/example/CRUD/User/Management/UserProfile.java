package com.example.CRUD.User.Management;

import lombok.Data;

@Data public class UserProfile {
    private String name;
    private String phoneNumber;
    private String address;
    private String email;

    public UserProfile(String name, String phoneNumber, String address, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

}
