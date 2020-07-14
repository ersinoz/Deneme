package day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseDriver;
import utils.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _01_DemoQA extends BaseDriver {

    private String username;
    private String password;
    private ReusableMethods methods;

    @BeforeClass
    void goToWebsite() {
        username = "daulet";
        password = "DV@d9FjCm";
        driver.get("https://demoqa.com/books");
        driver.manage().window().maximize();
        methods = new ReusableMethods(wait, driver, js);
    }

    @Test
    void loginTestCase() {
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("userName")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#userName-value")));
        Assert.assertEquals(username, driver.findElement(By.cssSelector("#userName-value")).getText());
    }

    @Test(dependsOnMethods = {"loginTestCase"})
    void addSingleToToCollectionTestCase() {
        List<WebElement> elements = methods.waitAndGetList(By.cssSelector(".mr-2"));
        addBook(elements, new Random().nextInt(elements.size()));
        removeAllBookFromCollection();
    }

    @Test(priority = 1, dependsOnMethods = {"loginTestCase"})
    void addSeveralBookToCollectionTestCase() {
        // generate a random number up to number of books
        List<WebElement> elements = methods.waitAndGetList(By.cssSelector(".mr-2"));
        int numberOfElementsToAdd = new Random().nextInt(elements.size()) + 1;
        System.out.println("Adding " + numberOfElementsToAdd + " elements!");
        // add those books to collection
        List<String> booksAdded = new ArrayList<>();
        for (int i = 0; i < numberOfElementsToAdd; i++) {
            booksAdded.add(addBook(elements, i));
            driver.navigate().back();
            elements = methods.waitAndGetList(By.cssSelector(".mr-2"));
        }

        // verify that the books you added are the same in the profile
        driver.navigate().to("https://demoqa.com/profile");
        elements = methods.waitAndGetList(By.cssSelector(".mr-2"));
        methods.verifyListContainsAll(elements, booksAdded);

        // delete all in the end
        removeAllBookFromCollection();

    }

    @Test(priority = 1, dependsOnMethods = {"loginTestCase"})
    void deleteASingleBookTestCase() {
        // add a book
        List<WebElement> elements = methods.waitAndGetList(By.cssSelector(".mr-2"));
        addBook(elements, new Random().nextInt(elements.size()));
        // go profile and delete it
        driver.navigate().to("https://demoqa.com/profile");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".mr-2"), 0));
        driver.findElement(By.id("delete-record-undefined")).click();
        // verify it was deleted
        methods.waitAndClick(By.id("closeSmallModal-ok"));
        methods.verifyAlertText("Book deleted.");
    }

    @Test(priority = 1, dependsOnMethods = {"loginTestCase"})
    void searchForABookTestCase() {
        // type searchTerm into search box
        String searchTerm = "Js";
        driver.findElement(By.cssSelector("#searchBox")).sendKeys(searchTerm);
        // get the list of books
        List<WebElement> elements = methods.waitAndGetList(By.cssSelector(".mr-2"));
        // very that all books contains the searchTerm
        methods.verifyAllContainsText(elements, searchTerm);
    }



    @BeforeMethod
    void navigateToBooks() {
        driver.navigate().to("https://demoqa.com/books");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".mr-2"), 0));
    }

    private String addBook(List<WebElement> elements, int index) {
        WebElement element = elements.get(index);
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();

        methods.waitScrollAndClick(By.cssSelector(".text-right #addNewRecordButton"));
        methods.verifyAlertText("Book added to your collection.");

        return driver.findElement(By.cssSelector("#title-wrapper #userName-value")).getText();
    }

    private void removeAllBookFromCollection() {
        driver.navigate().to("https://demoqa.com/profile");
        methods.waitScrollAndClick(By.cssSelector(".justify-content-end .text-right #submit"));
        methods.waitAndClick(By.id("closeSmallModal-ok"));
        methods.verifyAlertText("All Books deleted.");
    }

}
