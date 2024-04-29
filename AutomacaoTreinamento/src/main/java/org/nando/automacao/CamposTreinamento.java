package org.nando.automacao;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.nando.automacao.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CamposTreinamento {

    WebDriver driver;
    HomePage homePage;

    @Before
    public void inicio(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path+"\\src\\main\\resources\\drivers\\chrome.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get("file:///"+path+"\\src\\main\\resources\\drivers\\componentes.html");
    }

    @Test
    public void testeCampoEditText(){
        homePage.editTextCampo("Fernando Ribeiro de Souza");
        homePage.validandoTextoCampo("elementosForm:nome","Fernando Ribeiro de Souza");
    }

    @Test
    public void interacaoTextArea(){
        homePage.textArea("Aprimorando conhecimentos com o Selenium + Java.");
        homePage.validandoTextoCampo("elementosForm:sugestoes","Aprimorando conhecimentos com o Selenium + Java.");
    }

    @Test
    public void interacaoRadioButton(){
        homePage.radioButton();
        homePage.validandoClickRadioButton("elementosForm:sexo:0");
    }

    @Test
    public void interacaoCheckBox(){
        homePage.checkBox();
    }

    @Test
    public void verificarCampos(){
        homePage.checkBoxVerificarValores();
    }

    @Test
    public void verificarComboMultiplo(){
        homePage.checkComboMultiplo();
    }

    @After
    public void closed() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
