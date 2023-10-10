package tests;

import manager.HelperStudent;
import models.StudentDTO;
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
                "11 Sep 2021","Maths,Physics","Sports,Music","J.Washington street, 10","Washington", "New York");
        fillStudentForm(student);
        //pause(3);
    }

}
