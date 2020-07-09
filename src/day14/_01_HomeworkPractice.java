package day14;

import utils.BaseDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _01_HomeworkPractice extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://pwa-woo.wpmobilepack.com/#/category/88");
    }
}

//Navigate to  https://pwa-woo.wpmobilepack.com/#/category/88
//
//Add two random items to the cart
//    Get the name of the item
//
//Navigate to cart.
//    Verify name of the item is displayed in the cart.
//
//Total of two items should be equal to number next to Total text
//
//Note:
//  Some items have drop down you need to handle those drop down(s). Choose first option    from the dropdown.
//   Do not use Thread.sleep
//   Each item should be added one time.
//   To make sure your code is working run it at least 5 times.
