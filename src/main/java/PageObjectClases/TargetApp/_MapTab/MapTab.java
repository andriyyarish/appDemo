package PageObjectClases.TargetApp._MapTab;

import PageObjectClases.BasePage;
import PageObjectClases.TargetApp.NavigationBar;
import PageObjectClases.TargetApp._SearchTab.SearchTab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by guest on 12/25/15.
 */
public class MapTab extends NavigationBar {

    public MapTab (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@id='map_canvas']")
    private WebElement mapCanvas;

    public SearchTab clickFacilityMarker (String facilityName){
        mapCanvas.findElement(By.xpath("//div[@class='markerContainer' and @title='" + facilityName + "']")).click();
        waitForLoading();
        return new SearchTab(driver);
    }

    public String getNameFromFacilityMarker(){
       return mapCanvas.findElement(By.xpath("//div[@class='markerContainer']")).getAttribute("title");
    }

}
