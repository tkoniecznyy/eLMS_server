package com.tkonieczny.elms_server.REST;

import com.tkonieczny.elms_server.DTO.LoginInfoDTO;
import com.tkonieczny.elms_server.DTO.UserDataDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value="/api")
public class LoginApiController {
    @Autowired

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginApiController.class);

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Boolean> loginAuth(@RequestBody LoginInfoDTO loginInfoDto) {
        boolean response = false;
        try {
           response = UserDataDTO.loginAuthorization(loginInfoDto.getLogin(), loginInfoDto.getPassword());
        } catch (Exception er1) {
            System.out.println("Error in /login //POST");
            er1.printStackTrace();
        }
        return new ResponseEntity<Boolean>(response, HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value = "/login/getLoggedUserData", method = RequestMethod.GET)
    public ResponseEntity<UserDataDTO> getLoggedUserData(){
        if(UserDataDTO.loggedUser != null) return new ResponseEntity<UserDataDTO>(UserDataDTO.loggedUser,HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}