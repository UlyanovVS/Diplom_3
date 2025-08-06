package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    private final By bunsTab = By.xpath("//div[contains(@class, 'tab_tab__')]//span[text() = 'Булки']/parent::div");
    private final By saucesTab = By.xpath("//div[contains(@class, 'tab_tab__')]//span[text() = 'Соусы']/parent::div");
    private final By fillingsTab = By.xpath("//div[contains(@class, 'tab_tab__')]//span[text() = 'Начинки']/parent::div");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по вкладке 'Булки'")
    public void clickBunTab() {
        driver.findElement(bunsTab).click();
    }

    @Step("Клик по вкладке 'Соусы'")
    public void clickSauceTab() {
        driver.findElement(saucesTab).click();
    }

    @Step("Клик по вкладке 'Начинки'")
    public void clickFillingTab() {
        driver.findElement(fillingsTab).click();
    }

    @Step("Проверка, что вкладка 'Булки' активна")
    public boolean isBunTabActive() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(bunsTab, "class", "tab_tab_type_current"));
        return driver.findElement(bunsTab).getAttribute("class").contains("tab_tab_type_current");
    }

    @Step("Проверка, что вкладка 'Соусы' активна")
    public boolean isSauceTabActive() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(saucesTab, "class", "tab_tab_type_current"));
        return driver.findElement(saucesTab).getAttribute("class").contains("tab_tab_type_current");
    }

    @Step("Проверка, что вкладка 'Начинки' активна")
    public boolean isFillingTabActive() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(fillingsTab, "class", "tab_tab_type_current"));
        return driver.findElement(fillingsTab).getAttribute("class").contains("tab_tab_type_current");
    }
}