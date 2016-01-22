/**
 * Created by guest on 17.10.15.
 */

import PageObjectClases.Precondition.LoginPage;
import PageObjectClases.Precondition.MainSystemPage;
import PageObjectClases.TargetApp.InspectionModal;
import PageObjectClases.TargetApp.NavigationBar;
import PageObjectClases.TargetApp.TargetAppHomePage;
import PageObjectClases.TargetApp._MapTab.MapTab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

@Test(invocationCount = 10)
public class Test_Navigation {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    TargetAppHomePage targetAppHomePage;
    InspectionModal inspectionModal;
    MapTab mapTab;



    @BeforeClass(alwaysRun = true)
    public void setUp(){
       File profileDirectory = new File("/Users/guest/Library/Application Support/Firefox/Profiles/ujqqw140.AutoQA"); // open/init browser profile from system path !!! it is folder not single file
        FirefoxProfile profile = new FirefoxProfile(profileDirectory); // create an instance of FirefoxProfile which will use profile initialized before

        this.driver = new FirefoxDriver(profile); // set created created profile object as a parameter into driver constructor
        driver.manage().timeouts().implicitlyWait(7, SECONDS);
        wait = new WebDriverWait(driver,5);
        loginPage = PageFactory.initElements(driver, LoginPage.class); // initialize all elements from the class
         // launch the target app before tests from this class will run. In this way we should open target app only one time
        MainSystemPage mainSystemPage = loginPage.logIn("andy_auto","1111"); //login to thr main
        mainSystemPage.redirectToApp(); // open application using get.url + hash tag of app
        //new FacebookLoginPage(driver);
    }


      @AfterClass(alwaysRun = true)
      public void tearDown(){
          this.driver.quit();
      }


    @Test

    public void searchForFacility(){
        targetAppHomePage = new TargetAppHomePage(driver);
        targetAppHomePage.searchForTheFacility("77");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='home_sidebar']//li[@title='Facility77']")).isDisplayed());
        }

    @Test (dependsOnMethods = "searchForFacility")
    public void checkMapTab()  {
        NavigationBar bar = new NavigationBar(driver);
        bar.goToMap();
        Assert.assertTrue(driver.findElement(By.id("map_canvas")).isDisplayed());
    }

    @Test (dependsOnMethods = "checkMapTab")
    public void checkFacilityOnMapTab(){
        mapTab = new MapTab(driver);
        Assert.assertEquals(mapTab.getNameFromFacilityMarker(), "Facility77");
    }

    @Test (dependsOnMethods = "checkMapTab")
    public void checkFacilityOnMapTabToBeClickable(){
        mapTab = new MapTab(driver);
        mapTab.clickFacilityMarker("Facility77");
        Assert.assertTrue(driver.findElement(By.id("search")).isDisplayed());
    }


    @Test ()
    public void checkDashboardTab (){
        NavigationBar bar = new NavigationBar(driver);
        bar.goToDashBoard();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("dashboard"))));
        Assert.assertTrue(driver.findElement(By.id("dashboard")).isDisplayed());
    }
    @Test ()
    public void checkSearchTab(){
        NavigationBar bar = new NavigationBar(driver);
        bar.goToSearch();
        Assert.assertTrue(driver.findElement(By.id("search_field")).isDisplayed());
    }






/*
    @Test (dependsOnMethods = "searchForFacility")
    public void clickCreateInspectionbtn() throws InterruptedException {
        NavigationBar bar = new NavigationBar(driver);
        bar.createNewInspection();
        Assert.assertTrue(driver.findElement(By.id("modal_new_inspection-popup")).isDisplayed());
    }*/



}
