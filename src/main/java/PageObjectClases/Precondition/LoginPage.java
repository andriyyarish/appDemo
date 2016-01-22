package PageObjectClases.Precondition;

import PageObjectClases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by guest on 17.10.15.
 */



public class LoginPage extends BasePage {

    WebDriver driver ;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private String PAGE_URL = "https://production-customerlogin.qa.enviance.kiev.ua/CustomerLogin/CustomerLogin.aspx";
    private String PAGE_TITLE = "Enviance - Environmental ERP | GHG Software | Carbon Accounting";


    @FindBy(name= "UserName") WebElement userName_Field; // text box for login
    @FindBy(name = "Password") WebElement password_Field; // text box for pass
    @FindBy(name = "Login") WebElement login_Button; // clickable button


    public void openLoginPage(){
        setPAGE_TITLE(PAGE_TITLE);
        setPAGE_URL(PAGE_URL);
        loadPage();
    }
    public void setUserName_Field(String username) {setElementText(userName_Field, username);} // method inherited from PageObjectClases.BasePage class
    public void setPassword_Field(String password) {setElementText(password_Field, password);} // method inherited from PageObjectClases.BasePage class
    public void clickLoginButton(){login_Button.click();} // method inherited from PageObjectClases.BasePage class

    public MainSystemPage logIn (String username,String password){
        openLoginPage();
        setUserName_Field(username);
        setPassword_Field(password);
        clickLoginButton();

        return new MainSystemPage(super.driver);
    }

}
