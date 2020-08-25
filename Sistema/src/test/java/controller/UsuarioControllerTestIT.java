package controller;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsuarioControllerTestIT {
    
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
    public void testLogIn() {
      driver.get("http://localhost:8080/Sistema/faces/index.xhtml");
      WebElement origenElement = driver.findElement(By.id("input_j_idt9:usuario"));
      origenElement.sendKeys("juan");
      WebElement origenElement2 = driver.findElement(By.id("input_j_idt9:clave"));
      origenElement2.sendKeys("123");
      WebElement botIngresar = driver.findElement(By.id("j_idt9:j_idt20"));
      botIngresar.click();      
      WebDriverWait wait = new WebDriverWait(driver, 5);
      wait.until(ExpectedConditions.urlMatches("http://localhost:8080/Sistema/faces/index.xhtml"));
    }
}
