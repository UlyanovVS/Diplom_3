package tests;

import io.qameta.allure.Step;
import org.junit.Test;
import pages.LoginPage;
import pages.ProfilePage;

import static org.junit.Assert.assertTrue;

public class ProfileTest extends BaseTest {

    @Step("Вход в систему как зарегистрированный пользователь")
    private void loginAsDefaultUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickPersonalAccount();
        loginPage.login(registrationRequest.email, registrationRequest.password);
    }

    @Test
    @Step("Переход в личный кабинет")
    public void goToProfile() {
        loginAsDefaultUser();
        new LoginPage(driver).clickPersonalAccount();
        assertTrue(new ProfilePage(driver).isLogoutButtonVisible());
    }

    @Test
    @Step("Переход в конструктор по кнопке")
    public void goToConstructorViaButton() {
        loginAsDefaultUser();
        new ProfilePage(driver).clickConstructorLink();
        assertTrue(new ProfilePage(driver).isConstructorTitleVisible());
    }

    @Test
    @Step("Переход в конструктор по логотипу")
    public void goToConstructorViaLogo() {
        loginAsDefaultUser();
        new ProfilePage(driver).clickLogo();
        assertTrue(new ProfilePage(driver).isConstructorTitleVisible());
    }

    @Test
    @Step("Выход из аккаунта")
    public void logoutTest() {
        loginAsDefaultUser();
        new LoginPage(driver).clickPersonalAccount();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogout();
        assertTrue(new LoginPage(driver).isLoginButtonVisible());
    }
}