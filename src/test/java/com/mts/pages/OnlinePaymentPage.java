package com.mts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnlinePaymentPage {
    private WebDriver driver;

    private By acceptCookieButton = By.id("cookie-agree");
    private By blockTitle = By.xpath("//h2[contains(text(), 'Онлайн пополнение ')]");
    private By visaLogo = By.xpath("//img[@alt = 'Visa']");
    private By verifiedByVisaLogo = By.xpath("//img[@ alt = 'Verified By Visa']");
    private By masterCardLogo = By.xpath("//img[@alt = 'MasterCard']");
    private By masterCardSecureCodeLogo = By.xpath("//img[@alt = 'MasterCard Secure Code']");
    private By belcartLogo = By.xpath("//img[@alt = 'Белкарт']");
    private By detailsLink = By.linkText("Подробнее о сервисе");
    private By headerText = By.xpath("//h3[contains(text(), 'Оплата банковской картой')]");
    private By fieldPhoneNumber = By.id("connection-phone");
    private By fieldSum = By.id("connection-sum");
    private By continueButton = By.xpath("//button[text()='Продолжить']");
    private By frame = By.cssSelector("iframe.bepaid-iframe");
    private By frameTitle = By.xpath("//div[contains(@class, 'pay-description__cost')]/span");

    public OnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookieButtonIfVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(acceptCookieButton));
            btn.click();
        } catch (Exception e) {
            System.out.println("Баннер cookie не появился или не кликабелен");
        }
    }

    public String getBlockTitleText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle));
        return title.getText();
    }

    public boolean arePaymentLogosDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement visa = wait.until(ExpectedConditions.visibilityOfElementLocated(visaLogo));
        WebElement verifiedByVisa = wait.until(ExpectedConditions.visibilityOfElementLocated(verifiedByVisaLogo));
        WebElement masterCard = wait.until(ExpectedConditions.visibilityOfElementLocated(masterCardLogo));
        WebElement masterCardSecureCode = wait.until(ExpectedConditions.visibilityOfElementLocated(masterCardSecureCodeLogo));
        WebElement belcart = wait.until(ExpectedConditions.visibilityOfElementLocated(belcartLogo));
        return visa.isDisplayed() &&
                verifiedByVisa.isDisplayed() &&
                masterCard.isDisplayed() &&
                masterCardSecureCode.isDisplayed() &&
                belcart.isDisplayed();
    }

    public void clickLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(detailsLink));
        link.click();
    }

    public String getHeaderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(headerText));
        return header.getText();
    }

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

    public String getFrameTitleText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(frameTitle));
        return title.getText();
    }
}
