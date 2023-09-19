package cssxpathlocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Cssxpath {
    WebDriver driver;

    @Test
    public void textBox(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        //WebElement inputName = driver.findElement(By.cssSelector("input[id='userName']"));
        WebElement inputName = driver.findElement(By.cssSelector("#userName"));
        System.out.println(inputName.getAttribute("placeholder"));
        WebElement textArea = driver.findElement(By.cssSelector("[placeholder='Current Address']"));
        System.out.println(textArea.getTagName());

        driver.quit();
    }

    @Test
    public void checkBox(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");
        WebElement svg = driver.findElement(By.cssSelector("span[class='rct-text']>label>span[class='rct-node-icon']>svg"));
        System.out.println(svg.getAttribute("stroke"));


        driver.quit();
    }

    @Test
    public void radioButton(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
        WebElement radioButton = driver.findElement(By.cssSelector("div[class='col-12 mt-4 col-md-6'] :nth-child(3) label"));
        System.out.println(radioButton.getText());


        driver.quit();
    }
}
