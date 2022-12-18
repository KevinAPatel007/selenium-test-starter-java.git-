package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Driver;

public class CommonPage extends Driver {

    @FindBy(linkText = "https://www.gov.uk/get-information-about-a-company")
    public WebElement findCompanyInfoLink;

//    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/h1")
//    public WebElement companyInformationPageText;


    @FindBy(xpath = "//*[@id='get-started']/a")
    public WebElement startBtn;

    @FindBy(xpath = "//*[@id='get-started']/a")
    public WebElement cokkieBtn;

    @FindBy(id = "site-search-text")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@id='results']/li[1]/h3/a")
    public WebElement clickFirstCompanyLink;

    @FindBy(id = "global-cookie-message")
    public WebElement cokkieClick;


    public static void getUrl(final String url) {
        driver.navigate().to(url);
    }

    public void clickOnCompanyInformation(){
      findCompanyInfoLink.click();
    }

    public String CompanyInformationPageText(){
        return driver.getTitle();
    }

    public void clickStartButton(){
        startBtn.click();
    }

    public void enterDataInSearchBox(String testData){
       searchBox.sendKeys(testData);
    }

    public void clickOnFirstCompanyLink(){
       clickFirstCompanyLink.click();
    }

    public void acceptCookie() throws InterruptedException {
        Thread.sleep(2000);
        cokkieClick.click();
    }



}
