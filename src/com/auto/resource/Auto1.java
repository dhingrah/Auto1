package com.auto.resource;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auto1 {
	
	
	boolean result= false;
	boolean result1= false;
	WebDriver driver;
	int year=2015;
	@Test
	public void Launch() throws InterruptedException{
		String workingDir = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver",workingDir+"\\Drivers\\geckodriver.exe");
		 driver = new FirefoxDriver();

		driver.get("https://www.autohero.com/de/search/");

		Thread.sleep(2000);
	}
	
	
	@Test
	public void verifyYear() throws InterruptedException{
		driver.findElement(By.xpath(".//span[text()='Erstzulassung']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='app']/div/main/div[4]/div/div[1]/div/div/div/div[3]/div[2]/div/div/span[2]")).click();
        List<WebElement> years = driver.findElements(By.cssSelector(".option___2yqJT>span"));
        
        for (int i=0; i<years.size(); i++){
        if(years.get(i).getText().equals("2015")){
               Thread.sleep(3000);
               years.get(i).click();
               Thread.sleep(3000);
               break;
        }
        }
        
        List<WebElement> yearlist = driver.findElements(By.cssSelector(".specList___2i0rY>li:nth-child(1)"));
        
        for (int j=0; j<yearlist.size(); j++){
               
               String myString = yearlist.get(j).getText().substring(2,6);
               Thread.sleep(3000);
               Integer x = Integer.valueOf(myString);
               if(x<2015){
            	   result=false;
               }
               else{
            	   result=true;
               }
              
               System.out.println(x);        
        }
        
        Assert.assertTrue(result, "No cars with year less than 2015");
	}
        
  @Test
  public void verifyPriceOrder(){ 
        
        List<WebElement> priceele = new LinkedList<WebElement>();
        
        		
        priceele= driver.findElements(By.xpath("//div[@class='totalPrice___3yfNv']"));
        List<Double> prices =  new LinkedList<Double>();
        List<Double> prices1 =  new LinkedList<Double>();
        for(int i=0;i<priceele.size();i++){
        	 String s = priceele.get(i).getText().substring(0,5);
           // String s = priceele.get(i).getText();
        	 Double price = Double.valueOf(s);
            prices.add(price);
            prices1.add(price);
            System.out.println(price);
        }
        Collections.reverse(prices1);
        boolean result1=prices.equals(prices1);
        Assert.assertTrue(result1, "prices are in decending order");
       
        
	}

}
