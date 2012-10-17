package br.com.crafters.functional;


import static org.junit.Assert.*;

import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


@RunWith(JUnitParamsRunner.class)
public class MontarTabuleiroFunctionalTest {

	private static final String URL = "http://localhost:8080/navy";
	WebDriver driver = null;
	
	@org.junit.Before
	public void setup(){
		driver = new HtmlUnitDriver();
	}
	
	@org.junit.After
	public void teardown(){
		driver.close();
		driver = null;
	}
	
	@Test
	public void verTitulo() {
		driver.get(URL);
		WebElement el = driver.findElement(By.cssSelector("body h1"));
		assertEquals("Navywar", el.getText());
	}
	
	@Test
	public void verTabuleiro6linhas(){
		get(URL);
		List<WebElement> els = driver.findElements(By.cssSelector("table tr"));
		assertEquals(6, els.size());	
	}
	@Test
	public void verTabuleiro6linhasCom6Colunas(){
		get(URL);
		List<WebElement> els = driver.findElements(By.cssSelector("table tr"));
		assertEquals(6, els.size());
		for (WebElement el : els) {
			List<WebElement> cols = el.findElements(By.cssSelector("td"));
			assertEquals(6, cols.size());
		}
	}
	
	@Test
	public void verTiposDeNavioParaColocarNoTabuleiro(){
		get(URL);
		List<WebElement> ships = driver.findElements(By.className("available_ship"));
		assertEquals(4, ships.size());
	}
	@Test
	@Parameters({"cruiser", "airshipcarrier", "destroyer", "submarine"})
	public void verOsNaviosDisponiveis(String shipName){
		get(URL);
		WebElement ships = driver.findElement(By.className("available_ships"));
		WebElement ship = ships.findElement(By.cssSelector("."+ shipName +" img"));
		assertNotNull(ship);
	}
	
	private void get(String url){
		driver.get(url);
	}

}
