package pe.visorweb.productos;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MantenimientoProductos {

	WebDriver driver;
	String url = "http://localhost:8080/VisorWeb/index.xhtml";

	@BeforeAll
	static void configuracionInicial() {
		WebDriverManager.chromedriver().setup();

	}

	@BeforeEach
	void instanciarDriver() {
		driver = new ChromeDriver();
	}

/*	@AfterEach
	void cerrarDriver() {
		driver.quit();
	}

	
	 * @Test void insertarProductoExitoso() throws InterruptedException { int
	 * numero=2; }
	 * 
	 * @Test void insertarProductoFlujoAlternativo() throws InterruptedException {
	 * 
	 * }
	 * 
	 * @Test void editarProductoExitoso() throws InterruptedException {
	 * 
	 * }
	 * 
	 * @Test void editarProductoFlujoAlternativo() throws InterruptedException {
	 * 
	 * }
	 * 
	 * @Test void listarProductoExitoso() throws InterruptedException {
	 * 
	 * }
	 * 
	 * @Test void listarProductoFlujoAlternativo() throws InterruptedException {
	 * 
	 * }
	 */

	@Test
	void ElimiarProductoExitoso() throws InterruptedException {

		driver.get(url);
		WebElement txtUsuario = driver.findElement(By.id("txtUsuario"));
		txtUsuario.clear();
		txtUsuario.sendKeys("admin");

		WebElement txtClave = driver.findElement(By.id("txtClave"));
		txtClave.clear();
		txtClave.sendKeys("clave");

		WebElement btnIniciarSesion = driver.findElement(By.id("btnIniciarSesion"));
		btnIniciarSesion.click();

		WebElement menuHamburguesa = driver.findElement(By.xpath("//div[@class='btn-show active']"));
		menuHamburguesa.click();
		
		WebElement menuModAlmacen = driver.findElement(By.xpath("//li/span[contains(.,'Mod. de Almacén')]"));
		menuModAlmacen.click();
		
		Thread.sleep(3000);

		WebElement menuMntProducto = driver.findElement(By.linkText("Mnt. de Productos"));
		menuMntProducto.click();
		
				
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"tablaProductos_data\"]/tr[1]")).click();
		WebElement btnEliminar = driver.findElement(By.id("btnEliminar"));
		btnEliminar.click();
		WebElement btnSi = driver.findElement(By.id("btnSi"));
		btnSi.click();
		
		Thread.sleep(2000);
		String mensajeEsperado = "Se eliminó de manera correcta el Producto";
		String mensajeObtenido = driver.findElement(By.xpath("//span[contains(.,'Se eliminó de manera correcta el Producto')]")).getText();
		
		Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
		
	}



	@Test
	void EliminarProductoFlujoAlternativo() throws InterruptedException {
		driver.get(url);
		WebElement txtUsuario = driver.findElement(By.id("txtUsuario"));
		txtUsuario.clear();
		txtUsuario.sendKeys("admin");

		WebElement txtClave = driver.findElement(By.id("txtClave"));
		txtClave.clear();
		txtClave.sendKeys("clave");

		WebElement btnIniciarSesion = driver.findElement(By.id("btnIniciarSesion"));
		btnIniciarSesion.click();

		WebElement menuHamburguesa = driver.findElement(By.xpath("//div[@class='btn-show active']"));
		menuHamburguesa.click();
		
		WebElement menuModAlmacen = driver.findElement(By.xpath("//li/span[contains(.,'Mod. de Almacén')]"));
		menuModAlmacen.click();
		
		Thread.sleep(3000);

		WebElement menuMntProducto = driver.findElement(By.linkText("Mnt. de Productos"));
		menuMntProducto.click();
		
				
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"tablaProductos_data\"]/tr[1]")).click();
		WebElement btnEliminar = driver.findElement(By.id("btnEliminar"));
		btnEliminar.click();
		WebElement btnSi = driver.findElement(By.id("btnSi"));
		btnSi.click();
		
		Thread.sleep(2000);
		String mensajeEsperado = "No ha seleccionado un Producto";
		String mensajeObtenido = driver.findElement(By.xpath("//span[contains(.,'No ha seleccionado un Producto')]")).getText();
		
		Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
	

	}

}
