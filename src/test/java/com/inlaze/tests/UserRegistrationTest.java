package com.inlaze.tests;

import pages.RegistrationPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRegistrationTest {

    private static WebDriver driver;
    private RegistrationPage registrationPage;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testValidRegistration() {
        registrationPage = new RegistrationPage(driver);
        driver.get("https://test-qa.inlaze.com/auth/sign-up");
        registrationPage.enterName("Juan Carvajal");
        registrationPage.enterEmail("juan.carvajal@test.com");
        registrationPage.enterPassword("Contraseña123!");
        registrationPage.enterConfirmPassword("Contraseña123!");
        registrationPage.clickRegister();
        assertEquals("Welcome Juan Carvajal", registrationPage.getWelcomeMessage());
    }

    @Test
    public void testPasswordMismatch() {
        registrationPage = new RegistrationPage(driver);
        driver.get("https://test-qa.inlaze.com/auth/sign-up");
        registrationPage.enterPassword("Contraseña123!");
        registrationPage.enterConfirmPassword("Contraseña456!");
        assertEquals("Passwords do not match", registrationPage.getConfirmPasswordError());
    }
}
