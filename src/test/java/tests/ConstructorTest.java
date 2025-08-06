package tests;

import io.qameta.allure.Step;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    @Step("Переход к разделу 'Булки'")
    public void bunsSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauceTab();
        mainPage.clickBunTab();
        assertTrue(mainPage.isBunTabActive());
    }

    @Test
    @Step("Переход к разделу 'Соусы'")
    public void saucesSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauceTab();
        assertTrue(mainPage.isSauceTabActive());
    }

    @Test
    @Step("Переход к разделу 'Начинки'")
    public void fillingsSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingTab();
        assertTrue(mainPage.isFillingTabActive());
    }

}