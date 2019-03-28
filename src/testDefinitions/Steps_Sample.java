package testDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class Steps_Sample {
	WebDriver driver;
	static WebElement table;
	
	@Given("^Weather App Url is opened$")
	public void weather_App_Url_is_opened() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse progs\\driverserver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// open the url
		driver.get("http://localhost:3000/");
	}
	
	@Then("^User should be able to enter the \"([^\"]*)\"$")
	public void user_should_be_able_to_enter_the(String arg1) throws Throwable {
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(arg1);
		driver.findElement(By.id("city")).sendKeys(Keys.ENTER);
	}

	@Then("^User should see table of Data for the weather conditions$")
	public void user_should_see_table_of_Data_for_the_weather_conditions() throws Throwable {
		table = driver.findElement(By.xpath("//div[@data-reactroot]"));
	    Assert.assertEquals(true, table.isDisplayed());
	}

	@Then("^table should contain data for (\\d+) days$")
	public void table_should_contain_data_for_days(int arg1) throws Throwable {
	    Assert.assertEquals(arg1, driver.findElements(By.xpath("//div[@data-reactroot]/div")).size());  
	}

	@When("^User clicks on one of the weather conditions of a day$")
	public void user_clicks_on_one_of_the_weather_conditions_of_a_day() throws Throwable {
		driver.findElement(By.cssSelector("div.summary span")).click();
	}

	@Then("^User should see (\\d+) hours forecast$")
	public void user_should_see_hours_forecast(int arg1) throws Throwable {
		List<WebElement> hours = driver.findElements(By.xpath("(//div[@class='details'])[1]/div"));
		Assert.assertEquals(arg1, hours.size());
		for(WebElement element : hours) {
			Assert.assertEquals(true, element.isDisplayed());
		}
	}

	@Then("^User should see  All the required fields$")
	public void user_should_see_All_the_required_fields() throws Throwable {
		Assert.assertEquals(true, driver.findElement(By.xpath("//*[contains(@data-test,'description')]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//span[contains(@data-test,'maximum')]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//span[contains(@data-test,'minimum')]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//span[contains(@data-test,'speed')]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//span[contains(@data-test,'direction')]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//span[contains(@data-test,'rainfall')]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//span[contains(@data-test,'pressure')]")).isDisplayed());
	}
	
	@Then("^Application should be friendly for Accessibility$")
	public void application_should_be_friendly_for_accessibility() throws Throwable {
		Assert.assertEquals(true, driver.findElement(By.xpath("//*[contains(@data-test,'description')]")).getAttribute("innerHTML").contains("aria-label"));
		Assert.assertEquals(true, driver.findElement(By.xpath("//span[contains(@data-test,'maximum')]")).getAttribute("innerHTML").contains("aria-label"));
		Assert.assertEquals(true, driver.findElement(By.xpath("//span[contains(@data-test,'speed')]")).getAttribute("innerHTML").contains("aria-label"));
		Assert.assertEquals(true, driver.findElement(By.xpath("//span[contains(@data-test,'direction')]")).getAttribute("innerHTML").contains("aria-label"));
		Assert.assertEquals(true, driver.findElement(By.xpath("//span[contains(@data-test,'rainfall')]")).getAttribute("innerHTML").contains("aria-label"));
		Assert.assertEquals(true, driver.findElement(By.xpath("//span[contains(@data-test,'pressure')]")).getAttribute("innerHTML").contains("aria-label"));
	}

	@Then("^User should only see Rounded Value$")
	public void user_should_only_see_Rounded_Value() throws Throwable {
		Assert.assertEquals(false, driver.findElement(By.xpath("//span[contains(@data-test,'maximum')]")).getText().contains("."));
		Assert.assertEquals(false, driver.findElement(By.xpath("//span[contains(@data-test,'minimum')]")).getText().contains("."));
		Assert.assertEquals(false, driver.findElement(By.xpath("//span[contains(@data-test,'speed')]")).getText().contains("."));
		Assert.assertEquals(false, driver.findElement(By.xpath("//span[contains(@data-test,'direction')]")).getText().contains("."));
		Assert.assertEquals(false, driver.findElement(By.xpath("//span[contains(@data-test,'rainfall')]")).getText().contains("."));
		Assert.assertEquals(false, driver.findElement(By.xpath("//span[contains(@data-test,'pressure')]")).getText().contains("."));	
	}

	@When("^User clicks the Weather condition of a Day it should hide the (\\d+) hours forecast data$")
	public void user_clicks_the_Weather_condition_of_a_Day_it_should_hide_the_hours_forecast_data(int arg1) throws Throwable {
		driver.findElement(By.cssSelector("div.summary span")).click();
		List<WebElement> hours = driver.findElements(By.xpath("(//div[@class='details'])[1]/div"));
		for(WebElement element : hours) {
			Assert.assertEquals(false, element.isDisplayed());
		}
	}

	
	
}
