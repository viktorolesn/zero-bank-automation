package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id="login_form")
    private WebElement loginForm;

    @FindBy(id="user_login")
    private WebElement usernameInput;

    @FindBy(id="user_password")
    private WebElement passwordInput;

    @FindBy(xpath="//*[@id=\"login_form\"]/div[2]/input")
    private WebElement submitButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }   

    //Set username in username text input
    public void setUserName(String strUserName){
        usernameInput.clear();
        usernameInput.sendKeys(strUserName);     
    }

    //Set password in password text input
    public void setPassword(String strPassword){
        passwordInput.clear();
        passwordInput.sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin(){
        submitButton.click();
    }  
   
     
    //This POM method will be exposed in test case to login in the application
    public void loginToZeroBank(String strUserName, String strPassword){
        //Wait until form appears
        wait.until(ExpectedConditions.visibilityOf(loginForm));
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPassword);
        //Click Login button
        this.clickLogin();           
    }


}