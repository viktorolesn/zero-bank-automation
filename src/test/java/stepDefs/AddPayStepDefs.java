package stepDefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.*;

public class AddPayStepDefs {

    private WebDriver driver;

    private AddNewPayeePage objAddNewPayeePage;
    private PaySavedPayeePage objPaySavedPayee;

    public AddPayStepDefs(TestContext testC){
        this.driver = testC.getDriver();
        objAddNewPayeePage = new AddNewPayeePage(driver);
        objPaySavedPayee = new PaySavedPayeePage(driver);
    }

    @And("^User types \"([^\"]*)\" as user's name$")
    public void userTypesAsUserSName(String strName) {
        objAddNewPayeePage.setNewName(strName);
    }

    @And("^User types \"([^\"]*)\" as address$")
    public void userTypesAsAddress(String strAddress) {
        objAddNewPayeePage.setAddress(strAddress);
    }

    @And("^User types \"([^\"]*)\" as account number$")
    public void userTypesAsAccountNumber(String strAcc) {
        objAddNewPayeePage.setAccount(strAcc);
    }

    @And("^User types \"([^\"]*)\" as details$")
    public void userTypesUserDetailsAsDetails(String strDetails){
        objAddNewPayeePage.setDetails(strDetails);
    }

    @And("^User clicks on Add button$")
    public void userClicksOnAddButton() {
        objAddNewPayeePage.clickSubmit();
    }

    @Then("^\"([^\"]*)\" add payee message is shown;$")
    public void addPayeeMessageIsShown(String resultMsg) {
        String expectedResult = resultMsg;
        String actualResult = objAddNewPayeePage.getResultText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @And("^User types \"([^\"]*)\" as amount$")
    public void userTypesAsAmount(String strAmount) {
        objPaySavedPayee.setAmount(strAmount);
    }

    @And("^User types \"([^\"]*)\" as date$")
    public void userTypesAsDate(String strDate) {
        objPaySavedPayee.setDate(strDate);
    }

    @And("^User types \"([^\"]*)\" as description$")
    public void userTypesAsDescription(String strDescription) {
        objPaySavedPayee.setDescription(strDescription);
    }

    @And("^User clicks on Pay button$")
    public void userClicksOnPayButton() {
        objPaySavedPayee.clickSubmitBtn();
    }

    @Then("^\"([^\"]*)\" payment result is shown;$")
    public void paymentResultIsShown(String resultMsg) {
        String expectedResult = resultMsg;
        String actualResult = objPaySavedPayee.getResultText();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
