package co.pragra.learning.fullstackqa.b15framework.data;

import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class LoginDataProvider {

    @DataProvider
    public static Iterator<Object[]> loginProvider(){
        ExcelData excelData = new ExcelData();
        return excelData.getSheetData("Login").iterator();
    }
}
