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

    @After
    public void fechar(){
        driver.quit();
    }
}
