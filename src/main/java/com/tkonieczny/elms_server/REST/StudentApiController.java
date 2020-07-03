package com.tkonieczny.elms_server.REST;

import com.tkonieczny.elms_server.DTO.GradesDTO;
import com.tkonieczny.elms_server.DTO.LoginInfoDTO;
import com.tkonieczny.elms_server.DTO.UserDataDTO;
import com.tkonieczny.elms_server.other.Messages;
import com.tkonieczny.elms_server.other.UserList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping(value="/api/student/")
public class StudentApiController {

    @Autowired
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginApiController.class);


    @CrossOrigin
    @RequestMapping(value = "/get/listOfUsers", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<UserDataDTO>> getListOfUsers(){
        if(UserList.userList != null) return new ResponseEntity<ArrayList<UserDataDTO>>(UserList.userList, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @RequestMapping(value = "/chat/getMessages", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<String>> getListOfMessages(){
        if(Messages.messages != null) return new ResponseEntity<ArrayList<String>>(Messages.messages, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @RequestMapping(value = "/chat/sendMessage", method = RequestMethod.POST)
    public ResponseEntity<Boolean> sendMessage(@RequestBody String mess) {
        boolean response = false;
        try {
            Messages.messages.add(mess);
            response = true;
        } catch (Exception er2) {
            System.out.println("Error in /api/chat/sendMessage");
            er2.printStackTrace();
        }
        return new ResponseEntity<Boolean>(response, HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value = "/grades/sendGrade", method = RequestMethod.POST)
    public ResponseEntity<Boolean> loginAuth(@RequestBody GradesDTO gradesDTO) {
        boolean response = false;
        try {
           GradesDTO.gradesDTOArrayList.add(gradesDTO);
            response = true;
        } catch (Exception er2) {
            System.out.println("Error in /api/grades/sendGrade");
            er2.printStackTrace();
        }
        return new ResponseEntity<Boolean>(response, HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value = "/grades/getGrades", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<GradesDTO>> getListOfGrades(){
        if(GradesDTO.gradesDTOArrayList != null) return new ResponseEntity<ArrayList<GradesDTO>>(GradesDTO.gradesDTOArrayList, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
