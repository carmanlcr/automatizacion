package Papoyo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.jna.platform.win32.WinUser.INPUT;

public class Automatizado {
	public static void main(String[] args) throws InterruptedException {
		//Lanzamiento de pagina
		String exePath = "C:\\Users\\LSMORALES\\Documents\\Selenium\\Automatización\\chromedriver.exe"; //Ruta donde esta el archivo chromdrive
		System.setProperty("webdriver.chrome.driver", exePath);
		
		WebDriver driver = new ChromeDriver(); //Instancia de Chroma Driver
		
		
		driver.get("http://localhost:8000/"); //Lanzamiento de la pagina
		
		System.out.println("El navegador se inicio correctamente");
		
		Thread.sleep(1000);
		
		
		/*InputWrite("cj_clave","lmorales13",driver,260); //Campo de login
		InputWrite("cj_contrasena","CAR22MAN05",driver,100); //Campo Password*/
		
		clicButton("btn_iniciarsesion", driver);
		Thread.sleep(2000);
		
		//Iniciar sesion
		login(driver);
		Thread.sleep(2000);
		
		driver.quit();

	}
	
	public static void inputWrite(String id_campo,String valor_ingresar, WebDriver driver,int tiempo_espera) throws InterruptedException {
		String auxvalor = valor_ingresar, primera_letra ="";
		
		WebElement usuario = driver.findElement(By.id(id_campo));
		for(int i = 0;i<valor_ingresar.length();i++) {
			primera_letra = auxvalor.substring(0, 1);
			auxvalor = auxvalor.substring(1);
			usuario.sendKeys(primera_letra);
			Thread.sleep(tiempo_espera);
		}
	}
	
	public static void clicButton(String id_button,WebDriver driver) {
		WebElement boton_aceptar = driver.findElement(By.id(id_button));
		boton_aceptar.click();
	}
	
	protected static void login(WebDriver driver) throws InterruptedException {
		inputWrite("username", "soyleydimar", driver, 200);
		Thread.sleep(1000);
		inputWrite("password", "LAMS2205", driver, 100);
		Thread.sleep(1000);
		clicButton("btn_ingresar",driver);
	}


}
