package com.mts.tests;
/*Продолжим работу над блоком «Онлайн пополнение без комиссии» сайта mts.by.
Перевести ранее написанный тест на использование паттерна PageObject и добавить следующие проверки:
Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет, рассрочка, задолженность;
Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы,
нажать кнопку «Продолжить» и в появившемся окне проверить корректность отображения суммы (в том числе на кнопке),
номера телефона, а также надписей в незаполненных полях для ввода реквизитов карты, наличие иконок платёжных систем.*/

import com.mts.helpers.BrowserFactory;
import com.mts.pages.OnlinePaymentPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Онлайн-пополнение без комиссии")

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
    @Story("Проверка названия блока онлайн пополнения")
    void testCheckBlockTitle() {
        assertEquals("Онлайн пополнение без комиссии", paymentPage.getBlockTitleText().replace("\n", " "),
                "Название блока не совпадает с ожидаемым!");
    }

    @Test
    @Story("Проверка отображения логотипов платежных систем")
    void testArePaymentLogosDisplayed() {
        assertTrue(paymentPage.arePaymentLogosDisplayed(),
                " Все логотипы платёжных систем должны отображаться на странице");
    }

    @Test
    @Story("Проверка надписей в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет, рассрочка, задолженность")
    void testSelectOption() {
        paymentPage.selectOption("Услуги связи");
        assertEquals("Номер телефона", paymentPage.getFieldPhoneNumberPlaceholder(), "Надпись не совпадает");
        assertEquals("Сумма", paymentPage.getFieldSumPlaceholder(), "Надпись не совпадает");
        assertEquals("E-mail для отправки чека", paymentPage.getFieldEmailPlaceholder(), "Надпись не совпадает");

        paymentPage.selectOption("Домашний интернет");
        assertEquals("Номер абонента", paymentPage.getFieldPhoneNumber2Placeholder(), "Надпись не совпадает");
        assertEquals("Сумма", paymentPage.getFieldSum2Placeholder(), "Надпись не совпадает");
        assertEquals("E-mail для отправки чека", paymentPage.getFieldEmail2Placeholder(), "Надпись не совпадает");

        paymentPage.selectOption("Рассрочка");
        assertEquals("Номер счета на 44", paymentPage.getFieldAccountNumberPlaceholder(), "Надпись не совпадает");
        assertEquals("Сумма", paymentPage.getFieldSum3Placeholder(), "Надпись не совпадает");
        assertEquals("E-mail для отправки чека", paymentPage.getFieldEmail3Placeholder(), "Надпись не совпадает");

        paymentPage.selectOption("Задолженность");
        assertEquals("Номер счета на 2073", paymentPage.getFieldAccountNumber2Placeholder(), "Надпись не совпадает");
        assertEquals("Сумма", paymentPage.getFieldSum4Placeholder(), "Надпись не совпадает");
        assertEquals("E-mail для отправки чека", paymentPage.getFieldEmail4Placeholder(), "Надпись не совпадает");
    }

    @Test
    @Story("Проверка работы ссылки 'Подробнее о сервисе'")
    void testClickLinkOpenCorrectPage() {
        paymentPage.clickLink();
        assertTrue(paymentPage.getHeaderText().contains("Оплата банковской картой"),
                "Заголовок страницы не совпадает с ожидаемым!");
    }

    @Test
    @Story("Проверка заполнения формы и отображения суммы, телефона и полей карты в окне оплаты")
    void testFillFormAndContinue() {
        paymentPage.fillFormAndContinue("297777777", "100");
        assertTrue(paymentPage.getFrameTitleText().contains("100.00 BYN"),
                "Заголовок должен быть'100.00 BYN'");
        String buttonText = paymentPage.getButtonPayText().trim().replaceAll("\\s+", " ");
        assertTrue(buttonText.contains("Оплатить 100.00 BYN"),
                "Надпись на кнопке не совпадает");
        assertTrue(paymentPage.getPhoneNumberText().contains("297777777"), "Номер телефона не совпадает");
        assertTrue(paymentPage.getCardNumberText().contains("Номер карты"), "Надпись не совпадает");
        assertTrue(paymentPage.getExpDateFieldText().contains("Срок действия"), "Надпись не совпадает");
        assertTrue(paymentPage.getCvcFieldText().contains("CVC"), "Надпись не совпадает");
        assertTrue(paymentPage.getNameFamilyFieldText().contains("Имя и фамилия на карте"), "Надпись не совпадает");
        assertTrue(paymentPage.areAllPaymentLogosDisplayed(),
                " Все логотипы платёжных систем должны отображаться на странице");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
