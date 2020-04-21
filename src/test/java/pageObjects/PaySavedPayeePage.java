package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PaySavedPayeePage extends TransferFundsPage{

    private Select payee;
    private Select account;

    @FindBy(id="sp_payee")
    private WebElement payeeSelect;

    @FindBy(id="sp_account")
    private WebElement accountSelect;

    @FindBy(id="sp_amount")
    private WebElement amountInput;

    @FindBy(id="sp_date")
    private WebElement dateInput;

    @FindBy(id="sp_description")
    private WebElement descriptionInput;

    @FindBy(id="pay_saved_payees")
    private WebElement paySavedPayeeButton;

    @FindBy(id="alert_content")
    private WebElement resultText;

    public PaySavedPayeePage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectRandomPayee(){
        payee = new Select(payeeSelect);
        payee.selectByIndex(randNum.nextInt(payee.getOptions().size()));
    }

    @Override
    public void selectRandomAccountFrom(){
        account = new Select(accountSelect);
        account.selectByIndex(randNum.nextInt(account.getOptions().size()));
    }

    public void selectRandomPayeeAndAccount(){
        this.selectRandomPayee();
        this.selectRandomAccountFrom();
    }

    public void setAmount(String strAmount){
        amountInput.clear();
        amountInput.sendKeys(strAmount);
    }

    public void setDate(String strDate){
        dateInput.clear();
        dateInput.sendKeys(strDate);
    }

    public void setDescription(String strDescription){
        descriptionInput.sendKeys(strDescription);
    }

    public void clickSubmitBtn(){
        paySavedPayeeButton.click();
    }

    @Override
    public String getResultText(){
        return resultText.getText();
    }

    public void paySavedPayee(String strAmount, String strDate, String strDescription){
        wait.until(ExpectedConditions.visibilityOf(payeeSelect));
        this.selectRandomPayeeAndAccount();
        this.setAmount(strAmount);
        this.setDate(strDate);
        this.setDescription(strDescription);
        this.clickSubmit();
    }

}