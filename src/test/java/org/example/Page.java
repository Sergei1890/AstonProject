package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локатор для выпадающего меню
    private By dropdownButton = By.cssSelector(".select__header");
    // Локатор для кнопки принятия cookie
    private By cookieAcceptButton = By.id("cookie-agree");

    // Локатор для заголовка блока
    private By blockTitleLocator = By.cssSelector(".pay__wrapper h2");

    // Локаторы для логотипов платежных систем
    private By logoContainer = By.cssSelector(".pay__partners ul");
    private By visaLogo = By.cssSelector("img[alt='Visa']");
    private By VerifiedByVisaLogo = By.cssSelector("img[alt='Verified By Visa']");
    private By mastercardLogo = By.cssSelector("img[alt='MasterCard']");
    private By MasterCardSecureCodeLogo = By.cssSelector("img[alt='MasterCard Secure Code']");
    private By belkartLogo = By.cssSelector("img[alt='Белкарт']");

    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void acceptCookies() {
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            cookieButton.click();
        } catch (Exception e) {
            System.out.println("Всплывающее окно cookie не появилось или уже было закрыто.");
        }
    }

    public void openDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(dropdownButton)).click();
    }

    public void selectServiceOption(String optionText) {
        // Локатор для выбора опции в выпадающем меню
        By optionLocator = By.xpath("//p[text()='" + optionText + "']");
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
    }

    public void selectInternetOption() {
        selectServiceOption("Домашний интернет");
    }

    public void selectInstallmentOption() {
        selectServiceOption("Рассрочка");
    }

    public void selectDebtOption() {
        WebElement debtOption = driver.findElement(By.xpath("//p[text()='Задолженность']"));

        // Прокрутка к элементу
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", debtOption);

        // Клик по элементу
        debtOption.click();
    }

    public String getBlockTitle() {
        WebElement blockElement = wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitleLocator));
        return blockElement.getText().replace("\n", " ").replace("\u00A0", " ").trim();
    }

    public boolean isVisaLogoDisplayed() {
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainer));
        return logosElement.findElement(visaLogo) != null;
    }

    public boolean isVerifiedByVisaLogoDisplayed() {
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainer));
        return logosElement.findElement(VerifiedByVisaLogo) != null;
    }

    public boolean isMastercardLogoDisplayed() {
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainer));
        return logosElement.findElement(mastercardLogo) != null;
    }

    public boolean isMasterCardSecureCodeLogoDisplayed() {
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainer));
        return logosElement.findElement(MasterCardSecureCodeLogo) != null;
    }

    public boolean isBelkartLogoDisplayed() {
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainer));
        return logosElement.findElement(belkartLogo) != null;
    }

    //Локаторы для логотипов карт
    private By logoContainerTwo = By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c61-0 > div:nth-child(1) > app-input > div > div > div.icons-container.ng-tns-c46-1 > div > div");
    private By visaLogoTwo = By.cssSelector("img[src='assets/images/payment-icons/card-types/visa-system.svg']");
    private By mirSystemLogoTwo = By.cssSelector("img[src='assets/images/payment-icons/card-types/mir-system-ru.svg']");
    private By MastercardLogoTwo = By.cssSelector("img[src='assets/images/payment-icons/card-types/mastercard-system.svg']");
    private By maestroSystemLogoTwo = By.cssSelector("img[src='assets/images/payment-icons/card-types/maestro-system.svg']");
    private By belkartLogoTwo = By.cssSelector("img[src='assets/images/payment-icons/card-types/belkart-system.svg']");

    public boolean isVisaLogoTwoDisplayed() {
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainerTwo));
        return logosElement.findElement(visaLogoTwo) != null;
    }

    //
    //
    public boolean isMirSystemLogoTwoDisplayed() {
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainerTwo));
        return logosElement.findElement(mirSystemLogoTwo) != null;
    }

    public boolean isMastercardLogoTwoDisplayed() {
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainerTwo));
        return logosElement.findElement(MastercardLogoTwo) != null;
    }

    public boolean isMaestroSystemLogoTwoDisplayed() {
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainerTwo));
        return logosElement.findElement(maestroSystemLogoTwo) != null;
    }

    public boolean isBelkartLogoTwoDisplayed() {
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainerTwo));
        return logosElement.findElement(belkartLogoTwo) != null;
    }
}
