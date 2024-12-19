package com.nttdata.stepsdefinitions;

import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;


public class LoginStepsDef {

    private WebDriver driver;
    private LoginSteps loginSteps;




    private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }

    @Dado("que me encuentro en la página de login de MyStore")
    public void queMeEncuentroEnLaPáginaDeLoginDeMyStore() {
        driver = getDriver();
        loginSteps = new LoginSteps(driver);
        loginSteps.clickAlLogin();
        screenShot();

    }
    @Cuando("inicio sesión con las credenciales usuario: {string} y contraseña: {string}")
    public void inicio_sesión_con_las_credenciales_usuario_y_contraseña(String user, String password) {
        loginSteps.iniciandoLogin(user, password);
        screenShot();
    }
    @Entonces("regresar al menú principal si falla el inicio de sesión")
    public void regresarAlMenúPrincipalSiFallaElInicioDeSesión() {
        if (!loginSteps.siLoginExitoso()) {
            System.out.println("El inicio de sesión falló. Regresando al menú principal...");
            loginSteps.retornoPaginaPrincial();
            screenShot();
        }
    }
    @Cuando("navego a la categoría {string} y subcategoría {string}")
    public void navego_a_la_categoria_y_subcategoria(String category, String subcategory) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.navigateToCategory(category);
        loginSteps.navigateToSubcategory(subcategory);
    }

    @Cuando("agrego {int} unidades del primer producto al carrito")
    public void agrego_unidades_del_primer_producto_al_carrito(int quantity) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.selectFirstProduct();
        loginSteps.setProductQuantity(quantity);
        loginSteps.addToCart();

    }

    @Entonces("debería ver el producto en el carrito")
    public void deberia_ver_el_producto_en_el_carrito() {
        LoginSteps loginSteps = new LoginSteps(driver);
        boolean isInCart = loginSteps.isProductInCart();
        assert isInCart : "El producto no fue agregado correctamente al carrito.";

    }

}
