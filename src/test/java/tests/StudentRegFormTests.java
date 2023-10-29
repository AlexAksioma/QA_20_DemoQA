package tests;

import data.DP_StudentRegFornTests;
import manager.HelperStudent;
import models.StudentDTO;
import models.StudentDTOLombok;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;

public class StudentRegFormTests extends TestBase implements HelperStudent {

    @BeforeClass
    public void precondition(){
        selectForm();
        selectPracticeForm();
    }

    @Test(dataProvider = "dp_StudentRegFormPositiveTest", dataProviderClass = DP_StudentRegFornTests.class)
    public void StudentRegFormPositiveTest(StudentDTOLombok student){
//        int i = new Random(1000).nextInt();
//        StudentDTO student = new StudentDTO("Frodo", "Baggins", "frodobaggins@mail.com","Male","1234567890",
//                "11 Sep 2021","Maths,Physics","Sports,Music","J.Washington street, 10","NCR", "Delhi");
//        StudentDTOLombok studentDTOLombok = StudentDTOLombok.builder()
//                .firstName("Frodo Lombok")
//                .lastName("Baggins")
//                .email("frodobaggins@mail.com")
//                .gender("Male")
//                .mobile("1234567890")
//                .dateOfB("11 Sep 2021")
//                .subject("Maths,Physics")
//                .hobbies("Sports,Music")
//                .address("J.Washington street, 10")
//                .state("NCR")
//                .city("Delhi")
//                .build();

        fillStudentForm(student);
        pause(3);
        clickButtonSubmit();
        Assert.assertTrue(isElementPresent_Thanks_for_submitting());
        pause(3);

    }

    @AfterMethod
    public void afterMethod(){
        //pause(3);
        clickButtonCloseByRectangle();
        //clickButtonCloseByJs();
    }

}
