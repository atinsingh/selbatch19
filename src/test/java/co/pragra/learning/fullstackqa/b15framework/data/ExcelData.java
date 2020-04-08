package co.pragra.learning.fullstackqa.b15framework.data;

import co.pragra.learning.fullstackqa.b15framework.config.Config;
import com.aventstack.extentreports.ExtentTest;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelData {
    private final Path path =Paths.get(Config.getProperty("file.location"),Config.getProperty("file.name") );
    private Workbook workbook;

    public ExcelData(){
        try(InputStream inputStream  = new FileInputStream(path.toFile())){
            workbook = new XSSFWorkbook(inputStream);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public List<Object []> getSheetData(String sheetName){
        List<Object []> sheetData = new ArrayList<>();
        Sheet sheet = workbook.getSheet(sheetName);
        Iterator<Row> rowIterator= sheet.rowIterator();
        // it will skip the header
        // enhance later to handle well
        if(rowIterator.hasNext()) rowIterator.next();


        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
           Iterator<Cell> cellIterator =   row.cellIterator();
           List<Object> cellData = new ArrayList<>();
           while (cellIterator.hasNext()){
               Cell cell = cellIterator.next();
               cellData.add(getCellValue(cell));
           }
           sheetData.add(cellData.toArray());
        }
        return sheetData;
    }

    private Object getCellValue(Cell cell){
        if(cell.getCellType() == CellType.NUMERIC){
            return cell.getNumericCellValue();
        }
        if(cell.getCellType() == CellType.STRING){
            return cell.getStringCellValue();
        }
        if(cell.getCellType() == CellType.BOOLEAN){
            return cell.getBooleanCellValue();
        }
        return cell.getStringCellValue();

    }

}
//Flat File
// word
// pdf
// excel
// format / encoding