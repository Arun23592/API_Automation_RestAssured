package API.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "AllData")
    public String [][] AllDataProvider(){
        String fileName = System.getProperty("user.dir")+"//TestData//APITestData.xlsx";

        int ttlRowCount = ReadExcelFile.getRowCount(fileName, "Sheet1");
        int ttlColCount = ReadExcelFile.getColCount(fileName, "Sheet1");

        String[][] userData = new String[ttlRowCount-1][ttlColCount];

        for (int rowNo = 1; rowNo<=ttlRowCount; rowNo++){
            for (int colNo = 1; colNo<= ttlColCount; colNo++){
                userData[rowNo-1][colNo] = ReadExcelFile.getCellValue(fileName, "Sheet1", rowNo, colNo);

            }
        }
        return userData;
    }


    @DataProvider(name = "userNamesData")
    public String[] UserNamesDataProvider(){
        String fileName = System.getProperty("user.dir")+"//TestData//APITestData.xlsx";
        int ttlRowCount = ReadExcelFile.getRowCount(fileName, "Sheet1");

        String[] userNamesData = new String[ttlRowCount-1];
        for (int rowNo=1; rowNo<ttlRowCount; rowNo++){
            userNamesData[rowNo-1] = ReadExcelFile.getCellValue(fileName, "Sheet1", rowNo,1);
        }
        return userNamesData;
    }
}
