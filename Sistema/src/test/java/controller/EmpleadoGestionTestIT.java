package controller;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EmpleadoGestionTestIT {
    
 private static WebDriver driver = null;
 
    @BeforeClass
    public static void inicializarDiver(){
        driver = new FirefoxDriver();
    }
    
    @AfterClass
    public static void liquidarDriver(){
       driver.quit();
    }
    
    @Test
    public void TestEditar(){
      driver.get("http://localhost:8080/Sistema/faces/trabajador/list.xhtml");
      WebElement editar = driver.findElement(By.id("j_idt25:j_idt28:0:j_idt37"));
      editar.click();
      WebElement ModNombre = driver.findElement(By.id("input_editaEmpleadoForm:nombre"));
      ModNombre.clear();
      ModNombre.sendKeys("BLANCA ROSA TEST");
      WebElement Modificar = driver.findElement(By.id("editaEmpleadoForm:j_idt77"));
      Modificar.click();
    }
}
