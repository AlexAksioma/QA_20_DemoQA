package manager;

import models.StudentDTO;
import org.openqa.selenium.By;

public interface HelperStudent extends HelperBase{

    default void selectForm(){
        if(isElementPresent(By.id("adplus-anchor")))
            hideAds();
        if(isElementPresent(By.cssSelector("footer")))
            hideFooter();
        if(isElementPresent(By.id("close-fixedban")))
            hideDiv();
        click(By.xpath("//div[@class='category-cards']/div[2]"));
    }

    default void selectPracticeForm(){
        hideFooter();
        click(By.xpath("//span[text()='Practice Form']"));
    }

    default void fillStudentForm(StudentDTO student){
        //hideFooter();
        type(By.id("firstName"), student.getFirstName());
        type(By.id("lastName"), student.getLastName());
        type(By.id("userEmail"), student.getEmail());
    }
}
