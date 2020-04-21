package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountSummaryPage extends HomePage {

   private WebDriverWait wait;
    
    @FindBy(xpath="//*[@id=\"transfer_funds_tab\"]/a")
    private WebElement transferFundsLink;

    @FindBy(xpath="//*[@id=\"pay_bills_tab\"]/a")
    private WebElement payBillsLink;

    @FindBy(xpath="//*[@id=\"tabs\"]/ul/li[2]/a")
    private WebElement addNewPayeeLink;
    
    public AccountSummaryPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }   

    public void clickTransferFunds(){
        wait.until(ExpectedConditions.visibilityOf(transferFundsLink));
        transferFundsLink.click();
    }

    public void clickPayBills(){
        wait.until(ExpectedConditions.visibilityOf(payBillsLink));
        payBillsLink.click();
    }
    public void clickAddNewPayee(){
        wait.until(ExpectedConditions.visibilityOf(payBillsLink));
        payBillsLink.click();
        addNewPayeeLink.click();
    }

}