package day13;

import utils.BaseStaticDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _01_IntroRobotClass extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException, AWTException {
        driver.get("https://www.cleartrip.com/");
        Thread.sleep(5000);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
    }
}
