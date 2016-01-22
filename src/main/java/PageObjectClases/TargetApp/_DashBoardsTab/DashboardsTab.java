package PageObjectClases.TargetApp._DashBoardsTab;

import PageObjectClases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by guest on 12/25/15.
 */
public class DashboardsTab extends BasePage {

    public DashboardsTab (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
