package PageObjectClases.TargetApp;

import PageObjectClases.BasePage;
import PageObjectClases.TargetApp._DashBoardsTab.DashboardsTab;
import PageObjectClases.TargetApp._MapTab.MapTab;
import PageObjectClases.TargetApp._SearchTab.SearchTab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.utilities.Assert;

/**
 * Created by guest on 12/25/15.
 */
public class NavigationBar extends BasePage {

    public NavigationBar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    // NEW INSPECTION
    @FindBy(linkText="New Inspection")
    WebElement createNewInspectionButton; // text field to enter request

    public  InspectionModal createNewInspection(){
        waitForLoading();
        clickElement(createNewInspectionButton);
        return new InspectionModal(super.driver); // return pop ap
    }

    // FACILITI INFO
    @FindBy(xpath = "//div[@id='home_details_container']//h2") WebElement facilityDetails_name;
    public String getFacilityDetails_name(){
        return facilityDetails_name.getText();
    }
    @FindBy(xpath = "//div[@id='home_details_container']//a[@title='Show on Map']") WebElement facilityDetails_showOnMap;
    public MapTab clickfacilityDetails_showOnMap (){
        clickElement(facilityDetails_showOnMap);
        waitForLoading();
        return new MapTab(driver);
    }


    // CALENDAR
    @FindBy(xpath = "//a[@title='calendar']") private WebElement calendarButton; //div[@id='home_navigation_buttons']

    public CalendarTab goToCalendar(){
        clickElement(calendarButton);
        waitForLoading();
        return new CalendarTab();
    }
    //MAP
    @FindBy(xpath = "//a[@title='Map']") private WebElement mapButton; //div[@id='home_navigation_buttons']

    public MapTab goToMap(){
        clickElement(mapButton);
        waitForLoading();
        return new MapTab(driver);
    }

    //SEARCH
    @FindBy(xpath = "//a[@title='Search']") private WebElement searchButton;
    public SearchTab goToSearch (){
        clickElement(searchButton);
        waitForLoading();
        return new SearchTab(driver);
    }

    //DASHBOARD
    @FindBy(xpath = "//a[@title='Dashboard']") private WebElement dashBoardsButton; //div[@id='home_navigation_buttons']
    public DashboardsTab goToDashBoard (){
        clickElement(dashBoardsButton);
        waitForLoading();
        return new DashboardsTab(driver);
    }


    public void waitForLoading(){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        (new WebDriverWait(driver,7)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(By.xpath("//div[@class='ui-loader-background']")).getCssValue("display").contains("none");
            }
        });
    }









}
