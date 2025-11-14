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
    @DisplayName("Проверка логотипа Visa")
    void testIsPaymentLogoVisaDisplayed() {
        assertTrue(paymentPage.isPaymentLogoVisaDisplayed(),
                " Логотип платёжной системы Visa должен отображаться на странице");
    }

    @Test
    @Story("Проверка отображения логотипов платежных систем")
    @DisplayName("Проверка логотипа VerifiedByVisa")
    void testIsPaymentLogoVerifiedByVisaDisplayed() {
        assertTrue(paymentPage.isPaymentLogoVerifiedByVisaDisplayed(),
                " Логотип платёжной системы VerifiedByVisa должен отображаться на странице");
    }

    @Test
    @Story("Проверка отображения логотипов платежных систем")
    @DisplayName("Проверка логотипа MasterCard")
    void testIsPaymentLogoMasterCardDisplayed() {
        assertTrue(paymentPage.isPaymentLogoMasterCardDisplayed(),
                " Логотип платёжной системы MasterCard должен отображаться на странице");
    }

    @Test
    @Story("Проверка отображения логотипов платежных систем")
    @DisplayName("Проверка логотипа MasterCard Secure Code")
    void testIsPaymentLogoMasterCardSecureCodeDisplayed() {
        assertTrue(paymentPage.isPaymentLogoMasterCardSecureCodeDisplayed(),
                " Логотип платёжной системы MasterCardSecureCode должен отображаться на странице");
    }

    @Test
    @Story("Проверка отображения логотипов платежных систем")
    @DisplayName("Проверка логотипа Belcart")
    void testIsPaymentLogoBelcartDisplayed() {
        assertTrue(paymentPage.isPaymentLogoBelcartDisplayed(),
                " Логотип платёжной системы Belcart должен отображаться на странице");
    }

    @Test
    @Story("Проверка надписей в незаполненных полях")
    @DisplayName("Раздел: Услуги связи")
    void testSelectOption1() {
        paymentPage.selectOption("Услуги связи");
        assertEquals("Номер телефона", paymentPage.getFieldPhoneNumberPlaceholder(), "Надпись не совпадает");
        assertEquals("Сумма", paymentPage.getFieldSumPlaceholder(), "Надпись не совпадает");
        assertEquals("E-mail для отправки чека", paymentPage.getFieldEmailPlaceholder(), "Надпись не совпадает");
    }

    @Test
    @Story("Проверка надписей в незаполненных полях")
    @DisplayName("Раздел: Домашний интернет")
    void testSelectOption2() {
        paymentPage.selectOption("Домашний интернет");
        assertEquals("Номер абонента", paymentPage.getFieldPhoneNumber2Placeholder(), "Надпись не совпадает");
        assertEquals("Сумма", paymentPage.getFieldSum2Placeholder(), "Надпись не совпадает");
        assertEquals("E-mail для отправки чека", paymentPage.getFieldEmail2Placeholder(), "Надпись не совпадает");
    }

    @Test
    @Story("Проверка надписей в незаполненных полях")
    @DisplayName("Раздел: Рассрочка")
    void testSelectOption3() {
        paymentPage.selectOption("Рассрочка");
        assertEquals("Номер счета на 44", paymentPage.getFieldAccountNumberPlaceholder(), "Надпись не совпадает");
        assertEquals("Сумма", paymentPage.getFieldSum3Placeholder(), "Надпись не совпадает");
        assertEquals("E-mail для отправки чека", paymentPage.getFieldEmail3Placeholder(), "Надпись не совпадает");
    }

    @Test
    @Story("Проверка надписей в незаполненных полях")
    @DisplayName("Раздел: Задолженность")
    void testSelectOption4() {
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
    @Story("Проверка заполнения формы и отображения заголовков во фрейме")
    @DisplayName("Отображение суммы")
    void testFrameShowsCorrectAmount() {
        paymentPage.fillFormAndContinue("297777777", "100");
        assertTrue(paymentPage.getFrameTitleText().contains("100.00 BYN"),
                "Заголовок должен быть'100.00 BYN'");
    }

    @Test
    @Story("Проверка заполнения формы и отображения заголовков во фрейме")
    @DisplayName("Отображение номера телефона")
    void testFramePayButtonText() {
        paymentPage.fillFormAndContinue("297777777", "100");
        String buttonText = paymentPage.getButtonPayText().trim().replaceAll("\\s+", " ");
        assertTrue(buttonText.contains("Оплатить 100.00 BYN"),
                "Надпись на кнопке не совпадает");
    }

    @Test
    @Story("Проверка заполнения формы и отображения заголовков во фрейме")
    @DisplayName("Отображение суммы на кнопке оплаты")
    void testFramePhoneNumber() {
        paymentPage.fillFormAndContinue("297777777", "100");
        assertTrue(paymentPage.getPhoneNumberText().contains("297777777"), "Номер телефона не совпадает");
    }

    @Test
    @Story("Проверка отображения надписей в незаполненных полях для ввода реквизитов карты")
    @DisplayName("Поле: Номер карты")
    void testGetCardNumberText() {
        paymentPage.fillFormAndContinue("297777777", "100");
        assertTrue(paymentPage.getCardNumberText().contains("Номер карты"), "Надпись не совпадает");
    }

    @Test
    @Story("Проверка отображения надписей в незаполненных полях для ввода реквизитов карты")
    @DisplayName("Поле: Срок действия")
    void testGetExpDateFieldText() {
        paymentPage.fillFormAndContinue("297777777", "100");
        assertTrue(paymentPage.getExpDateFieldText().contains("Срок действия"), "Надпись не совпадает");
    }

    @Test
    @Story("Проверка отображения надписей в незаполненных полях для ввода реквизитов карты")
    @DisplayName("Поле: CVC")
    void testGetCvcFieldText() {
        paymentPage.fillFormAndContinue("297777777", "100");
        assertTrue(paymentPage.getCvcFieldText().contains("CVC"), "Надпись не совпадает");
    }

    @Test
    @Story("Проверка отображения надписей в незаполненных полях для ввода реквизитов карты")
    @DisplayName("Поле: Имя и фамилия на карте")
    void testGetNameFamilyFieldText() {
        paymentPage.fillFormAndContinue("297777777", "100");
        assertTrue(paymentPage.getNameFamilyFieldText().contains("Имя и фамилия на карте"), "Надпись не совпадает");
    }

    @Test
    @Story("Проверка отображения логотипов платежных систем во фрейме")
    @DisplayName("Проверка логотипа Visa")
    void testIsPaymentLogoVisaDisplayedInFrame() {
        paymentPage.fillFormAndContinue("297777777", "100");
        assertTrue(paymentPage.isPaymentLogoVisaDisplayedInFrame(), "Логотип Visa не отображается");
    }

    @Test
    @Story("Проверка отображения логотипов платежных систем во фрейме")
    @DisplayName("Проверка логотипа MasterCard")
    void testIsPaymentLogoMasterCardDisplayedInFrame() {
        paymentPage.fillFormAndContinue("297777777", "100");
        assertTrue(paymentPage.isPaymentLogoMasterCardDisplayedInFrame(), "Логотип MasterCard не отображается");
    }

    @Test
    @Story("Проверка отображения логотипов платежных систем во фрейме")
    @DisplayName("Проверка логотипа Belcart")
    void testIsPaymentLogoBelcartDisplayedInFrame() {
        paymentPage.fillFormAndContinue("297777777", "100");
        assertTrue(paymentPage.isPaymentLogoBelcartDisplayedInFrame(), "Логотип Belcart не отображается");
    }

    @Test
    @Story("Проверка отображения логотипов платежных систем во фрейме")
    @DisplayName("Проверка логотипа Maestro")
    void testIsPaymentLogoMaestroDisplayedInFrame() {
        paymentPage.fillFormAndContinue("297777777", "100");
        assertTrue(paymentPage.isPaymentLogoMaestroDisplayedInFrame(), "Логотип Maestro не отображается");
    }

    @Test
    @Story("Проверка отображения логотипов платежных систем во фрейме")
    @DisplayName("Проверка логотипа Mir")
    void testIsPaymentLogoMirDisplayedInFrame() {
        paymentPage.fillFormAndContinue("297777777", "100");
        assertTrue(paymentPage.isPaymentLogoMirDisplayedInFrame(), "Логотип Mir не отображается");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
