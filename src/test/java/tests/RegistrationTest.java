package tests;

import io.qameta.allure.Step;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    public static final String PASSWORD = "qwerty";
    public static final String SHORT_PASSWORD = "qwert";

    @Test
    @Step("Регистрация с валидными данными")
    public void successfulRegistration() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickPersonalAccount();
        loginPage.clickRegisterLink();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setName("Тестовый Пользователь");
        String email = "testuser" + System.currentTimeMillis() + "@mail.ru";
        registerPage.setEmail(email);
        registerPage.setPassword(PASSWORD);
        registerPage.clickRegisterButton();
        assertTrue(loginPage.isLoginButtonVisible());
        deleteSpecifiedUser(email, PASSWORD);
    }

    @Test
    @Step("Ошибка при регистрации с коротким паролем")
    public void registrationWithShortPasswordFails() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickPersonalAccount();
        loginPage.clickRegisterLink();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setName("TestUser");
        String email = "testuser" + System.currentTimeMillis() + "@mail.ru";
        registerPage.setEmail(email);
        registerPage.setPassword(SHORT_PASSWORD);
        registerPage.clickRegisterButton();
        By errorText = By.xpath("//p[contains(text(),'Некорректный пароль')]");
        assertTrue(driver.findElement(errorText).isDisplayed());
    }
}
