package codenboxautomationlab1.codenboxautomationlab1;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

	WebDriver driver = new ChromeDriver();
	String URL ="https://codenboxautomationlab.com/practice/";
	Random rand = new Random();

	@BeforeTest
	public void mySetup() {
		driver.get(URL);
		driver.manage().window().maximize();
	}

	
	@Test(priority = 1)
	public void RadioButton() {

		List<WebElement> AllRadioButton = driver.findElements(By.className("radioButton"));
		int totalRadioButtons = driver.findElements(By.className("radioButton")).size();
		// this is to select random radio button
		int RandomRadioButtonIndex = rand.nextInt(totalRadioButtons);
		
		AllRadioButton.get(RandomRadioButtonIndex).click();

		/* if you need to select spcific raido button to be clicked
		 * AllRadioButton.get(0).click(); 
		 * AllRadioButton.get(1).click();
		 * AllRadioButton.get(2).click();
		 * 
		 */
	}

	@Test(priority =2)
	public void Dynamic_Dropdown() throws InterruptedException {
		String[] countryPrefixes = { "Un", "Ca", "Ge", "Fr", "It", "Sp", "In", "Br", "Ch", "Au" };
		WebElement InputField = driver.findElement(By.id("autocomplete"));
		int RandomCountryIndex = rand.nextInt(countryPrefixes.length);

		InputField.sendKeys(countryPrefixes[RandomCountryIndex]);
		Thread.sleep(2000);
		InputField.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));

	}
	
	@Test(priority = 3)
	public void Static_Dropdown () {
       
		WebElement Dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(Dropdown);
		List<WebElement> Option = select.getOptions();
		int RandomDropdownIndex = rand.nextInt(Option.size()-1)+1;
		select.selectByIndex(RandomDropdownIndex);
		
		
		
	}
}
