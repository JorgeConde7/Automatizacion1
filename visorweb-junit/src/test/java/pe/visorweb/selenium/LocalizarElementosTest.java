package pe.visorweb.selenium;

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

public class LocalizarElementosTest {

	WebDriver driver;
	String url="https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
	
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
	void buscarIdTest() {
		
		driver.get(url);
		
		WebElement inputText= driver.findElement(By.id("my-text-id"));
		System.out.println("atributo type:"+inputText.getAttribute("type"));
		Assertions.assertEquals("text", inputText.getAttribute("type"));
	}
	
	@Test
	void buscarPorNameTest() {
		
		driver.get(url);
		
		WebElement inputPassword= driver.findElement(By.name("my-password"));
		System.out.println("atributo type:"+inputPassword.getAttribute("type"));
		Assertions.assertEquals("password", inputPassword.getAttribute("type"));
	}
	
	@Test
	void buscarPortagNameTest() {
		
		driver.get(url);
		
		WebElement textArea= driver.findElement(By.tagName("textarea"));
		System.out.println("atributo row:"+textArea.getAttribute("rows"));
		Assertions.assertEquals("3", textArea.getAttribute("rows"));
	}
	
	@Test
	void buscarPorLinkTextTest() {
		driver.get(url);
		WebElement link= driver.findElement(By.linkText("Return to index"));
		System.out.println("tagName: "+ link.getTagName());
		Assertions.assertEquals("a", link.getTagName());
	}

	@Test
	void buscarPorClassNameTest() {
		driver.get(url);
		List<WebElement> elementos = driver.findElements(By.className("form-control"));
		System.out.println("total elementos: "+ elementos.size());
		Assertions.assertTrue(elementos.size()>0);
		
		for (WebElement elemento:elementos) {
			System.out.println("atributo name: " + elemento.getAttribute("name"));
		}
		Assertions.assertTrue(elementos.size()>0);
	}
}
