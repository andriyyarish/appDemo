package PageObjectClases.TargetApp._InspectionScreen;

import PageObjectClases.BasePage;
import PageObjectClases.TargetApp.NavigationBar;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by guest on 12/27/15.
 */
public class Insp_BasePage extends NavigationBar {
    public Insp_BasePage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // 1STEP
    @FindBy(xpath = ".//*[@id='inspection_progress_indicator']/li[1]")
    private WebElement firstStepButton;

    public Insp_Step1 goToFirstStep(){
        clickElement(firstStepButton);
        return new Insp_Step1(driver);
    }
    //2 STEP
    @FindBy(xpath = ".//*[@id='inspection_progress_indicator']/li[2]")
    private WebElement secondStepButton;

    public Insp_Step2 goToSecondStep(){
        clickElement(firstStepButton);
        return new Insp_Step2(driver);
    }

    // 3 STEP
    @FindBy(xpath = ".//*[@id='inspection_progress_indicator']/li[3]")
    private WebElement thirdStepButton;

    public Insp_Step3 goToThirdStep(){
        clickElement(firstStepButton);
        return new Insp_Step3(driver);
    }

    // Back-Forward navigation
    @FindBy(id="inspection_prev_step_btn")
    private WebElement prevStepButton;
    public void goToPrevStep(){
        clickElement(prevStepButton);
    }
    @FindBy(id="inspection_next_step_btn")
    private WebElement nextStepButton;
    public void goToNextStep(){
        clickElement(nextStepButton);
    }

    // REPORT
    @FindBy(id="inspection_report_btn")
    private WebElement reportButton;
    @FindBy(xpath = ".//ul[@id='modal_action_menu']/li[1]/a")
    private WebElement report_PrintButton;
    @FindBy(xpath = ".//ul[@id='modal_action_menu']/li[2]/a")
    private WebElement report_SaveAsPDFImageButton;
    @FindBy(xpath = ".//ul[@id='modal_action_menu']/li[3]/a")
    private WebElement report_SaveAsPDFButton;

    public void genPrintReport() {
        clickElement(reportButton);
        clickElement(report_PrintButton);
    }

    public void genPDFImageReport(){
        clickElement(reportButton);
        clickElement(report_SaveAsPDFImageButton);
    }

    public void genPDFReport(){
        clickElement(reportButton);
        clickElement(report_SaveAsPDFButton);
    }

    // SAVE CLOSE ACTIONS
    @FindBy(id="inspection_save_btn")
    private WebElement saveProgressButton;
    public void clkSaveProgress(){
        clickElement(saveProgressButton);
    }

    @FindBy(id="inspection_save_btn")
    private WebElement markCompleteButton;
    public void clkMarkComplete(){
        clickElement(markCompleteButton);
    }




}
