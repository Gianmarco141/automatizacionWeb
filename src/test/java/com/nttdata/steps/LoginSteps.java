package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import com.nttdata.page.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginSteps {

    private WebDriver driver;
    private static final String LOGIN_URL = "https://qalab.bensg.com/store/pe/iniciar-sesion?back=https%3A%2F%2Fqalab.bensg.com%2Fstore%2Fpe%2F";

    //constructor
    public LoginSteps(WebDriver driver){

        this.driver = driver;
    }
    public void clickAlLogin() {
        driver.get(LOGIN_URL);
    }
    public void iniciandoLogin(String user, String password) {
        typeUser(user);
        typePassword(password);
        login();
    }
    public boolean siLoginExitoso() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("unique-element-id")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public void retornoPaginaPrincial() {
        driver.navigate().to("https://qalab.bensg.com/store/pe/");
    }
    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.userInput));
        userInputElement.clear(); // limpiar el campo por si hay texto preexistente
        userInputElement.sendKeys(user);
    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement passInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.passInput));
        passInputElement.clear(); // limpiar el campo por si hay texto preexistente
        passInputElement.sendKeys(password);

    }
    /**
     * Hacer click en el botón login
     */
    public void login(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.loginButton));
        loginButtonElement.click();
    }

    // Nuevos métodos para navegación y compra
    public void navigateToCategory(String category) {

        if (category.equalsIgnoreCase("Clothes")) {
            driver.findElement(ProductPage.categoryClothes).click();
        }

    }

    public void navigateToSubcategory(String subcategory) {
        if (subcategory.equalsIgnoreCase("Men")) {
            driver.findElement(ProductPage.subcategoryMen).click();
        }
    }

    public void selectFirstProduct() {
        driver.findElement(ProductPage.polo).click();
    }

    public void setProductQuantity(int quantity) {

        driver.findElement(ProductPage.quantityInput).click();

    }

    public void addToCart() {
        driver.findElement(ProductPage.carritoButton).click();
    }

    public boolean isProductInCart() {
        return driver.findElement(ProductPage.finalizarButton).isDisplayed();

    }



}
