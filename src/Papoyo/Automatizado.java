package pApoyo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pApoyo.LoremIpsum;

public class Automatizado {
	public static void main(String[] args) throws InterruptedException {
		
		String exePath = "C:\\Users\\lmorales\\Documents\\Universidad\\Interfaces con el Usuario\\chromedriver.exe"; //Ruta donde esta el archivo chromdrive
		System.setProperty("webdriver.chrome.driver", exePath);
		
		//Lanzamiento de pagina
		WebDriver driver = new ChromeDriver(); //Instancia de Chroma Driver
		
		//
		LoremIpsum li = new LoremIpsum();
		driver.get("http://localhost:8000/"); //Lanzamiento de la pagina
		
		System.out.println("El navegador se inicio correctamente");
		
		Thread.sleep(1000);
		
		
		/*InputWrite("cj_clave","lmorales13",driver,260); //Campo de login
		InputWrite("cj_contrasena","CAR22MAN05",driver,100); //Campo Password*/
		
		
		clickButton("btn_registrar", driver);
		Thread.sleep(1000);
		
		//Registrar usuario
		register(driver);
		Thread.sleep(1340);
		
		closeSesion(driver);
		clickButton("btn_iniciarsesion", driver); //Para iniciar sesion 
		
		//Iniciar sesion
		login(driver);
		Thread.sleep(1000);
		
		closeSesion(driver);
		clickButton("btn_iniciarsesion", driver); //Para iniciar sesion 
		
		
		//Validar si un un elemento esta habilitado
		String habilitado = "close";
		WebElement elemento = driver.findElement(By.className(habilitado));
		boolean status = elemento.isEnabled();
		
		System.out.println("El elemento esta "+status);
		
		Thread.sleep(5000); //Espera de los 5 segundos
		
		
		driver.navigate().back(); //Ir a la pagina de atras 
		
		
		clickButton("contacto", driver); //Ir a otra pagina del sitio
		
		//refrescar la pagina
		driver.navigate().refresh();
		
		
		//Registro de formulario
		inputWrite("nombre", "Luis Morales", driver, 250);
		inputWrite("correo", "lmorales@goprint.pe", driver, 250);
		inputWrite("asunto", "Caso de prueba", driver, 250);
		inputWrite("mensaje", li.paragraph(), driver, 100);
		Thread.sleep(750);
		
		clickButton("boton", driver);
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
	
	public static void clickButton(String id_button,WebDriver driver) {
		WebElement boton_aceptar = driver.findElement(By.id(id_button));
		boton_aceptar.click();
	}
	
	protected static void login(WebDriver driver) throws InterruptedException {
		inputWrite("username", "donaflorinda", driver, 200);
		Thread.sleep(1000);
		inputWrite("password", "LAMS2205", driver, 100);
		Thread.sleep(1000);
		clickButton("btn_ingresar",driver);
	}

	protected static void register(WebDriver driver) throws InterruptedException{
		inputWrite("nombre", "Luis", driver, 120);
		inputWrite("apellido", "Morales", driver, 120);
		inputWrite("email", "sdad@goprint.pe", driver, 120);
		inputWrite("username", "asdasd", driver, 120);
		inputWrite("password", "LAMS2205", driver, 120);
		inputWrite("password-confirm", "LAMS2205", driver, 120);
		clickButton("registrar",driver);
	}
	
	protected static void closeSesion(WebDriver driver) throws InterruptedException{
		clickButton("check", driver); //Para mostrar el contenido del boton cerrar sesion
		clickButton("cerrarsesion", driver); //Para cerrar la sesion luego de haber iniciado
	}

}
