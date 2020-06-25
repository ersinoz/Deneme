package day6;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.BaseDriver;

import java.util.ArrayList;

public class _01_LoginFunctionTest extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://www.saucedemo.com/");
        ArrayList<String> usernames = new ArrayList<>();
        usernames.add("standard_user");
        usernames.add("locked_out_user");
        usernames.add("problem_user");
        usernames.add("performance_glitch_user");
        String password = "secret_sauce";

        ArrayList<String>  expectedErrorMessages =  new ArrayList<>();
        expectedErrorMessages.add("success");
        expectedErrorMessages.add("Epic sadface: Sorry, this user has been locked out.");
        expectedErrorMessages.add("success");
        expectedErrorMessages.add("success");

        int index = 0;
        for (String username : usernames) {
            String loginResult = login(username, password);
            if(loginResult.equals("success")) {
                driver.navigate().back(); // TODO: create log out function here
            }
            System.out.println("for username: " + username + " the result is: " + loginResult);
            Assert.assertEquals(expectedErrorMessages.get(index), loginResult);
            index++;
        }
    }

    // login function
    public static String login(String username, String password) {
        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameInput.clear();
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@data-test='password']"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        driver.findElement(By.xpath("//input[@class='btn_action']")).click();

        try {
            // check if logged in by find cart element
            driver.findElement(By.xpath("//a[contains(@class,'shopping_cart')]"));
            return "success";
        } catch (NoSuchElementException e) {
            try {
                // get the error message
                return driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText();
            } catch (NoSuchElementException error) {
                return "failure: error message not found!";
            }
        }
    }
}
