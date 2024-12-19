package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {

    public static By userInput = By.xpath("//*[@id='field-email']");
    public static By passInput = By.xpath("//*[@id='field-password']");
    public static By loginButton = By.xpath("//*[@id='submit-login']");

}
