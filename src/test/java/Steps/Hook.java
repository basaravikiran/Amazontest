package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Hook extends BaseUtil{


    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest()
    {

        System.out.println("Opening the browser : Chrome");

        /*System.setProperty("webdriver.firefox.marionette", "C:\\Python27\\Scripts\\geckodriver.exe");
        base.Driver = new FirefoxDriver();*/


        //Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Python27\\Scripts\\chromedriver.exe");
        base.Driver = new ChromeDriver();
    }


    @After
    public void TearDownTest(Scenario scenario) {
        base.Driver.close();
    }

}
