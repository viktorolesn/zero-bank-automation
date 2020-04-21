package stepDefs;
import org.testng.Assert;
import pageObjects.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class TransferFundsStepDefs {

    private WebDriver driver;

    private TransferFundsPage objTransferFundsPage;

    private String fromAccString = "";
    private String toAccString = "";
    private String amount = "";
    private String description = "";

    public TransferFundsStepDefs(TestContext testContext){
        this.driver = testContext.getDriver();
        objTransferFundsPage = new TransferFundsPage(driver);
    }

    @And("^User randomly selects accounts$")
    public void userRandomlySelectsAccounts()  {
        objTransferFundsPage.randomSelectAccounts();
        fromAccString = objTransferFundsPage.getTextAccountFrom();
        toAccString = objTransferFundsPage.getTextAccountTo();
    }

    @And("^User sets \"([^\"]*)\" as amount$")
    public void userSetsAsAmount(String strAmount) {
        objTransferFundsPage.typeAmount(strAmount);
        amount = strAmount;
    }

    @And("^User sets \"([^\"]*)\" as description$")
    public void userSetsAsDescription(String strDescription) {
        objTransferFundsPage.typeDescription(strDescription);
        description = strDescription;
    }

    @And("^User clicks submit$")
    public void userClicksSubmit() {
        objTransferFundsPage.clickSubmit();
    }

    @Then("^User makes sure input data is correct$")
    public void userMakesSureInputDataIsCorrect() {
        Assert.assertTrue(fromAccString.contains(objTransferFundsPage.getValueAttributeAccountFrom()));
        Assert.assertTrue(toAccString.contains(objTransferFundsPage.getValueAttributeAccountTo()));
        Assert.assertEquals(objTransferFundsPage.getValueAttributeAmount(), amount);
        Assert.assertEquals(objTransferFundsPage.getValueAttributeDescription(), description);
    }


    @Then("^\"([^\"]*)\" result message is shown$")
    public void resultMessageIsShown(String resultMsg){
        String expectedResult = resultMsg;
        String actualResult = objTransferFundsPage.getResultText();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
