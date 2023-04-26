package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = " https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu, By by) {
        List<WebElement> names = driver.findElements(by);
        for (WebElement name : names) {
            if (name.getText().equalsIgnoreCase(menu)) {
                name.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserCanNavigateToComputerMenu () {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Computers')]"), "Computers");
        }
        @After
        public void tearDown () {
            // closeBrowser();
        }
    }
