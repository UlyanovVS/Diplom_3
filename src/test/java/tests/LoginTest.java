package tests;

import io.qameta.allure.Step;
import org.junit.Test;
import pages.LoginPage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    @Step("Вход через кнопку 'Войти в аккаунт' на главной")
    public void loginFromMainPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickMainLogin();
        loginPage.login(registrationRequest.email, registrationRequest.password);
        assertTrue("Кнопка 'Оформить заказ' не отображается", loginPage.isOrderButtonVisible());
    }

    @Test
    @Step("Вход через кнопку 'Личный кабинет'")
    public void loginFromAccountButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickPersonalAccount();
        loginPage.login(registrationRequest.email, registrationRequest.password);
        assertTrue("Кнопка 'Оформить заказ' не отображается", loginPage.isOrderButtonVisible());
    }

    @Test
    @Step("Вход через форму регистрации")
    public void loginFromRegisterPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickPersonalAccount();
        loginPage.clickRegisterLink();
        new RegisterPage(driver).clickLoginLink();
        loginPage.login(registrationRequest.email, registrationRequest.password);
        assertTrue("Кнопка 'Оформить заказ' не отображается", loginPage.isOrderButtonVisible());
    }

    @Test
    @Step("Вход через форму восстановления пароля")
    public void loginFromResetPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickPersonalAccount();
        loginPage.clickForgotPassword();
        loginPage.clickLoginFromReset();
        loginPage.login(registrationRequest.email, registrationRequest.password);
        assertTrue("Кнопка 'Оформить заказ' не отображается", loginPage.isOrderButtonVisible());
    }
}