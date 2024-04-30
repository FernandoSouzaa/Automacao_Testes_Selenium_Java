package org.nando.automacao.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageCadastro {

    WebDriver driver;

    final String NOME = "elementosForm:nome";
    final String SOBRENOME = "elementosForm:sobrenome";
    final String SEXO = "elementosForm:sexo:0";
    final String COMIDA = "elementosForm:comidaFavorita:0";
    final String ESCOLARIDADE = "elementosForm:escolaridade";
    final String ESPORTES = "elementosForm:esportes";
    final String SUGESTOES = "elementosForm:sugestoes";
    final String CADASTRAR = "elementosForm:cadastrar";
    final String RESULTADO = "resultado";

    public PageCadastro(WebDriver driver){
        this.driver = driver;
    }

    public void cadastarAluno(){
        driver.findElement(By.id(NOME)).sendKeys("Fernando");
        driver.findElement(By.id(SOBRENOME)).sendKeys("Ribeiro");
        driver.findElement(By.id(SEXO)).click();
        driver.findElement(By.id(COMIDA)).click();

        WebElement element = driver.findElement(By.id(ESCOLARIDADE));
        Select escolaridade = new Select(element);
        escolaridade.selectByVisibleText("Superior");

        element = driver.findElement(By.id(ESPORTES));
        Select esportes = new Select(element);
        esportes.selectByVisibleText("Futebol");

        driver.findElement(By.id(SUGESTOES)).sendKeys("Cadastrando aluno");
        driver.findElement(By.id(CADASTRAR)).click();

        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Cadastrado!"));
        Assert.assertEquals("Nome: Fernando",driver.findElement(By.id("descNome")).getText());
        Assert.assertEquals("Sobrenome: Ribeiro",driver.findElement(By.id("descSobrenome")).getText());
        Assert.assertEquals("Sexo: Masculino",driver.findElement(By.id("descSexo")).getText());
        Assert.assertEquals("Comida: Carne",driver.findElement(By.id("descComida")).getText());
        Assert.assertEquals("Escolaridade: superior",driver.findElement(By.id("descEscolaridade")).getText());
        Assert.assertEquals("Esportes: Futebol",driver.findElement(By.id("descEsportes")).getText());
        Assert.assertEquals("Sugestoes: Cadastrando aluno",driver.findElement(By.id("descSugestoes")).getText());


//        element = driver.findElement(By.id(RESULTADO));
//        Select result = new Select(element);
//        result.selectByVisibleText("Cadastrado!");
//        result.selectByVisibleText("Nome: Fernando");
//        result.selectByVisibleText("Sobrenome: Ribeiro");
//        result.selectByVisibleText("Sexo: Masculino");
//        result.selectByVisibleText("Comida: Carne");
//        result.selectByVisibleText("Escolaridade: Superior");
//        result.selectByVisibleText("Esportes: Futebol");
//        result.selectByVisibleText("Sugestoes: Cadastrando aluno");
    }
}
