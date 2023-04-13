import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class MyStepdefs_seleniumform {
    WebDriver driver;

    @Given("User launches Firefox browser")
    public void userLaunchesFirefoxBrowser() {
        System.setProperty("webdriver.gecko.driver", "/Users/Triin/IdeaProjects/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
    }

    @When("User opens form webpage")
    public void userOpensFormWebpage() {
        driver.get("https://automationexplore.com/selenium-automation-practice-page/");
    }

    @Then("User enters first and last name")
    public void userEntersFirstAndLastName() {
        driver.findElement(By.id("firstname")).sendKeys("Triin");
        driver.findElement(By.id("lastname")).sendKeys("Evard");
    }

    @And("User enters email")
    public void userEntersEmail() {
        driver.findElement(By.id("email")).sendKeys("triin.evard@gmail.com");
    }

    @And("User chooses gender and profession")
    public void userChoosesGenderAndProfession() {
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.xpath("//input[@value='freelancer']")).click();
    }

    @And("User selects country and skills")
    public void userSelectsCountryAndSkills() {
        Select country = new Select(driver.findElement(By.name("country")));
        country.selectByVisibleText("Australia");
        Select skills = new Select(driver.findElement(By.name("skills")));
        skills.selectByVisibleText("Manual Testing");

    }

    @And("User clicks the button")
    public void userClicksTheButton() {
        driver.findElement(By.id("alertbutton")).click();
        Alert alertObj = driver.switchTo().alert();
        alertObj.accept();
    }
}
