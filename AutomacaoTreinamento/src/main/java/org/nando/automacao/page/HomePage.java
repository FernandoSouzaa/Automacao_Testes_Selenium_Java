package org.nando.automacao.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.Console;
import java.util.List;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void editTextCampo(String nome){
        driver.findElement(By.id("elementosForm:nome")).sendKeys(nome);
    }

    public void textArea(String descricao){
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys(descricao);
    }

    public void radioButton(){
        driver.findElement(By.id("elementosForm:sexo:0")).click();
    }

    public void checkBox(){
        int cont = 0;
        for (int i=0; cont <= 7; i++){
            WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
            Select combo = new Select(element);
            //combo.selectByIndex(cont);
            //combo.selectByValue("Superior");
            combo.selectByVisibleText("2o grau incompleto");
            Assert.assertEquals("2o grau incompleto", combo.getFirstSelectedOption().getText());
            cont++;
        }
    }

    //pega os campos combo salva na lista, verifica a quantidade e verifca de um determinado campo está presente no combo
    public void checkBoxVerificarValores(){
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        Assert.assertEquals(8, options.size());

        boolean encontrou = false;
        for(WebElement option : options){
            if (option.getText().equals("Mestrado")){
                encontrou = true;
                break;
            }
        }
        Assert.assertTrue(encontrou);
    }

    public void checkComboMultiplo(){
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");

        //pega todos os valores que foram selecionados
        List<WebElement> allSelectorsOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(3, allSelectorsOptions.size());
    }

    public void validandoClickRadioButton(String idCampo){
        Assert.assertTrue(driver.findElement(By.id(idCampo)).isSelected());
    }

    public void validandoTextoCampo(String idCampo, String valueEsperado){
        Assert.assertEquals(valueEsperado, driver.findElement(By.id(idCampo)).getAttribute("value"));
    }

}
