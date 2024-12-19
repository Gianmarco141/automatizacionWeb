package com.nttdata.page;

import org.openqa.selenium.By;

public class ProductPage {


    public static By categoryClothes = By.xpath("//*[@id=\"category-3\"]/a");
    public static By subcategoryMen = By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/div[1]/a/picture/img");
    public static By polo = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/picture/img");
    public static By quantityInput = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]");
    public static By carritoButton = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    public static By finalizarButton = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
}