package com.tkonieczny.elms_server.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor
public class LoginInfoDTO implements Serializable {
    String login;
    String password;


    public LoginInfoDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
