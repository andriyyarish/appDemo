package PageObjectClases.TargetApp;

import PageObjectClases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by guest on 21.11.15.
 */
public class TargetAppHomePage extends BasePage {

    public TargetAppHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="home_facility_search_field") WebElement searchFacilityField; // text field to enter request
    public void searchForTheFacility(String facilityName) {
        setElementText(searchFacilityField, facilityName);


    }


    @FindBy(id ="home_facility_search_btn") WebElement searchFacilityButton; // clickable button which start search action as alternative we can use press enter
    ///////////


    @FindBy(xpath = "//*[@id='home_facility_listview']") WebElement homeFacilityListview;
   // @FindBy(id= "other") WebElement appFrame;








}
