package pe.visorweb.productos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
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

	@AfterEach
	void cerrarDriver() {
		driver.quit();
	}
	
	@Test
	void insertarProductoExitoso() throws InterruptedException {
	  int  numero=2;
	}
	
	@Test
	void insertarProductoFlujoAlternativo() throws InterruptedException {
	
	}
	
	@Test
	void editarProductoExitoso() throws InterruptedException {
	
	}
	
	@Test
	void editarProductoFlujoAlternativo() throws InterruptedException {
	
	}
	
	@Test
	void listarProductoExitoso() throws InterruptedException {
	
	}
	
	@Test
	void listarProductoFlujoAlternativo() throws InterruptedException {
	
	}
	
	@Test
	void ElimiarProductoExitoso() throws InterruptedException {
	
	}
	
	@Test
	void EliminarProductoFlujoAlternativo() throws InterruptedException {
	
	}
	
}
