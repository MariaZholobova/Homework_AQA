package com.mts.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnlinePaymentPage {
    private WebDriver driver;
    private By acceptCookieButton = By.id("cookie-agree");
    /*Форма: Онлайн пополнение без комиссии*/
    private By blockTitle = By.xpath("//h2[contains(text(), 'Онлайн пополнение ')]");
    private By visaLogo = By.xpath("//img[@alt = 'Visa']");
    private By verifiedByVisaLogo = By.xpath("//img[@alt = 'Verified By Visa']");
    private By masterCardLogo = By.xpath("//img[@alt = 'MasterCard']");
    private By masterCardSecureCodeLogo = By.xpath("//img[@alt = 'MasterCard Secure Code']");
    private By belcartLogo = By.xpath("//img[@alt = 'Белкарт']");
    private By detailsLink = By.linkText("Подробнее о сервисе");
    /*Услуги связи */
    private By menu = By.cssSelector("button.select__header");
    private By option = By.xpath("//p[@class='select__option' and text()='Услуги связи']");
    private By fieldPhoneNumber = By.id("connection-phone");
    private By fieldSum = By.id("connection-sum");
    private By fieldEmail = By.id("connection-email");
    private By continueButton = By.cssSelector("#pay-connection button[type='submit']");
    /*Домашний интернет*/
    private By option2 = By.xpath("//p[@class='select__option' and text()='Домашний интернет']");
    private By fieldPhoneNumber2 = By.id("internet-phone");
    private By fieldSum2 = By.id("internet-sum");
    private By fieldEmail2 = By.id("internet-email");
    /*Рассрочка*/
    private By option3 = By.xpath("//p[@class='select__option' and text()='Рассрочка']");
    private By fieldAccountNumber = By.id("score-instalment");
    private By fieldSum3 = By.id("instalment-sum");
    private By fieldEmail3 = By.id("instalment-email");
    /* Задолженность */
    private By option4 = By.xpath("//p[@class='select__option' and text()='Задолженность']");
    private By fieldAccountNumber2 = By.id("score-arrears");
    private By fieldSum4 = By.id("arrears-sum");
    private By fieldEmail4 = By.id("arrears-email");
    /*Переход по ссылке*/
    private By headerText = By.xpath("//h3[contains(text(), 'Оплата банковской картой')]");
    /* Фрейм*/
    private By frame = By.cssSelector("iframe.bepaid-iframe");
    private By frameTitle = By.xpath("//div[contains(@class, 'pay-description__cost')]/span");
    private By buttonPay = By.xpath("//button[normalize-space()='Оплатить 100.00 BYN']");
    private By phoneNumberText = By.xpath("//span[contains(text(), '297777777')]");
    private By cardNumber = By.xpath("//div[input[@id = 'cc-number']]/label");
    private By expDateField = By.xpath("//div[input[@placeholder='MM / YY']]/label");
    private By cvcField = By.xpath("//div[input[@name = 'verification_value']]/label");
    private By nameFamilyField = By.xpath("//div[input[@autocomplete = 'cc-name']]/label");
    private By visa = By.cssSelector("img[src*='visa-system']");
    private By masterCard = By.cssSelector("img[src*='mastercard-system']");
    private By belcart = By.cssSelector("img[src*='belkart-system']");
    private By maestro = By.cssSelector("img[src*='maestro-system']");
    private By mir = By.cssSelector("img[src*='mir-system']");

    public OnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Принять баннер cookie, если он видим")
    public void acceptCookieButtonIfVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(acceptCookieButton));
            btn.click();
        } catch (Exception e) {
            System.out.println("Баннер cookie не появился или не кликабелен");
        }
    }

    @Step("Получить название блока онлайн пополнения")
    public String getBlockTitleText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle));
        return title.getText();
    }

    @Step("Проверить отображение логотипа Visa на странице")
    public boolean isPaymentLogoVisaDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement visa = wait.until(ExpectedConditions.visibilityOfElementLocated(visaLogo));
        return visa.isDisplayed();
    }

    @Step("Проверить отображение логотипа VerifiedByVisa на странице")
    public boolean isPaymentLogoVerifiedByVisaDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement verifiedByVisa = wait.until(ExpectedConditions.visibilityOfElementLocated(verifiedByVisaLogo));
        return verifiedByVisa.isDisplayed();
    }

    @Step("Проверить отображение логотипа MasterCard на странице")
    public boolean isPaymentLogoMasterCardDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement masterCard = wait.until(ExpectedConditions.visibilityOfElementLocated(masterCardLogo));
        return masterCard.isDisplayed();
    }

    @Step("Проверить отображение логотипа MasterCard Secure Code на странице")
    public boolean isPaymentLogoMasterCardSecureCodeDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement masterCardSecureCode = wait.until(ExpectedConditions.visibilityOfElementLocated(masterCardSecureCodeLogo));
        return masterCardSecureCode.isDisplayed();
    }

    @Step("Проверить отображение логотипа Belcart на странице")
    public boolean isPaymentLogoBelcartDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement belcart = wait.until(ExpectedConditions.visibilityOfElementLocated(belcartLogo));
        return belcart.isDisplayed();
    }

    @Step("Выбрать опцию '{optionName}' в выпадающем меню")
    public void selectOption(String optionName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popupMenu = wait.until(ExpectedConditions.elementToBeClickable(menu));
        popupMenu.click();
        By optionLocator = By.xpath("//p[@class='select__option' and normalize-space(text())='" + optionName + "']");
        WebElement options = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        options.click();
    }

    public String getPlaceholder(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getAttribute("placeholder");
    }

    public String getFieldPhoneNumberPlaceholder() {
        return getPlaceholder(fieldPhoneNumber);
    }

    public String getFieldSumPlaceholder() {
        return getPlaceholder(fieldSum);
    }

    public String getFieldEmailPlaceholder() {
        return getPlaceholder(fieldEmail);
    }

    public String getFieldPhoneNumber2Placeholder() {
        return getPlaceholder(fieldPhoneNumber2);
    }

    public String getFieldSum2Placeholder() {
        return getPlaceholder(fieldSum2);
    }

    public String getFieldEmail2Placeholder() {
        return getPlaceholder(fieldEmail2);
    }

    public String getFieldAccountNumberPlaceholder() {
        return getPlaceholder(fieldAccountNumber);
    }

    public String getFieldSum3Placeholder() {
        return getPlaceholder(fieldSum3);
    }

    public String getFieldEmail3Placeholder() {
        return getPlaceholder(fieldEmail3);
    }

    public String getFieldAccountNumber2Placeholder() {
        return getPlaceholder(fieldAccountNumber2);
    }

    public String getFieldSum4Placeholder() {
        return getPlaceholder(fieldSum4);
    }

    public String getFieldEmail4Placeholder() {
        return getPlaceholder(fieldEmail4);
    }

    @Step("Нажать на ссылку 'Подробнее о сервисе'")
    public void clickLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(detailsLink));
        link.click();
    }

    public String getHeaderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(headerText));
        return header.getText();
    }

    @Step("Заполнить форму с номером телефона '{phone}' и суммой '{sum}' и нажать 'Продолжить'")
    public void fillFormAndContinue(String phone, String sum) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(fieldPhoneNumber));
        phoneNumber.click();
        phoneNumber.clear();
        phoneNumber.sendKeys(phone);
        WebElement summa = wait.until(ExpectedConditions.visibilityOfElementLocated(fieldSum));
        summa.click();
        summa.clear();
        summa.sendKeys(sum);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        button.click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    @Step("Получить текст заголовка во фрейме")
    public String getFrameTitleText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(frameTitle));
        return title.getText();
    }

    @Step("Получить текст кнопки оплаты во фрейме")
    public String getButtonPayText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonPay));
        return button.getText();
    }

    @Step("Получить отображаемый номер телефона во фрейме")
    public String getPhoneNumberText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement numberText = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberText));
        return numberText.getText();
    }

    @Step("Получить текст поля 'Номер карты' во фрейме")
    public String getCardNumberText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cardNumberText = wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));
        return cardNumberText.getText();
    }

    @Step("Получить текст поля 'Срок действия' во фрейме")
    public String getExpDateFieldText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement expDateFieldText = wait.until(ExpectedConditions.visibilityOfElementLocated(expDateField));
        return expDateFieldText.getText();
    }

    @Step("Получить текст поля 'CVC' во фрейме")
    public String getCvcFieldText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cvcFieldText = wait.until(ExpectedConditions.visibilityOfElementLocated(cvcField));
        return cvcFieldText.getText();
    }

    @Step("Получить текст поля 'Имя и фамилия на карте' во фрейме")
    public String getNameFamilyFieldText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement nameFamilyFieldText = wait.until(ExpectedConditions.visibilityOfElementLocated(nameFamilyField));
        return nameFamilyFieldText.getText();
    }

    @Step("Проверить отображение логотипа Visa во фрейме")
    public boolean isPaymentLogoVisaDisplayedInFrame() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(visa)).isDisplayed();
    }

    @Step("Проверить отображение логотипа MasterCard во фрейме")
    public boolean isPaymentLogoMasterCardDisplayedInFrame() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(masterCard)).isDisplayed();
    }

    @Step("Проверить отображение логотипа Belcart во фрейме")
    public boolean isPaymentLogoBelcartDisplayedInFrame() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(belcart)).isDisplayed();
    }

    @Step("Проверить отображение логотипа Maestro во фрейме")
    public boolean isPaymentLogoMaestroDisplayedInFrame() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(maestro)).isDisplayed();
    }

    @Step("Проверить отображение логотипа Mir во фрейме")
    public boolean isPaymentLogoMirDisplayedInFrame() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mir)).isDisplayed();
    }
}
