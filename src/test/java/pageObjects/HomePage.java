package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    protected WebDriver driver;

    @FindBy(id="signin_button")
    private WebElement singInButton;

    @FindBy(xpath="//*[@id=\"settingsBox\"]/ul/li[3]/a ")
    private WebElement userContextMenuLink;

    @FindBy(id="logout_link")
    private WebElement logOutLink;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }   

    //Click Sign In Button on Home Page
    public void clickSignInButton(){
        this.singInButton.click();
    }

    //Click user to make context menu appear 
    public void clickContextMenu(){
        userContextMenuLink.click();
    }

    //Click the log out button ( ONLY on context menu )
    public void clickSignOut(){
        logOutLink.click();
    }

    //This POM method will be exposed in test case to logout from the application
    public void logOutUser(){
        clickContextMenu();
        clickSignOut();
    }
}
