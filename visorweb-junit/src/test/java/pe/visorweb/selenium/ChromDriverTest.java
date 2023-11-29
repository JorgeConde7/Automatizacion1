package pe.visorweb.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

@TestMethodOrder(OrderAnnotation.class)
public class ChromDriverTest {
	
	WebDriver driver;
	
	@BeforeAll
	static void configuracionInicial() {
		WebDriverManager.chromedriver().setup();
		
	}
	
	@BeforeEach
	void instanciarDriver() {
		driver= new ChromeDriver();
	}
	
	@AfterEach
	void cerrarDriver() {
		driver.quit();
	}
	
	
	@Test
	@Order(1)
	void abrirChromeTest() {
		
		
		
		driver.get("https://selenium.dev");
		
		
		System.out.println("Titulo de la pagina" + driver.getTitle());
		System.out.println("Url"+driver.getCurrentUrl());
		
		Assertions.assertEquals("Selenium", driver.getTitle());
		
	
		
	}
	
	@Test
	@Order(2)
	void abrirGoogle() {
		driver.get("https://google");
			
	}
}