package PageObjectClases; /**
 * Created by guest on 21.11.15.
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by guest on 10.11.15.
 */
public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver){ this.driver=driver;} // this is constructor for basepage with wait


    private String PAGE_URL ;
    public void setPAGE_URL(String PAGE_URL) {
        this.PAGE_URL = PAGE_URL;
    }

    private String  PAGE_TITLE;
    public void setPAGE_TITLE(String PAGE_TITLE) {
        this.PAGE_TITLE = PAGE_TITLE;
    }


    public void loadPage(){
        driver.get(getPAGE_URL());
        Assert.assertEquals(driver.getTitle(), getPAGE_TITLE());
    }

    public void clickElement(WebElement element)  {
        element.click();
        // nee to create special metod which need to wait untill loader disappear
         } // method for clicking the button which will be set as parametr into the method

    public void setElementText(WebElement element, String text){  // method like a global setter for all Webelement object
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);

    }

    public String getPAGE_URL() {return PAGE_URL; }
    public String getPAGE_TITLE(){ return PAGE_TITLE; }



}
