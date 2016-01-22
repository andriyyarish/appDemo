package PageObjectClases.TargetApp;

import PageObjectClases.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by guest on 01.12.15.
 */
public class InspectionModal extends BasePage {


    public InspectionModal(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }

    // NAME
    @FindBy(xpath = "//div[@id='modal_new_inspection-popup']//*[@id='modal_inspection_name']") private WebElement  inspectionName;
    public void setInspectionName(String name) {
       // wait.until(ExpectedConditions.elementToBeClickable(inspectionName));
        setElementText(inspectionName, name);
    }
    public String getInspectionName(){
        return inspectionName.getText();
    }
    // validation message
    @FindBy(xpath = "//div[@id='modal_new_inspection-popup']//label[@for='modal_inspection_name' and @class='error']") WebElement inspName_validation;
    public String getInspName_ValidMessage(){
        return inspName_validation.getText();
    }



    //TYPE
    @FindBy(xpath = "//div[@id='modal_new_inspection-popup']//select[@id='select-choice-mini']") private WebElement inspectionType;
    public void setInspectionType(String value){
        Select select = new Select(inspectionType);
        select.selectByVisibleText(value);
    }

    public String geInspectionType(){
        Select select = new Select(inspectionType);
        return select.getFirstSelectedOption().getText();
    }
    @FindBy(xpath = "//div[@id='modal_new_inspection-popup']//label[@for='select-choice-mini' and @class='error']") private WebElement inspType_ValidMessage;
    public String getInsptype_ValidMessage(){
        return inspType_ValidMessage.getText();
    }

    // DUEDATE
    @FindBy(xpath ="//div[@id='modal_new_inspection-popup']//*[@id='modal_inspection_dueDate']") private WebElement dueDateField;
    public void setDueDate()  {
        clickElement(dueDateField);
        driver.findElement(By.xpath("//div[@class='Zebra_DatePicker']//td[contains(text(),'27')]")).click(); // day could be set as parameter
    }
    public String getDueDate(){
        return dueDateField.getText();
        }
    // validation message
    @FindBy(xpath ="//div[@id='modal_new_inspection-popup']//label[@for='modal_inspection_dueDate' and @class='error']") private WebElement dueDate_ValidMessage;
    public String getDueDate_ValidMessage(){
        return dueDate_ValidMessage.getText();
    }


    @FindBy(id ="ni_start_inspection_btn") WebElement startInspectionBtn;
    public void clkStartInspection (){
        clickElement(startInspectionBtn);
    }

    @FindBy(id ="ni_save_btn") WebElement saveBtn;
    public void clkSave (){
        clickElement(startInspectionBtn);
    }

    @FindBy(xpath ="//div[@id='modal_new_inspection-popup']//a[contains(text(),'Close')]") WebElement closeModalBtn;
    public void clkCloseModal (){
        clickElement(closeModalBtn);
    }

    ////Inspectors tab
    @FindBy(xpath = "//div[@id='modal_new_inspection-popup']//label[@for='onechecked' and @class='error']") WebElement assignee_ValidMessage;
    public String getAssignee_ValidMessage (){
        return assignee_ValidMessage.getText();
    }


    public void setAssignee ( ){
        driver.findElement(By.xpath("//label[contains(text(),'Administrators')]")).click();
    }








}
