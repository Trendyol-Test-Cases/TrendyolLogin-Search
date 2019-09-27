import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchPageTrendyol {
    protected WebDriver driver;
    public static String loginUrl = "https://www.trendyol.com";
    public static String favUrl = "https://www.trendyol.com/Hesabim/Favoriler";
    protected static WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/buketacl/Desktop/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,15);
        driver.manage().window().maximize();
    }
    @Test
    public void correctSearch() {
        Actions actions = new Actions(driver);

        driver.get(loginUrl);

        driver.findElement(By.className("homepage-popup-gender")).click();
        WebElement element = driver.findElement(By.cssSelector(".tab-link:nth-child(6) > .category-header"));
                actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Parfüm")));
        driver.findElement(By.linkText("Parfüm")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fltr-srch-inpt")));
        driver.findElement(By.cssSelector(".fltr-srch-inpt")).click();
        driver.findElement(By.cssSelector(".fltr-srch-inpt")).sendKeys("lacoste");
        driver.findElement(By.cssSelector(".fltrs:nth-child(3) .chckbox")).click();
        //driver.findElement(By.cssSelector(".p-card-wrppr:nth-child(7) .prdct-desc-cntnr-ttl")).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".p-card-wrppr:nth-child(7) .prdct-desc-cntnr-ttl")));
        WebElement element1 = driver.findElement(By.cssSelector(".p-card-wrppr:nth-child(7) .prdct-desc-cntnr-ttl"));
        String title= element1.getAttribute("title");
        driver.findElement(By.cssSelector(".p-card-wrppr:nth-child(7) .prdct-desc-cntnr-ttl")).click();
        driver.findElement(By.cssSelector(".fv-hv-img")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        driver.findElement(By.id("email")).sendKeys("buket.acl@gmail.com");
        driver.findElement(By.id("password")).sendKeys("DENEMESIFREGIRIMI");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(".icon\\ navigation\\-icon\\-favorites")));
        driver.navigate().to(favUrl);
        //driver.get(favUrl);
       // driver.findElement(By.id("favoritesButton")).click();
        WebElement element2 = driver.findElement(By.cssSelector(".p-card-wrppr:nth-child(1) .prdct-desc-cntnr-ttl"));
        String title2=element2.getAttribute("title");
        Assert.assertEquals(title,title2);

        System.out.println("Listedeki ürün ile favorilerdeki ürünün aynı olduğu görüldü");
    }

}
