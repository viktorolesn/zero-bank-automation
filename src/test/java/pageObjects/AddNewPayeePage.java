package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddNewPayeePage extends TransferFundsPage{

    @FindBy(id="np_new_payee_name")
    private WebElement newNameInput;

    @FindBy(id="np_new_payee_address")
    private WebElement newAddressInput;

    @FindBy(id="np_new_payee_account")
    private WebElement newAccountInput;

    @FindBy(id="np_new_payee_details")
    private WebElement newDetailsInput;

    @FindBy(xpath="//*[@id=\"add_new_payee\"]")
    private WebElement newPayeeButton;

    @FindBy(id="alert_content")
    private  WebElement resultText;


    public AddNewPayeePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }   

    public void setNewName(String strName){
        wait.until(ExpectedConditions.visibilityOf(newNameInput));
        newNameInput.clear();
        newNameInput.sendKeys(strName);
    }

     public void setAddress(String strAddress){
        newAddressInput.clear();
        newAddressInput.sendKeys(strAddress);
    }

     public void setAccount(String strAccount){
        newAccountInput.clear();
        newAccountInput.sendKeys(strAccount);
    }

     public void setDetails(String strDetails){
        newDetailsInput.clear();
        newDetailsInput.sendKeys(strDetails);
    }

    @Override
    public void clickSubmit(){
        newPayeeButton.click();
    }

    @Override
    public String getResultText(){
        return resultText.getText();
    }

    public void addNewPayee(String strName, String strAddress, String strAccount, String strDetails){
        wait.until(ExpectedConditions.visibilityOf(newNameInput));
        setNewName(strName);
        setAddress(strAddress);
        setAccount(strAccount);
        setDetails(strDetails);
        clickSubmit();
    }

}