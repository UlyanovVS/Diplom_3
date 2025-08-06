package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    private final By mainLoginButton = By.xpath("//button[text() = 'Войти в аккаунт']");
    private final By personalAccountButton = By.xpath("//p[text() = 'Личный Кабинет']");
    private final By emailInput = By.xpath("//input[@name = 'name' or @name='email']");
    private final By passwordInput = By.xpath("//input[@name = 'Пароль' or @type='password']");
    private final By loginButton = By.xpath("//button[text() = 'Войти']");
    private final By orderButton = By.xpath("//button[text() = 'Оформить заказ']");
    private final By registerLink = By.xpath("//a[text() = 'Зарегистрироваться']");
    private final By forgotPasswordLink = By.xpath("//a[text() = 'Восстановить пароль']");
    private final By loginFromResetLink = By.xpath("//a[text() = 'Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке 'Войти в аккаунт' на главной странице")
    public void clickMainLogin() {
        driver.findElement(mainLoginButton).click();
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickPersonalAccount() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Ввод email и пароля, нажатие кнопки 'Войти'")
    public void login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Step("Проверка видимости кнопки 'Оформить заказ'")
    public boolean isOrderButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        return driver.findElement(orderButton).isDisplayed();
    }

    @Step("Проверка видимости кнопки 'Войти'")
    public boolean isLoginButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        return driver.findElement(loginButton).isDisplayed();
    }

    @Step("Клик по ссылке 'Зарегистрироваться'")
    public void clickRegisterLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(registerLink));
        driver.findElement(registerLink).click();
    }

    @Step("Клик по ссылке 'Восстановить пароль'")
    public void clickForgotPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        driver.findElement(forgotPasswordLink).click();
    }

    @Step("Клик по ссылке 'Войти' на странице восстановления пароля")
    public void clickLoginFromReset() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginFromResetLink));
        driver.findElement(loginFromResetLink).click();
    }
}