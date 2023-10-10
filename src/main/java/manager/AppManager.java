package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface AppManager {

    ChromeOptions options = new ChromeOptions().addArguments("load-extension=C://Tools/5.10.1_0");
    WebDriver driver = new ChromeDriver(options);

    default void init(){
        driver.navigate().to("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    default void initAddOptions(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.navigate().to("https://demoqa.com/");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (String element: tabs) {
            System.out.println(element);
        }
        driver.switchTo().window(tabs.get(1)).close();
        driver.switchTo().window(tabs.get(0));

        driver.navigate().refresh();  //back    forward

    }

    default void tearDown(){
        driver.quit();
    }
}
