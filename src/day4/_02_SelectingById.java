package day4;

import utils.BaseDriver;

public class _02_SelectingById extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://formsmarts.com/form/yu?mode=h5");  // this will open the website and wait until full load
        Thread.sleep(3000); // wait for 3 seconds
        driver.quit();
    }
}
