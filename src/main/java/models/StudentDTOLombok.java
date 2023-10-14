package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString

public class StudentDTOLombok {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobile;
    private String dateOfB;
    private String subject;
    private String hobbies;
    private String address;
    private String state;
    private String city;
}
