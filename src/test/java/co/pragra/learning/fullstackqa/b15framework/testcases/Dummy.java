package co.pragra.learning.fullstackqa.b15framework.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dummy {

    @Test(dataProvider = "anotheDataProvider")
    public void test(String name, int num){
        System.out.println("testing");
        System.out.println(name + "  "+ num);
    }

    @DataProvider
    public Object[][] dummyDataProvider(){
        return new Object[][] {
                                    {"Atin",11} ,
                                    {"Vivek",12}
                               };
    }

    @DataProvider
    public Iterator<Object []> anotheDataProvider(){
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"Cat", 23});
        data.add(new Object[]{"Dog", 90});
        return data.iterator();
    }
}
