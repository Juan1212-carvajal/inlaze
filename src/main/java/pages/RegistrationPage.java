package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    private By nameField = By.xpath("//input[@type='text' and @id='full-name']");
    private By emailField = By.xpath("//input[@type='email' and @id='email']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By confirmPasswordField = By.xpath("//input[@id='confirm-password']");
    private By registerButton = By.id("");

    private By confirmPasswordError = By.xpath("//span[@class='label-text-alt text-error' and contains(text(), 'Passwords do not match')]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public String getConfirmPasswordError() {
        return driver.findElement(confirmPasswordError).getText();
    }


    public String getWelcomeMessage() {
        WebElement messageElement = driver.findElement(By.id("welcome-message"));
        return messageElement.getText();
    }
}