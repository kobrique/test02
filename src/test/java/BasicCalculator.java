
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class BasicCalculator {
	private WebDriver driver;
	JavascriptExecutor js;
	
	

	@BeforeEach
	void setUp() throws Exception {
		js = (JavascriptExecutor) driver;
		System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterEach
	void tearDown() throws Exception {
		TimeUnit.SECONDS.sleep(3);
		driver.quit();
	}
	
	@Test
	void test01() {
		driver.navigate().to("https://testsheepnz.github.io/BasicCalculator.html");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector("footer")));
		new Select(driver.findElement(By.id("selectBuild"))).selectByVisibleText("Prototype");
	    driver.findElement(By.id("number1Field")).clear();
	    driver.findElement(By.id("number1Field")).sendKeys("2");
	    driver.findElement(By.id("number2Field")).clear();
	    driver.findElement(By.id("number2Field")).sendKeys("3");
	    driver.findElement(By.id("selectOperationDropdown")).click();
	    new Select(driver.findElement(By.id("selectOperationDropdown"))).selectByVisibleText("Subtract");
	    driver.findElement(By.id("calculateButton")).click();
	    assertEquals("-1", driver.findElement(By.xpath("//input[@id='numberAnswerField']")).getAttribute("value"));
	}
	
	@Test
	void test02() {
		driver.navigate().to("https://testsheepnz.github.io/BasicCalculator.html");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector("footer")));
		new Select(driver.findElement(By.id("selectBuild"))).selectByVisibleText("Prototype");
	    driver.findElement(By.id("number1Field")).clear();
	    driver.findElement(By.id("number1Field")).sendKeys("gs");
	    driver.findElement(By.id("number2Field")).clear();
	    driver.findElement(By.id("number2Field")).sendKeys("bu");
	    driver.findElement(By.id("selectOperationDropdown")).click();
	    new Select(driver.findElement(By.id("selectOperationDropdown"))).selectByVisibleText("Concatenate");
	    driver.findElement(By.id("calculateButton")).click();
	    assertEquals("gsbu", driver.findElement(By.xpath("//input[@id='numberAnswerField']")).getAttribute("value"));
	}
	
	@Test
	void test03() throws InterruptedException {
		driver.navigate().to("https://testsheepnz.github.io/random-number.html");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector("footer")));
		new Select(driver.findElement(By.id("buildNumber"))).selectByVisibleText("Demo");
	    driver.findElement(By.id("rollDiceButton")).click();
	    TimeUnit.SECONDS.sleep(1);
	    driver.findElement(By.id("numberGuess")).clear();
	    driver.findElement(By.id("numberGuess")).sendKeys("string");
	    driver.findElement(By.id("submitButton")).click();
	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector("footer")));
	    assertEquals("string: Not a number!", driver.findElement(By.xpath("//*[@id=\"feedbackLabel\"]/font/b/i")).getText());
	}

}
