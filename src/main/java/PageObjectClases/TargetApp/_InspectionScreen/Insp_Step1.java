package PageObjectClases.TargetApp._InspectionScreen;

import PageObjectClases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by guest on 12/27/15.
 */
public class Insp_Step1 extends Insp_BasePage {

    public Insp_Step1(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="inspection_new_btn")
    private WebElement startInspectionButton;

    public Insp_Step2 clkStartInspection(){
        clickElement(startInspectionButton);
        return new Insp_Step2(driver);
    }

    @FindBy(id="inspection_new_area_btn")
    private WebElement newInspectionPointButton;
    // should return pop up where new Inspection point will be configured and created
    public void clkNewInspectionPoint(){
        clickElement(newInspectionPointButton);
    }

    @FindBy(id="inspection_select_all_areas_btn") WebElement selectAllButton;
    public void clkSelectAll(){
        clickElement(selectAllButton);
    }

    @FindBy(id="inspection_remove_all_areas_btn") WebElement removeAllButton;
    public void clkRemoveAll(){
        clickElement(removeAllButton);
    }

    public void selectInspPointFromRelevList(String inspPoint){
        clickElement(driver.findElement(By.xpath("//ul[@id='inspection_relevant_areas_list']//a[contains(text(),'"+ inspPoint + "')]")));
    }

    public void deselectInspPointFromSelectList(String inspPoint){
        clickElement(driver.findElement(By.xpath("//ul[@id='inspection_selected_areas_list']//a[contains(text(),'"+ inspPoint + "')]")));
    }


    public List<WebElement> getSelectedInspectionsList(){
        List<WebElement> selectedInspectionsList = driver.findElements(By.xpath("//ul[@id='inspection_selected_areas_list']//a"));
        return selectedInspectionsList;
    }

    public List<WebElement> getRelevantInspectionsList(){
        List<WebElement> relevantInspectionsList = driver.findElements(By.xpath("//ul[@id='inspection_relevant_areas_list']//a"));
        return relevantInspectionsList;
    }





}
