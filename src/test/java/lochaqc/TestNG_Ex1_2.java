package lochaqc;

import lochaqc.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class TestNG_Ex1_2 extends BaseTest{

    @BeforeMethod
    public void loginCMS(){
        System.out.println("Login");
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        // getScreenSize() method returns the size of the screen in pixels
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        // getWidth() method returns the height of the screen
        int width = (int)size.getWidth();

        // getHeight() method returns the height of the screen
        int height = (int)size.getHeight();

        System.out.println("Screen resolution: ");
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    @Test(priority = 1)
    public void addCategory(){
        System.out.println("Add Category");
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();
        WebUI.sleep(2);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Category 123");
        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div/div")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Computer", Keys.ENTER);
        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[normalize-space()='Banner (200x200)']/following-sibling::div")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("Selenium4", Keys.ENTER);
        WebUI.sleep(4);
        driver.findElement(By.xpath("//img[@class='img-fit']")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        WebUI.sleep(2);
        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("Category 123");
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("Category 123");
        WebUI.sleep(1);
        driver.findElement(By.xpath("//div[contains(text(),'Nothing selected')]")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Size", Keys.ENTER);
        WebUI.sleep(1);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//input[@placeholder='Type name & Enter']")).sendKeys("Category 123", Keys.ENTER);
        String categoryItem = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
        System.out.println("Get category item: "+categoryItem);
        Assert.assertEquals(categoryItem, "Category 123");
        WebUI.sleep(2);


    }


}
