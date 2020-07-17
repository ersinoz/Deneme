package day19;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _05_DataProviderWithIteratorTest {

    @Test(dataProvider = "credentialsProvider")
    void testCase1(String name) {
        System.out.println("The name is: " + name);
    }

    @DataProvider(name = "credentialsProvider")
    public Iterator<Object> data() {
        List<Object> list = new ArrayList<>();
        list.add("Anne");
        list.add("Cedric");
        return list.iterator();
    }

    @Test(dataProvider = "credentialsProvider2")
    void testCase2(String name, String password) {
        System.out.println("The name is: " + name + " and password is: " + password);
    }

    @DataProvider(name = "credentialsProvider2")
    public Iterator<Object[]> data2() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"cedric", "password1"});
        list.add(new Object[]{"anne", "password1"});
        return list.iterator();
    }
}
