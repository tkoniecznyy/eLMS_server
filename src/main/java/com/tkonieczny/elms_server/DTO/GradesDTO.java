package com.tkonieczny.elms_server.DTO;

import com.tkonieczny.elms_server.other.Subjects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;

@Getter                                             /* automatyczne generowanie getterow dla pol */
@ToString                                           /* automatyczne generowanie metody toString */
@NoArgsConstructor                                  /* automatyczne generowanie konstruktora bezparametrowego */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GradesDTO {

        Subjects subject;
        Integer userID;
        Double mark;
        String info;
        String teacher;

        public static ArrayList<GradesDTO> gradesDTOArrayList = new ArrayList<>();

}
