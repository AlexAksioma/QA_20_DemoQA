package cssxpathlocators;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

        Point pointInputName = inputName.getLocation();

        System.out.println("x1= "+ inputName.getLocation().getX()+" y1="+inputName.getLocation().getY());
        System.out.println("x2= "+ textArea.getLocation().getX()+" y2="+textArea.getLocation().getY());
        Rectangle rectangle = inputName.getRect();
        System.out.println("x1rect = "+rectangle.getX()+" y1rect="+rectangle.getY()+" weight="+rectangle.getWidth()+" height="+rectangle.getHeight());
        Actions actions = new Actions(driver);
        actions.moveToElement(inputName,0,-270).click().perform();
        //actions.moveToElement(inputName, rectangle.getWidth()/2, -270).click().perform();
        //driver.quit();
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
