package com.example.CRUD.User.Management;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    //Creating some data
    private List<UserProfile> users = new ArrayList<>(Arrays.asList(
            new UserProfile("Kshitij","1234567890",
                    "xyz, India","xvz@monsterindia.com"),
            new UserProfile("Prateek","9876543210",
                    "xyz, India","abc@monsterindia.com"),
            new UserProfile("Jivan","5632147890",
                    "xyz, India","def@monsterindia.com")
    ));

    public List<UserProfile> getAllUsers(){
        return users;
    }

    public UserProfile getUser(String name){
        return users.stream().filter(u -> u.getName().equals(name))
                .findFirst().get();
    }

    public void addUser(UserProfile newUser) {
        users.add(newUser);
    }

    public void updateUser(UserProfile userUpdate, String name) {
        for (int index = 0; index < users.size(); index++) {
            UserProfile user = users.get(index);
            if (user.getName().equals(name)) {
                users.set(index,userUpdate);
                return;
            }
        }
    }

    public void deleteUser(String name) {
        users.removeIf(user -> user.getName().equals(name));
    }
}
