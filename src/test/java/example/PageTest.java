package example;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private Page homePage;
    private PaymentPage paymentPage;


    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mts.by");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        homePage = new Page(driver);
        paymentPage = new PaymentPage(driver);
    }

    @Test
    @Description("Проверяет название блока: \"Онлайн пополнение без комиссии\"")
    public void testCheckBlockTitle() {
        homePage.acceptCookies();
        homePage.openDropdown();
        homePage.selectServiceOption("Услуги связи");

        String actualBlockTitle = homePage.getBlockTitle();
        String expectedBlockTitle = "Онлайн пополнение без комиссии";
        assertEquals(expectedBlockTitle, actualBlockTitle, "Заголовок блока не совпадает.");
    }

    @Test
    @Description("Проверяет логотипов платёжных систем")
    public void testPaymentSystemLogos() {
        homePage.acceptCookies();
        homePage.openDropdown();
        homePage.selectServiceOption("Услуги связи");

        assertTrue(homePage.isVisaLogoDisplayed(), "Логотип Visa не найден.");
        assertTrue(homePage.isVerifiedByVisaLogoDisplayed(), "Логотип Verified By VisaLogo не найден.");
        assertTrue(homePage.isMastercardLogoDisplayed(), "Логотип MasterCard не найден.");
        assertTrue(homePage.isMasterCardSecureCodeLogoDisplayed(), "Логотип MasterCard Secure Code не найден.");
        assertTrue(homePage.isBelkartLogoDisplayed(), "Логотип Белкарт не найден.");
    }

    @Test
    @Description("Проверяет работу ссылки Подробнее о сервисе")
    public void testMoreAboutServiceLink() {
        homePage.acceptCookies();
        homePage.openDropdown();
        homePage.selectServiceOption("Услуги связи");

        By moreInfoLink = By.xpath("//a[text()='Подробнее о сервисе']");
        WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink));
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        linkElement.click();

        String currentUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl, "URL после нажатия на ссылку не соответствует ожидаемому.");
    }

    //Проверяет надписи в незаполненных полях каждого варианта оплаты услуг 1.1
    @Test
    @Description("Проверяет надписи в незаполненных полях каждого варианта оплаты услуг 1.1")
    public void testCheckPlaceholdersForAllPaymentOptions() {
        // Принятие cookies
        homePage.acceptCookies();

        // Проверка для услуги связи
        homePage.openDropdown();
        homePage.selectServiceOption("Услуги связи");

        // Прокрутка до формы
        paymentPage.scrollToElement(By.id("connection-phone"));

        // Проверка плейсхолдеров
        assertEquals("Номер телефона", paymentPage.getPhonePlaceholderText(), "Плейсхолдер для услуги связи неверен.");
        assertEquals("Сумма", paymentPage.getSumPlaceholderText(), "Плейсхолдер для суммы неверен.");
        assertEquals("E-mail для отправки чека", paymentPage.getEmailPlaceholderText(), "Плейсхолдер для email неверен.");

        // Прокрутка до формы домашнего интернета
        homePage.selectInternetOption();
        paymentPage.scrollToElement(By.id("internet-phone"));

        assertEquals("Номер абонента", paymentPage.getInternetPhonePlaceholderText(), "Плейсхолдер для домашнего интернета неверен.");
    }
    @Test
    @Description("Проверяет надписи в незаполненных полях каждого варианта оплаты услуг 1.2")
    public void testCheckPlaceholdersForAllPaymentOptionsTwo() {
        // Принятие cookies
        homePage.acceptCookies();

        // Проверка для услуги связи
        homePage.openDropdown();
        // Прокрутка до формы рассрочки
        homePage.selectInstallmentOption();
        paymentPage.scrollToElement(By.id("score-instalment"));

        assertEquals("Номер счета на 44", paymentPage.getInstallmentPhonePlaceholderText(), "Плейсхолдер для рассрочки неверен.");

        // Прокрутка до формы задолженности
        homePage.selectDebtOption();
        // метод с прокруткой и кликом
        paymentPage.scrollToElement(By.id("score-arrears"));

        assertEquals("Номер счета на 2073", paymentPage.getDebtPhonePlaceholderText(), "Плейсхолдер для задолженности неверен.");
    }

    @Test
    @Description("Проверяет работу кнопки продолжить и корректность отображения информации")
    public void testOnlinePaymentForm() {
        homePage.acceptCookies();
        homePage.openDropdown();
        homePage.selectServiceOption("Услуги связи");

        String phoneNumber = "297777777";
        String amount = "100";
        String kart = "Номер карты";
        String time = "Срок действия";
        String cvc = "CVC";
        String name = "Имя держателя (как на карте)";

        paymentPage.fillPaymentForm(phoneNumber, amount, "test@goodl.com");
        paymentPage.clickSubmitButton();

        assertTrue(paymentPage.isPaymentDetailsWindowDisplayed(), "Окно подтверждения оплаты не отображается.");

        paymentPage.switchToPaymentFrame();

        //Проверка отображения текста
        assertEquals(formatAmount(amount), paymentPage.getDisplayedSum(), "Сумма отображается неверно.");
        assertEquals(formatPhoneNumber(phoneNumber), paymentPage.getDisplayedPhone(), "Номер телефона отображается неверно.");
        assertTrue(paymentPage.getPaymentButtonKart().contains(kart), "Номер карты отображается неверно.");
        assertTrue(paymentPage.getPaymentButtonTime().contains(time), "Срок действия отображается неверно.");
        assertTrue(paymentPage.getPaymentButtonCvc().contains(cvc), "cvc отображается неверно.");
        assertTrue(paymentPage.getPaymentButtonName().contains(name), "Имя держателя (как на карте) отображается неверно.");
        assertTrue(paymentPage.getPaymentButtonText().contains(amount), "Текст на кнопке неверен.");

        //Проверка отображения иконок
        assertTrue(homePage.isVisaLogoTwoDisplayed(), "Не соответстие логотипа Visa.");
        assertTrue(homePage.isMastercardLogoTwoDisplayed(), "Не соответстие логотипа MasterCard.");
        assertTrue(homePage.isMaestroSystemLogoTwoDisplayed(), "Не соответстие логотипа MaestroSystem.");
        assertTrue(homePage.isBelkartLogoTwoDisplayed(), "Логотип Белкарт не найден.");
        assertTrue(homePage.isMirSystemLogoTwoDisplayed(), "Не соответстие логотипа Мир.");

        paymentPage.switchToDefaultContent();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private String formatPhoneNumber(String phoneNumber) {
        return "Оплата: Услуги связи Номер:375" + phoneNumber;
    }

    private String formatAmount(String amount) {
        if (!amount.contains(".")) {
            amount += ".00";
        }
        return amount + " BYN";
    }


}