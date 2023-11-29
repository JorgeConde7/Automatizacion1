package pe.visorweb.categoria;

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

public class CategoriaInsertarText {

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
/*
	@AfterEach
	void cerrarDriver() {
		driver.quit();
	}*/

	@Test
	void insertarCategoriaExitosaTest() throws InterruptedException {
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

		WebElement menuMntCategoria = driver.findElement(By.linkText("Mnt. de Categoría"));
		menuMntCategoria.click();

		WebElement btnNuevo = driver.findElement(By.id("btnNuevo"));
		btnNuevo.click();

		WebElement txtNombre = driver.findElement(By.id("txtNombre"));
		txtNombre.clear();
		txtNombre.sendKeys("LAPTOP SELENIUM3");

		WebElement btnGuardar = driver.findElement(By.id("btnGuardar"));
		btnGuardar.click();

		Thread.sleep(2000);
		String mensajeEsperado = "Se guardó de manera correcta la Categoría";
		String mensajeObtenido = driver.findElement(By.xpath("//span[@class='ui-messages-info-summary']")).getText();

		Assertions.assertEquals(mensajeEsperado, mensajeObtenido);

	}
	
	@Test
	void insertarCategoriaDatosVacioTest() throws InterruptedException {
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

		WebElement menuMntCategoria = driver.findElement(By.linkText("Mnt. de Categoría"));
		menuMntCategoria.click();

		WebElement btnNuevo = driver.findElement(By.id("btnNuevo"));
		btnNuevo.click();

		WebElement txtNombre = driver.findElement(By.id("txtNombre"));
		txtNombre.clear();
		txtNombre.sendKeys("");

		WebElement btnGuardar = driver.findElement(By.id("btnGuardar"));
		btnGuardar.click();

		Thread.sleep(2000);
		String mensajeEsperado = "Nombre: Error de validación: se necesita un valor.";
		String mensajeObtenido = driver.findElement(By.xpath("//*[@id=\'messages\']/div/ul/li/span")).getText();

		Assertions.assertEquals(mensajeEsperado, mensajeObtenido);

	}
	
	@Test
	void filtrarCategorias() throws InterruptedException {
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

		WebElement menuMntCategoria = driver.findElement(By.linkText("Mnt. de Categoría"));
		menuMntCategoria.click();

		WebElement btnFiltrar= driver.findElement(By.id("btnFiltrar"));
		btnFiltrar.click();
		
		Thread.sleep(2000);
		List<WebElement> filas= driver.findElements(By.xpath("//tbody[@id='tablaCategorias_data']/tr"));
		for(WebElement fila:filas) {
			List<WebElement> celdas=fila.findElements(By.tagName("td"));
			String codigo= celdas.get(0).getText();
			String nombre= celdas.get(1).getText();
			System.out.println("código: "+codigo+"-nombre: "+nombre);
		}
		System.out.println("total de filas: "+filas.size());
		Assertions.assertTrue(filas.size()>0);
		
		
	}
	
	@Test
	void filtrarXCategoria() throws InterruptedException {
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

		WebElement menuMntCategoria = driver.findElement(By.linkText("Mnt. de Categoría"));
		menuMntCategoria.click();

		WebElement txtFiltro= driver.findElement(By.id("txtFiltro"));
		txtFiltro.sendKeys("ga");
		
		WebElement btnFiltrar= driver.findElement(By.id("btnFiltrar"));
		btnFiltrar.click();
		
		Thread.sleep(2000);
		List<WebElement> filas= driver.findElements(By.xpath("//tbody[@id='tablaCategorias_data']/tr"));
		for(WebElement fila:filas) {
			List<WebElement> celdas=fila.findElements(By.tagName("td"));
			String codigo= celdas.get(0).getText();
			String nombre= celdas.get(1).getText();
			System.out.println("código: "+codigo+"-nombre: "+nombre);
		}
		System.out.println("total de filas: "+filas.size());
		Assertions.assertTrue(filas.size()>0);
		
		
	}
}
