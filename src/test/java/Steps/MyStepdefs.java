package Steps;

import Base.BaseUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class MyStepdefs extends BaseUtil
{

    private  BaseUtil base;

    public MyStepdefs(BaseUtil base) {
        this.base = base;
    }



    @Given("^I navigate to  \"([^\"]*)\"$")
    public void iNavigateTo(String URLName) throws Throwable {
        System.out.println("Navigate To Amazon.com Page \n");
        base.Driver.navigate().to(URLName);
        base.Driver.manage().window().maximize() ;

    }

    @And("^I search for the item \"([^\"]*)\"$")
    public void iSearchForTheItem(String arg0) throws Throwable {
        WebDriverWait wait = new WebDriverWait(base.Driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        WebElement searchbar=base.Driver.findElement(By.id("twotabsearchtextbox"));
        searchbar.sendKeys("Nikon");
        base.Driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input")).submit();
    }

    @And("^I sort the results from highest to lowest price$")
    public void iSortTheResultsFromHighestToLowestPrice() throws Throwable {
        Select dropdown = new Select(base.Driver.findElement(By.xpath("//select[@id='sort']")));
        dropdown.selectByVisibleText("Price: High to Low");
        WebDriverWait wait = new WebDriverWait(base.Driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='centerPlus']/h3/span[1]")));

    }

    @When("^I selected and clicked the second product displayed$")
    public void iSelectedTheSecondProductDisplayed() throws Throwable {
        ( base.Driver.findElement(By.xpath("//li[@id='result_1']/div/div/div/div[1]/div/div/a/img"))).click();
        WebDriverWait wait = new WebDriverWait(base.Driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='add-to-cart-button']")));
    }


    @Then("^I verify that product topic contains text \"([^\"]*)\"$")
    public void iVerifyThatProductTopicContainsText(String searchtext) throws Throwable {

          Assert.assertTrue("***--- "+searchtext+" was not found ---***",base.Driver.getPageSource().contains(searchtext));
          System.out.println("The text "+searchtext+" was found in product details page");

    }
}
