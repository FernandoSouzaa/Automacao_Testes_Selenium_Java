package org.nando.automacao.page;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageCadastro {

    WebDriver driver;

    final String NOME = "elementosForm:nome";
    final String SOBRENOME = "elementosForm:sobrenome";
    final String SEXO = "elementosForm:sexo:0";
    final String COMIDA_CARNE = "elementosForm:comidaFavorita:0";
    final String COMIDA_FRANGO = "elementosForm:comidaFavorita:1";
    final String COMIDA_VEGETARIANO = "elementosForm:comidaFavorita:3";
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
        driver.findElement(By.id(COMIDA_CARNE)).click();

        WebElement element = driver.findElement(By.id(ESCOLARIDADE));
        Select escolaridade = new Select(element);
        escolaridade.selectByVisibleText("Superior");

        element = driver.findElement(By.id(ESPORTES));
        Select esportes = new Select(element);
        esportes.selectByVisibleText("Futebol");

        driver.findElement(By.id(SUGESTOES)).sendKeys("Cadastrando aluno");
        driver.findElement(By.id(CADASTRAR)).click();

//        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Cadastrado!"));
//        Assert.assertEquals("Cadastrado!", driver.findElement(By.id("resultado")).getText());
//        Assert.assertEquals("Nome: Fernando",driver.findElement(By.id("descNome")).getText());
//        Assert.assertEquals("Sobrenome: Ribeiro",driver.findElement(By.id("descSobrenome")).getText());
//        Assert.assertEquals("Sexo: Masculino",driver.findElement(By.id("descSexo")).getText());
//        Assert.assertEquals("Comida: Carne",driver.findElement(By.id("descComida")).getText());
//        Assert.assertEquals("Escolaridade: superior",driver.findElement(By.id("descEscolaridade")).getText());
//        Assert.assertEquals("Esportes: Futebol",driver.findElement(By.id("descEsportes")).getText());
//        Assert.assertEquals("Sugestoes: Cadastrando aluno",driver.findElement(By.id("descSugestoes")).getText());

        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Fernando"));
        Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().endsWith("Ribeiro"));
        Assert.assertTrue(driver.findElement(By.id("descSexo")).getText().endsWith("Masculino"));
        Assert.assertTrue(driver.findElement(By.id("descComida")).getText().endsWith("Carne"));
        Assert.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().endsWith("superior"));
        Assert.assertTrue(driver.findElement(By.id("descEsportes")).getText().endsWith("Futebol"));
        Assert.assertTrue(driver.findElement(By.id("descSugestoes")).getText().endsWith("Cadastrando aluno"));

    }

    public void regrasNegocioNomeESobrenome(String idCampo, String text, String preencher) throws InterruptedException {
        WebElement element = driver.findElement(By.id(idCampo));
        element.sendKeys("");
        if (element.getText().isEmpty()){
            driver.findElement(By.id(CADASTRAR)).click();
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals(text+" eh obrigatorio", alert.getText());
           Thread.sleep(1000);
            alert.accept();
            element.sendKeys(preencher);
        }
    }

    public void regraNegocioSexo() throws InterruptedException {
        WebElement element = driver.findElement(By.id(SEXO));
        boolean selecionado = false;
        if (element.isSelected() == selecionado){
            driver.findElement(By.id(CADASTRAR)).click();
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
            Thread.sleep(1000);
            alert.accept();
            element.click();
            selecionado = true;
        }
    }

    public void comidaFavorita(String idCampo) throws InterruptedException {
        WebElement element = driver.findElement(By.id(idCampo));
        WebElement elementt = driver.findElement(By.id(COMIDA_VEGETARIANO));
        element.click();
        elementt.click();
        boolean selecionado = true;
        if (element.isSelected() == selecionado && elementt.isSelected() == selecionado){
            driver.findElement(By.id(CADASTRAR)).click();
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
            Thread.sleep(1000);
            alert.accept();
            element.click();
            elementt.click();
            selecionado = false;
        }
    }
}
