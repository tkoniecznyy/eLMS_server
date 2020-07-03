package com.tkonieczny.elms_server.DTO;

import com.tkonieczny.elms_server.other.UserInfo;
import com.tkonieczny.elms_server.other.UserList;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Klasa odpowidzialna jest za przetrzymywanie podstawowych informacji o uzytkowniku.
 */
/* lombok: */
@Getter                                             /* automatyczne generowanie getterow dla pol */
@ToString                                           /* automatyczne generowanie metody toString */
@NoArgsConstructor                                  /* automatyczne generowanie konstruktora bezparametrowego */
@FieldDefaults(level = AccessLevel.PRIVATE)         /* automatyczne generowanie zasiegu dla pol */
public class UserDataDTO implements Serializable {
    String login;
    String password;
    Integer userId;
    UserInfo userInfo;
    boolean isTeacher;

    public UserDataDTO (String login, String password, Integer userId, UserInfo userInfo, boolean isTeacher){
    this.login = login;
    this.password = password;
    this.userId = userId;
    this.userInfo = userInfo;
    this.isTeacher = isTeacher;
    UserList.userList.add(this);
    }
    public UserDataDTO (String login, String password){
        this.login = login;
        this.password = password;
    }


    public static boolean loginAuthorization(String login, String password){
        for(int i = 0 ; i<UserList.userList.size(); i++){
            if(UserList.userList.get(i).getLogin().equals(login) && UserList.userList.get(i).getPassword().equals(password)){
                    UserDataDTO.loggedUser = UserList.userList.get(i); //zapisuje zalogowanego uzytkownika
                System.out.println("Zwraca :  "+UserDataDTO.loggedUser.toString());
                return true;
            }
           // System.out.println("UPS ! \n "  + "\n"+"login: "+login +"\n\n"+"pass: "+password);
        } return false;
    }

    public static UserDataDTO loggedUser = new UserDataDTO();
    final static UserDataDTO user1 = new UserDataDTO("student1","student",1,new UserInfo("Tomasz","Konieczny","student1@gmail.com"),false);
    final static UserDataDTO user2 = new UserDataDTO("student2","student",2,new UserInfo("Adam","Adamski","student12313@gmail.com"),false);
    final static UserDataDTO user3 = new UserDataDTO("student3","student",3,new UserInfo("Karol","Krawczyk","krawczyk333@gmail.com"),false);
    final static UserDataDTO user4 = new UserDataDTO("student4","student",4,new UserInfo("Emil","Kowalski","emil3232@gmail.com"),false);
    final static UserDataDTO user5 = new UserDataDTO("student5","student",5,new UserInfo("Marcin","Tarnowski","mmt4@gmail.com"),false);
    final static UserDataDTO teacher1 = new UserDataDTO("nauczyciel1","nauczyciel",6,new UserInfo("mgr inz. Nikodem","Malinowski","mailowski@pwsztar.edu.com"),true);
    final static UserDataDTO teacher2 = new UserDataDTO("nauczyciel2","nauczyciel",7,new UserInfo("dr hab. Alicja","Kowalska","kowalskaaa@pwsztar.edu.com"),true);


}



