package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver driver;

    private final By logoutButton = By.xpath("//button[normalize-space(text()) = 'Выход']");
    private final By constructorLink = By.xpath("//p[text() = 'Конструктор']");
    private final By constructorLogo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    private final By constructorTitle = By.xpath("//h1[text()='Соберите бургер']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по ссылке конструктора")
    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }

    @Step("Проверка, что кнопка 'Выход' видна")
    public boolean isLogoutButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        return driver.findElement(logoutButton).isDisplayed();
    }

    @Step("Клик по логотипу Stellar Burgers")
    public void clickLogo() {
        driver.findElement(constructorLogo).click();
    }

    @Step("Проверка, что заголовок конструктора виден")
    public boolean isConstructorTitleVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(constructorTitle));
        return driver.findElement(constructorTitle).isDisplayed();
    }

    @Step("Клик по кнопке 'Выход'")
    public void clickLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
    }
}