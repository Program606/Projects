
package com.prince.excelHandling;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.GroupLayout.Alignment;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress; 

public class ReadExcelFileDemo   {
// create a new workbook
static Workbook wb = new XSSFWorkbook();
// create a new sheet

public static void test() throws IOException{
createForm_1503New();
}
private static void createForm_1503New() throws IOException {
CreationHelper createHelper = wb.getCreationHelper();
FileOutputStream out = new FileOutputStream("workbook.xlsx");
Sheet s = wb.createSheet("First Sheet");
Row r = null;
Cell c = null;

for(int rowCount=0; rowCount < 3; rowCount++){ //create 3 rows
    r = s.createRow(rowCount);
    for(int cellCount =0; cellCount < 34; cellCount++){ //create 34 cells
        Cell currCell = createCell(wb, r, cellCount, 0);
        switch (rowCount) {
            case 0://creating subheader
                if(rowCount == 0){
                    switch (cellCount) {
                        case 0:
                            s.addMergedRegion(new CellRangeAddress(0,0,0,2));
                            currCell.setCellValue("Records Form");
                            break;
                        case 1:
                            s.addMergedRegion(new CellRangeAddress(0,0,3,30));
                            break;
                        case 31:
                            currCell.setCellValue("YEAR");
                            break;
                        case 32:
                            currCell.setCellValue("AREA");
                            break;
                        case 33:
                            currCell.setCellValue("GROUP");
                            break;
                        default:
                            r.setHeight((short) 0x100);
                            break;
                    }
            }
                break;
            case 1://creating title
            switch (cellCount) {
                case 0:
                    s.addMergedRegion(new CellRangeAddress(1,1,0,3));
                    currCell.setCellValue("R1-05");
                    break;
                case 4:
                    s.addMergedRegion(new CellRangeAddress(1,1,4,24));
                    currCell.setCellValue("WORSHIP SERVICE ATTENDANCE RECORD");
                    break;
                case 25:
                    s.addMergedRegion(new CellRangeAddress(1,1,25,27));
                    currCell.setCellValue("WEEK NO:");
                    break;
                case 28:
                    currCell.setCellValue("1");
                    break;
                case 29:
                    currCell.setCellValue("TO");
                    break;
                case 30:
                    currCell.setCellValue("30");
                    break;
                case 31:
                    currCell.setCellValue(2024);
                    break;
                case 32:
                    currCell.setCellValue("1");
                    break;
                case 33:
                    currCell.setCellValue("1");
                    break;
                default:
                    r.setHeight((short) 0x500);
                    break;
            }
                break;
            case 2://creating header
                switch (cellCount) {
                    case 0:
                        s.setColumnWidth(cellCount, 6 * 256);
                        r.setHeight( (short) 0x350);
                        s.addMergedRegion(new CellRangeAddress(2, 4, 0, 0));
                        currCell.setCellValue("NO");
                        break;
                    case 1:
                        s.setColumnWidth(cellCount, 40 * 256);
                        r.setHeight( (short) 0x350);
                        s.addMergedRegion(new CellRangeAddress(2, 4, 1, 1));
                        currCell.setCellValue("Name");
                        break;
                    case 2:
                        s.setColumnWidth(cellCount, 5 * 256);
                        r.setHeight( (short) 0x350);
                        s.addMergedRegion(new CellRangeAddress(2, 4, 2, 2));
                        currCell.setCellValue("CFO");
                        break;
                    case 3:
                        r.setHeight( (short) 0x125);
                        s.setColumnWidth(cellCount, 9 * 256);
                        currCell.setCellValue("Month");
                        break;
                    case 4:
                        s.addMergedRegion(new CellRangeAddress(2, 2, 4, 7));
                        break;
                    case 5:
                        s.addMergedRegion(new CellRangeAddress(2, 2, 8, 11));
                        break;
                    case 6:
                        s.addMergedRegion(new CellRangeAddress(2, 2, 12, 15));    
                        break;
                    case 7:
                        s.addMergedRegion(new CellRangeAddress(2, 2, 16, 19)); 
                        break;
                    case 8:
                        s.addMergedRegion(new CellRangeAddress(2, 2, 20, 23)); 
                        break;
                    case 9:
                        s.addMergedRegion(new CellRangeAddress(2, 2, 24, 27)); 
                        break;
                    case 10:
                        s.addMergedRegion(new CellRangeAddress(2, 2, 28, 31)); 
                        break;
                    case 11:
                        s.addMergedRegion(new CellRangeAddress(2, 2, 32, 33)); 
                        break;
                    default:
                        break;
            }
        
        //creating header
        
            }
        }
    }
    wb.write(out);
}
public static CellStyle returnCellStyle(int identifier){
    /*
     * 0 : Num Header
     * 1 : Name Header
     * 2 : CFO Header
     * 3 : Month/Week Num Header
     * 4 : ID Number Header
     * 5 : 
     */
    CellStyle cellStyle = wb.createCellStyle();
    switch (identifier) {
        
        //Center/Justify Center
        case 0: 
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            break;
        case 1:
            break;
        default:
            break;
    }
    return cellStyle;

}
private static Cell createCell(Workbook wb, Row row, int column, int identifier) {
    Cell cell = row.createCell(column);
    cell.setCellValue("X");
    cell.setCellStyle(returnCellStyle(identifier));
    return cell;
}
public static void cleanup(FileOutputStream out) throws IOException{
    out.close();
}
}
