package PageObjectClases.TargetApp._SearchTab;

import PageObjectClases.BasePage;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by guest on 12/26/15.
 */
public class SearchTab extends BasePage {
    public SearchTab(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
