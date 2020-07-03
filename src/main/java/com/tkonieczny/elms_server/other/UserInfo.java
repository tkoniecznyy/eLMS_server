package com.tkonieczny.elms_server.other;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserInfo {
    String name;
    String surname;
    String email;

    public UserInfo(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
