package manager;

import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface HelperStudent extends HelperBase {

    default void selectForm() {
        if (isElementPresent(By.id("adplus-anchor")))
            hideAds();
        if (isElementPresent(By.cssSelector("footer")))
            hideFooter();
        if (isElementPresent(By.id("close-fixedban")))
            hideDiv();
        click(By.xpath("//div[@class='category-cards']/div[2]"));
    }

    default void selectPracticeForm() {
        hideFooter();
        click(By.xpath("//span[text()='Practice Form']"));
    }

    default void fillStudentForm(StudentDTO student) {
        //hideFooter();
        type(By.id("firstName"), student.getFirstName());
        type(By.id("lastName"), student.getLastName());
        type(By.id("userEmail"), student.getEmail());

        selectGender(student.getGender());
        type(By.id("userNumber"), student.getMobile());

        //type(By.id("dateOfBirthInput"), student.getDateOfB());
        typeBDay(student.getDateOfB());
        addSubject(student.getSubject());
        selectHobby(student.getHobbies());
        loadPicture();

    }

    default void loadPicture() {
        driver.findElement(By.id("uploadPicture")).
                sendKeys("C:\\QA_Auto_Projects\\QA_20\\cat1.jpg");
    }

    default void selectHobby(String hobbies) {
        String [] hobbiesArray = hobbies.split(",");
        for (String element:hobbiesArray) {
            switch (element) {
                case "Sports":
                    click(By.xpath("//label[@for='hobbies-checkbox-1']"));
                    break;
                case "Reading":
                    click(By.xpath("//label[@for='hobbies-checkbox-2']"));
                    break;
                case "Music":
                    click(By.xpath("//label[@for='hobbies-checkbox-3']"));
                    break;
            }
        }

    }

    default void addSubject(String subject) {
        String[] subjectsArray = subject.split(",");
        WebElement sub = driver.findElement(By.id("subjectsInput"));
        sub.click();
        for (String element : subjectsArray) {
            sub.sendKeys(element);
            sub.sendKeys(Keys.ENTER);
        }

    }

    default void typeBDay(String birthday) {
        WebElement date = driver.findElement(By.id("dateOfBirthInput"));
        date.click();
        date.sendKeys(Keys.CONTROL, "a");
        date.sendKeys(birthday);
        date.sendKeys(Keys.ENTER);
    }

    default void selectGender(String gender) {
        if (gender.equals("Male")) {
            click(By.xpath("//label[@for='gender-radio-1']"));
        } else if (gender.equals("Female")) {
            click(By.xpath("//label[@for='gender-radio-2']"));
        } else {
            click(By.xpath("//label[@for='gender-radio-3']"));
        }
    }
}
