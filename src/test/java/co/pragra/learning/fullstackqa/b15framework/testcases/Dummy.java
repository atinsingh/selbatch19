package co.pragra.learning.fullstackqa.b15framework.testcases;

import co.pragra.learning.fullstackqa.b15framework.data.ExcelData;
import co.pragra.learning.fullstackqa.b15framework.data.LoginDataProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Dummy {

    @Test(dataProvider = "loginProvider", dataProviderClass = LoginDataProvider.class)
    public void test(String login, String pass){
        System.out.println(login);
        System.out.println(pass);
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
