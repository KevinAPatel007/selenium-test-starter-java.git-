package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.CommonPage;

import java.util.List;

public class CommonStepdefs extends CommonPage {


    @Given("I go to url {string}")
    public static void iGoToUrl(String url) {
        getUrl(url);
    }

    @And("I select the {string} link")
    public void iSelectTheFindCompanyInformationLink(String linkText) throws InterruptedException {
        Thread.sleep(10000);
        switch (linkText){
            case "Find company information":
                clickOnCompanyInformation();
                break;
            case "GREGGS PLC":
                clickOnFirstCompanyLink();
                break;
        }

    }

    @Then("I should be on the {string} page")
    public void iShouldBeOnTheGetInformationAboutACompanyPage(String expectedText) {
        String actualText = CompanyInformationPageText();
        Assert.assertEquals("Doesn't match", actualText, expectedText);
    }

    @And("I click the Start now button")
    public void iClickTheStartNowButton() {
         clickStartButton();
    }

    @When("I search for company {string} and view the company details")
    public void iSearchForCompanyGREGGSPLCAndViewTheCompanyDetails(String testData) {
         enterDataInSearchBox(testData);
    }

    @Then("I validate that the details are displayed")
    public void iValidateThatTheDetailsAreDisplayed(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        String CompanyStatusExpected = data.get(1).get(1);
        String CompanyTypeExpected = data.get(1).get(1);
        String IncorporatedExpected = data.get(3).get(1);


        System.out.println("CompanyStatus " + CompanyStatusExpected);
        System.out.println("CompanyType " + CompanyTypeExpected);

        String CompanyStatusActual = driver.findElement(By.id("company-status")).getText();
        String CompanyTypeActual = driver.findElement(By.id("company-type")).getText();
        String IncorporatedActual = driver.findElement(By.id("company-creation-date")).getText();

        Assert.assertEquals(CompanyStatusExpected, CompanyStatusActual);
        Assert.assertEquals(CompanyTypeExpected, CompanyTypeActual);
        Assert.assertEquals(IncorporatedExpected, IncorporatedActual);
    }


    @And("I accept the cookie session")
    public void iAcceptTheCookieSession() throws InterruptedException {
        acceptCookie();
    }
}
