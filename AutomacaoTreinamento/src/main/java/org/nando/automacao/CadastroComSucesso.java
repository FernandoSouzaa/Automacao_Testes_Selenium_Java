package org.nando.automacao;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.nando.automacao.page.HomePage;
import org.nando.automacao.page.PageCadastro;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroComSucesso {

    WebDriver driver;
    PageCadastro pageCadastro;

    @Before
    public void inicio(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path+"\\src\\main\\resources\\drivers\\chrome.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        pageCadastro = new PageCadastro(driver);
        driver.get("file:///"+path+"\\src\\main\\resources\\drivers\\componentes.html");
    }

    @Test
    public void cadastroAluno(){
        pageCadastro.cadastarAluno();
    }

    @Test
    public void regraNegocioCadastro() throws InterruptedException {
        final String NOME = "elementosForm:nome";
        final String SOBRENOME = "elementosForm:sobrenome";
        final String COMIDA_CARNE = "elementosForm:comidaFavorita:0";
        final String COMIDA_FRANGO = "elementosForm:comidaFavorita:1";
        pageCadastro.regrasNegocioNomeESobrenome(NOME, "Nome", "Fernando");
        pageCadastro.regrasNegocioNomeESobrenome(SOBRENOME, "Sobrenome", "Ribeiro");
        pageCadastro.regraNegocioSexo();
        pageCadastro.comidaFavorita(COMIDA_CARNE);
        pageCadastro.comidaFavorita(COMIDA_FRANGO);
    }

    @After
    public void fechar(){
        //driver.quit();
    }
}
