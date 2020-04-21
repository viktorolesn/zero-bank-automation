package stepDefs;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

import java.util.List;

public class LoginStepDefs {

    private WebDriver driver;
    final String WEB_URL = "http://zero.webappsecurity.com";

    private AccountSummaryPage objAccountSummaryPage;
    private HomePage objHomePage;
    private LoginPage objLoginPage;

   public LoginStepDefs(TestContext testContext){
       this.driver = testContext.getDriver();
       objAccountSummaryPage = new AccountSummaryPage(driver);
       objHomePage = new HomePage(driver);
       objLoginPage = new LoginPage(driver);
   }

    @Given("^User navigates to the page and logins with credentials$")
    public void navigateAndLogin(DataTable table){
        List<String> rawData = table.asList(String.class);
        driver.get(WEB_URL);
        objHomePage.clickSignInButton();
        objLoginPage.loginToZeroBank(rawData.get(0), rawData.get(1));
    }

    @When("^User navigates to the \"([^\"]*)\" page$")
    public void userNavigatesToThePage(String pageName)  {
        switch(pageName) {
            case "Transfer Funds":
                objAccountSummaryPage.clickTransferFunds();
                break;
            case "Add New Payee":
                objAccountSummaryPage.clickPayBills();
                objAccountSummaryPage.clickAddNewPayee();
                break;
            case "Pay Saved Payee":
                objAccountSummaryPage.clickPayBills();
                break;
        }
    }

}
