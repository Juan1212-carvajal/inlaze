package com.inlaze.tests;

import pages.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserLoginTest {

    private static WebDriver driver;
    private LoginPage loginPage;

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
    public void testUserLogin() {
        loginPage = new LoginPage(driver);
        driver.get("https://test-qa.inlaze.com/auth/sign-up");

        loginPage.enterEmail("juan.carvajal@test.com");
        loginPage.enterPassword("Contraseña123!");
        loginPage.clickLoginButton();

        String expectedUserName = "Juan Carvajal";
        assertEquals(expectedUserName, loginPage.getUserName(), "The user name displayed after login is incorrect.");
    }
}
