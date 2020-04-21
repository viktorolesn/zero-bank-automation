package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class TransferFundsPage  {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Random randNum;
    private Select fromAcc;
    private Select toAcc;

    @FindBy(xpath="//*[@id=\"tf_fromAccountId\"]")
    private WebElement fromAccountSelect;

    @FindBy(xpath="//*[@id=\"tf_toAccountId\"]")
    private WebElement toAccountSelect;

    @FindBy(xpath="//*[@id=\"tf_amount\"]")
    private WebElement amountInput;
    
    @FindBy(xpath="//*[@id=\"tf_description\"]")
    private WebElement descriptionInput;

    @FindBy(xpath="//*[@id=\"btn_submit\"]")
    private WebElement submitButton;

    @FindBy(xpath="//*[@id=\"transfer_funds_content\"]/div/div/div[1]")
    private WebElement resultDiv;


    public TransferFundsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        randNum = new Random();
        PageFactory.initElements(driver, this); // try without this
    }   

    public void selectRandomAccountFrom(){
        fromAcc = new Select(fromAccountSelect);
        fromAcc.selectByIndex(randNum.nextInt(fromAcc.getOptions().size()));
    }

    public void selectRandomAccountTo(){
        toAcc = new Select(toAccountSelect);
        toAcc.selectByIndex(randNum.nextInt(toAcc.getOptions().size()));
    }

    public String getTextAccountFrom(){
        fromAcc = new Select(fromAccountSelect);
        return fromAcc.getFirstSelectedOption().getText();
    }

    public String getValueAttributeAccountFrom(){
        return fromAccountSelect.getAttribute("value");
    }

    public String getTextAccountTo(){
        toAcc = new Select(toAccountSelect);
        return toAcc.getFirstSelectedOption().getText();
    }

     public String getValueAttributeAccountTo(){
        return toAccountSelect.getAttribute("value");
    }

    public void typeAmount(String strAmount){
        amountInput.clear();
        amountInput.sendKeys(strAmount);
    }

    public String getValueAttributeAmount(){
        return amountInput.getAttribute("value");
    }

    public void typeDescription(String strDescription){
        descriptionInput.clear();
        descriptionInput.sendKeys(strDescription);
    }

    public String getValueAttributeDescription(){
        return descriptionInput.getAttribute("value");
    }

    public String getResultText(){
        return this.resultDiv.getText();
    }

    public void clickSubmit(){
        this.submitButton.click();
    }

    public void randomSelectAccounts(){
        selectRandomAccountFrom();
        selectRandomAccountTo();
    }
}