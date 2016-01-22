/**
 * Created by guest on 17.10.15.
 */

import PageObjectClases.Precondition.LoginPage;
import PageObjectClases.Precondition.MainSystemPage;
import PageObjectClases.TargetApp.InspectionModal;
import PageObjectClases.TargetApp.NavigationBar;
import PageObjectClases.TargetApp.TargetAppHomePage;
import PageObjectClases.TargetApp._InspectionScreen.Insp_Step1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static java.util.concurrent.TimeUnit.SECONDS;


public class Test_InsWF {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    TargetAppHomePage targetAppHomePage;
    NavigationBar navBar;
    InspectionModal inspModal;
    Insp_Step1 step1;



    @BeforeClass(alwaysRun = true)
    public void setUp(){
       File profileDirectory = new File("/Users/guest/Library/Application Support/Firefox/Profiles/ujqqw140.AutoQA"); // open/init browser profile from system path !!! it is folder not single file
        FirefoxProfile profile = new FirefoxProfile(profileDirectory); // create an instance of FirefoxProfile which will use profile initialized before

        this.driver = new FirefoxDriver(profile); // set created created profile object as a parameter into driver constructor
        driver.manage().timeouts().implicitlyWait(8, SECONDS);
        wait = new WebDriverWait(driver,8);
        loginPage = PageFactory.initElements(driver, LoginPage.class); // initialize all elements from the class
         // launch the target app before tests from this class will run. In this way we should open target app only one time
        MainSystemPage mainSystemPage = loginPage.logIn("andy_auto","1111"); //login to thr main
        mainSystemPage.redirectToApp(); // open application using get.url + hash tag of app
        //new FacebookLoginPage(driver);
    }


     /* @AfterClass(alwaysRun = true)
      public void tearDown(){
          this.driver.quit();
      }
*/

    @Test

    public void searchForFacility(){
        targetAppHomePage = new TargetAppHomePage(driver);
        targetAppHomePage.searchForTheFacility("77");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='home_sidebar']//li[@title='Facility77']")).isDisplayed());
        }

    @Test (dependsOnMethods = "searchForFacility")
    public void checkValidationMessage_NameField() throws InterruptedException {
        navBar = new NavigationBar(driver);
        inspModal = navBar.createNewInspection();
        inspModal.setDueDate();
        inspModal.clkStartInspection();
        Assert.assertEquals(inspModal.getInspName_ValidMessage(), "This field is required.");
        inspModal.clkCloseModal();
    }
    @Test (dependsOnMethods = "checkValidationMessage_NameField")
    public void checkValidationMessage_TypeField() throws InterruptedException {
        navBar = new NavigationBar(driver);
        inspModal = navBar.createNewInspection();
        inspModal.setInspectionName("aaaaaaaaaaa");
        inspModal.clkStartInspection();
        Assert.assertEquals(inspModal.getInsptype_ValidMessage(), "This field is required.");
        inspModal.clkCloseModal();
    }

    @Test (dependsOnMethods = "checkValidationMessage_TypeField")
    public void checkValidationMessage_Assignee() throws InterruptedException {
        Thread.sleep(300);
        System.out.println(driver.findElement(By.xpath("//div[@class='ui-loader-background']")).
                getCssValue("display").toString());// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-loader-background")));*/
        navBar = new NavigationBar(driver);
        inspModal = navBar.createNewInspection();
        inspModal.setInspectionName("yarish");
        inspModal.setInspectionType("NEW_TypeDef");
        inspModal.setDueDate();
        inspModal.clkStartInspection();
        Assert.assertEquals(inspModal.getAssignee_ValidMessage(), "Select at least one assignee before proceeding.");
    }

    @Test (dependsOnMethods = "checkValidationMessage_Assignee")
    public void checkCreateInspectionAction() throws InterruptedException {
        inspModal = new InspectionModal(driver);
        inspModal.setAssignee();
        inspModal.clkStartInspection();


        WebElement element = driver.findElement(By.id("inspection_selected_areas_list"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Assert.assertTrue(element.isDisplayed());
    }

    @Test
    public void checkActionsOnFirstStep(){
        step1 = new Insp_Step1(driver);
        step1.clkRemoveAll();
        step1.clkSelectAll();
        step1.clkRemoveAll();
        step1.selectInspPointFromRelevList("scratch");

        Assert.assertEquals(step1.getSelectedInspectionsList().size(), 1);
    }

    @Test
    public void checkTransitionToSecondStep_InspIsNotStarted () {
        step1 = new Insp_Step1(driver);
        step1.goToNextStep();
        WebElement warn = driver.findElement(By.xpath("//p[contains (text(),'Start Inspection before proceeding.')]"));
        Assert.assertTrue(warn.isDisplayed());
        step1.clickElement(driver.findElement(By.xpath("//div[@id='app_warning_popup']//a[contains(text(),'Ok')]")));

    }

/*
    @Test (dependsOnMethods = "checkCreateInspectionPopUp")
    public void checkStartinspectionButton( ) {
        inspModal = new InspectionModal(driver);
        inspModal.clkStartInspection();
        driver.findElement(By.xpath("//div[@id='modal_new_inspection-popup']//*[contains(text(),'Administrators')]")).click();
        inspModal.clkStartInspection();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inspection_selected_areas_list']")));
        driver.findElement(By.xpath("//*[@id='inspection_selected_areas_list']")).click();

    }




/*
    @Test (dependsOnMethods = "searchForFacility")
    public void clickCreateInspectionbtn() throws InterruptedException {
        NavigationBar bar = new NavigationBar(driver);
        bar.createNewInspection();
        Assert.assertTrue(driver.findElement(By.id("modal_new_inspection-popup")).isDisplayed());
    }*/



}
