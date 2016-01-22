package PageObjectClases.Precondition;

import PageObjectClases.BasePage;
import PageObjectClases.TargetApp.TargetAppHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by guest on 21.11.15.
 */
public class MainSystemPage extends BasePage {

    public MainSystemPage(WebDriver driver) {
        super(driver);
    }

    public TargetAppHomePage redirectToApp(){
        driver.get("https://production.qa.enviance.kiev.ua/CustomApp/acee5147-c8c8-4ff1-9895-931bf87b8ea2/");
        return new TargetAppHomePage(super.driver);
    }
    public TargetAppHomePage appTabClick(){
        WebElement element = driver.findElement(By.id("09117917-0426-1439-5498-010347550894"));
        element.click();
        return new TargetAppHomePage(super.driver);


    }
}
