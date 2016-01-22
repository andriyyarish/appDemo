package PageObjectClases.TargetApp._InspectionScreen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by guest on 12/27/15.
 */
public class Insp_Step2 extends Insp_BasePage {

    public Insp_Step2(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
