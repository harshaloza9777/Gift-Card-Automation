import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GiftSmart_RegisterFlow {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.get("https://giftsmartcard.cerebulb.com/");

            // Click on 'Request to Register'
            WebElement registerBtn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Request to Register")));
            registerBtn.click();

            // Wait for form to load
            Thread.sleep(3000);

            // 1️⃣ Entity Category
            Select entityCategory = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unit_category"))));
            entityCategory.selectByVisibleText("Developer");

            // 2️⃣ Application No
            WebElement appNo = driver.findElement(By.id("application_no"));
            appNo.clear();
            appNo.sendKeys("Harshal9777");

            // 3️⃣ Constitution of Business
            Select constitution = new Select(driver.findElement(By.id("constitution_of_business")));
            constitution.selectByVisibleText("Limited");

            // 4️⃣ Registration Number
            WebElement regNo = driver.findElement(By.name("registration_number"));
            regNo.clear();
            regNo.sendKeys("9777");

            // 5️⃣ PAN
            WebElement pan = driver.findElement(By.name("pan_number"));
            pan.clear();
            pan.sendKeys("AAA9898");

            // 6️⃣ Company Name
            WebElement companyName = driver.findElement(By.id("company_name"));
            companyName.clear();
            companyName.sendKeys("Cerebulb");

            // 7️⃣ Entity Tower Name (custom dropdown)
            WebElement towerDropdown = driver.findElement(By.cssSelector(
                    "#entity_detail_form > div.card-body.row > div:nth-child(2) > div:nth-child(3) > div > select"));
            js.executeScript("arguments[0].scrollIntoView(true);", towerDropdown);
            Select towerSelect = new Select(towerDropdown);
            towerSelect.selectByVisibleText("12-A, GIFT House");

            // 8️⃣ Country
            WebElement countryDropdown = driver.findElement(By.cssSelector(
                    "#entity_detail_form > div.card-body.row > div:nth-child(2) > div:nth-child(4) > div > div:nth-child(1) > select"));
            js.executeScript("arguments[0].scrollIntoView(true);", countryDropdown);
            Select countrySelect = new Select(countryDropdown);
            countrySelect.selectByVisibleText("India");

            // 9️⃣ State
            WebElement stateDropdown = driver.findElement(By.cssSelector(
                    "#entity_detail_form > div.card-body.row > div:nth-child(2) > div:nth-child(4) > div > div:nth-child(2) > select"));
            js.executeScript("arguments[0].scrollIntoView(true);", stateDropdown);
            Select stateSelect = new Select(stateDropdown);
            stateSelect.selectByVisibleText("Gujarat");

            // 🔟 City
            WebElement cityDropdown = driver.findElement(By.cssSelector(
                    "#entity_detail_form > div.card-body.row > div:nth-child(2) > div:nth-child(5) > div > div:nth-child(1) > select"));
            js.executeScript("arguments[0].scrollIntoView(true);", cityDropdown);
            Select citySelect = new Select(cityDropdown);
            citySelect.selectByVisibleText("Ahmedabad");

            // 1️⃣1️⃣ Pin Code
            WebElement pinCode = driver.findElement(By.cssSelector(
                    "#entity_detail_form > div.card-body.row > div:nth-child(2) > div:nth-child(5) > div > div:nth-child(2) > input"));
            pinCode.clear();
            pinCode.sendKeys("382421");

            // 1️⃣2️⃣ Save & Next button
            WebElement saveNextBtn = driver.findElement(By.cssSelector("#entity_detail_submit_button"));
            js.executeScript("arguments[0].scrollIntoView(true);", saveNextBtn);
            wait.until(ExpectedConditions.elementToBeClickable(saveNextBtn));
            saveNextBtn.click();

            System.out.println("✅ Form submitted successfully!");

            // Wait for response
            Thread.sleep(5000);

        } catch (Exception e) {
            System.out.println("❌ Error during automation: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
