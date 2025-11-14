package com.mts.tests;
/*Необходимо написать автотесты для сайта mts.by.
Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
Проверить название указанного блока;
Проверить наличие логотипов платёжных систем;
Проверить работу ссылки «Подробнее о сервисе»;
Заполнить поля и проверить работу кнопки «Продолжить»
(проверяем только вариант «Услуги связи», номер для теста 297777777)*/

import com.mts.helpers.BrowserFactory;
import com.mts.pages.OnlinePaymentPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class OnlinePaymentTest {
    private WebDriver driver;
    private OnlinePaymentPage paymentPage;

    @BeforeEach
    void setUp() {
        driver = BrowserFactory.createDriver();
        driver.get("https://www.mts.by/");
        paymentPage = new OnlinePaymentPage(driver);
        paymentPage.acceptCookieButtonIfVisible();
    }

    @Test
    void testCheckBlockTitle() {

        assertEquals("Онлайн пополнение без комиссии", paymentPage.getBlockTitleText().replace("\n", " "),
                "Название блока не совпадает с ожидаемым!");
    }

    @Test
    void testArePaymentLogosDisplayed() {
        assertTrue(paymentPage.arePaymentLogosDisplayed(),
                " Все логотипы платёжных систем должны отображаться на странице");
    }

    @Test
    void testClickLinkOpenCorrectPage() {
        paymentPage.clickLink();
        assertTrue(paymentPage.getHeaderText().contains("Оплата банковской картой"),
                "Заголовок страницы не совпадает с ожидаемым!");
    }

    @Test
    void testFillFormAndContinue() {
        paymentPage.fillFormAndContinue("297777777", "100");
        assertTrue(paymentPage.getFrameTitleText().contains("100.00 BYN"),
                "Заголовок должен быть'100.00 BYN'");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
