package tests;

import manager.HelperStudent;
import models.StudentDTO;
import models.StudentDTOLombok;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentRegFormTests extends TestBase implements HelperStudent {

    @BeforeMethod
    public void precondition(){
        selectForm();
        selectPracticeForm();
    }

    @Test
    public void StudentRegFormPositiveTest(){
        StudentDTO student = new StudentDTO("Frodo", "Baggins", "frodobaggins@mail.com","Male","1234567890",
                "11 Sep 2021","Maths,Physics","Sports,Music","J.Washington street, 10","NCR", "Delhi");
        StudentDTOLombok studentDTOLombok = StudentDTOLombok.builder()
                .firstName("Frodo Lombok")
                .lastName("Baggins")
                .email("frodobaggins@mail.com")
                .gender("Male")
                .mobile("1234567890")
                .dateOfB("11 Sep 2021")
                .subject("Maths,Physics")
                .hobbies("Sports,Music")
                .address("J.Washington street, 10")
                .state("NCR")
                .city("Delhi")
                .build();

        fillStudentForm(student);
        pause(3);
        clickButtonSubmit();
        Assert.assertTrue(isElementPresent_Thanks_for_submitting());
        //pause(3);

    }

    @AfterTest
    public void afterMethod(){
        pause(3);
        clickButtonCloseByRectangle();
        clickButtonCloseByJs();
    }

}
