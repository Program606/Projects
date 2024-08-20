
package com.prince.excelHandling;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Member;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.GroupLayout.Alignment;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
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

public class ExcelFile   {
// create a new workbook
static Workbook wb = new XSSFWorkbook();

public static void test(ArrayList<com.prince.application.Member> memberList) throws IOException{
createForm_1503(memberList, checkCurrDate());
}
private static void createForm_1503(ArrayList<com.prince.application.Member> memberList, String date) throws IOException {
FileOutputStream out = new FileOutputStream("1503Form-"+date+".xlsx");
Sheet s = wb.createSheet("First Sheet");
Row r = null;

final int MAXCELLS = 56;

for(int rowCount=0; rowCount < memberList.size()+4; rowCount++){ //4 starter rows + memberList
    r = s.createRow(rowCount);

    for(int cellCount =0,weekcount=0; cellCount < MAXCELLS; cellCount++){ //create 56 cells
        Cell currCell = createCell(wb, r, cellCount, 0);
        currCell.setCellStyle(returnCellStyle(1));
        
        if(cellCount > 3){
            s.setColumnWidth(cellCount, 3 * 256);
        }
        if(rowCount > 3){
            fillMemberData(cellCount, rowCount, r, memberList);
        }else{
            switch (rowCount) {
                case 0://title
                switch (cellCount) {
                    case 0:
                        s.addMergedRegion(new CellRangeAddress(rowCount,rowCount,0,2));
                        currCell.setCellValue("R1-05");
                        currCell.setCellStyle(returnCellStyle(3));
                        break;
                    case 3:
                        s.addMergedRegion(new CellRangeAddress(rowCount,rowCount,3,30));
                        currCell.setCellValue("WORSHIP SERVICE ATTENDANCE RECORD");
                        currCell.setCellStyle(returnCellStyle(2));
                        break;
                    case 31:
                        s.addMergedRegion(new CellRangeAddress(rowCount,rowCount,31,35));
                        currCell.setCellValue("WEEK NO:");
                        currCell.setCellStyle(returnCellStyle(1));
                        break;
                    case 36:
                        s.addMergedRegion(new CellRangeAddress(0, 0, 36, 40));
                        currCell.setCellValue("1 TO 52");
                        currCell.setCellStyle(returnCellStyle(1));
                        break;
                    case 41:
                        s.addMergedRegion(new CellRangeAddress(0, 0, 41, 45));
                        currCell.setCellValue("Year \n \n 2024 \n");
                        currCell.setCellStyle(returnCellStyle(1));
                        break;
                    case 46:
                        s.addMergedRegion(new CellRangeAddress(0, 0, 46, 50));
                        currCell.setCellValue("Area \n \n 1 \n");
                        currCell.setCellStyle(returnCellStyle(1));
                        break;
                    case 51:
                        s.addMergedRegion(new CellRangeAddress(0, 0, 51, 55));
                        currCell.setCellValue("Group \n \n 1 \n");
                        currCell.setCellStyle(returnCellStyle(1));
                        break;
                    
                /**
                 * Formatting cells
                 */
                    case 26:
                    case 27:
                    case 29:
                        currCell.setCellStyle(returnCellStyle(1));
                        break;
                        default:
                        r.setHeight((short) 0x500);
                        break;
                    }break;
                case 1://creating title
                    if(cellCount > 3){
                        currCell.setBlank();
                    }
                    switch (cellCount) {
                        case 0:
                            s.setColumnWidth(cellCount, 6 * 256);
                            r.setHeight( (short) 0x350);
                            s.addMergedRegion(new CellRangeAddress(rowCount, rowCount+2, 0, 0));
                            currCell.setCellValue("NO");
                            break;
                        case 1:
                            s.setColumnWidth(cellCount, 40 * 256);
                            r.setHeight( (short) 0x350);
                            s.addMergedRegion(new CellRangeAddress(rowCount, rowCount+2, 1, 1));
                            currCell.setCellValue("Name");
                            break;
                        case 2:
                            s.setColumnWidth(cellCount, 8 * 256);
                            r.setHeight( (short) 0x350);
                            s.addMergedRegion(new CellRangeAddress(rowCount, rowCount+2, 2, 2));
                            currCell.setCellValue("CFO");
                            break;
                        case 3:
                            r.setHeight( (short) 0x125);
                            s.setColumnWidth(cellCount, 20 * 256);
                            currCell.setCellValue("Month");
                            break;
                        case 4:
                            s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 4, 11));
                            break;
                        case 5:
                            s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 12, 19));
                            break;
                        case 6:
                            s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 20, 27));    
                            break;
                        case 7:
                            s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 28, 35)); 
                            break;
                        case 8:
                            s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 36, 43)); 
                            break;
                        case 9:
                            s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 44, 51)); 
                            break;
                        case 10:
                            s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 52, 55)); 
                            break;
                    }break;
                case 2://Week No
                    if(cellCount == 3){
                        currCell.setCellValue("Week No");
                    }
                    else if(cellCount > 3){
                        currCell.setCellValue(cellCount-3);
                        switch (cellCount) {          
                            case 4:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 4, 5));
                                break;
                            case 5:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 6, 7));
                                break;
                            case 6:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 8, 9));
                                break;
                            case 7:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 10, 11));
                                break;
                            case 8:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 12, 13));
                                break;
                            case 9: 
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 14, 15));
                                break;
                            case 10:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 16, 17));
                                break;
                            case 11:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 18, 19));
                                break;
                            case 12:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 20, 21));
                                break;
                            case 13:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 22, 23));
                                break;
                            case 14:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 24, 25));
                                break;
                            case 15:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 26, 27));
                                break;
                            case 16:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 28, 29));
                                break;
                            case 17:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 30, 31));
                                break;
                            case 18:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 32, 33));
                                break;
                            case 19:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 34, 35));
                                break;
                            case 20:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 36, 37));
                                break;
                            case 21:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 38, 39));
                                break;
                            case 22:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 40, 41));
                                break;
                            case 23:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 42, 43));
                                break;
                            case 24:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 44, 45));
                                break;
                            case 25:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 46, 47));
                                break;
                            case 26:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 48, 49));
                                break;
                            case 27:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 50, 51));
                                break;
                            case 28:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 52, 53));
                                break;
                            case 29:
                                s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 54, 55));
                                break;
                            case 30:
                            s.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 56, 57));
                                break;
                        }
                    }
                    break;
                case 3://week day
                if(cellCount == 3){
                    currCell.setCellValue("ID Number");
                }
                else if(cellCount % 2 == 0 && cellCount > 3){
                    currCell.setCellValue("T");
                }else if(cellCount % 2 == 1 && cellCount > 3){
                    currCell.setCellValue("S");
                }
                break;
                
                }
            }  
        }
    }
    wb.write(out);
}
private static void fillMemberData(int cellCount, int rowCount, 
Row r, ArrayList<com.prince.application.Member> memberList) {
    switch (cellCount) {
        case 0:
            r.getCell(cellCount).setCellValue(rowCount-4);
            break;
        case 1:
            r.getCell(cellCount).setCellValue(memberList.get(rowCount-4).getFirstName()+" "+
            memberList.get(rowCount-4).getMiddleName()+" "+memberList.get(rowCount-4).getLastName());
            break;
        case 2:
            r.getCell(cellCount).setCellValue(memberList.get(rowCount-4).getCFO());
    }
}
private static String checkCurrDate() {
    LocalDate currDate = LocalDate.now();
    return currDate.getYear()+"-"+currDate.getMonthValue()+"-"+currDate.getDayOfMonth();

}
public static CellStyle returnCellStyle(int identifier){
    /*
     * 0 : alignCenter
     * 1 : allBorder
     * 2 : titleHeader
     * 3 : subHeader
     */
    CellStyle cellStyle = wb.createCellStyle();
    switch (identifier) {
        
        //Center/Justify Center
        case 0: 
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle.setWrapText(true);
            break;
        case 1:
            cellStyle.setBorderTop(BorderStyle.THIN);
            cellStyle.setBorderLeft(BorderStyle.THIN);
            cellStyle.setBorderRight(BorderStyle.THIN);
            cellStyle.setBorderBottom(BorderStyle.THIN);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle.setWrapText(true);
            break;
        case 2:
            cellStyle.setFont(returnFontStyle(0));
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            break;
        case 3:
            cellStyle.setFont(returnFontStyle(1));
            cellStyle.setAlignment(HorizontalAlignment.LEFT);
            cellStyle.setVerticalAlignment(VerticalAlignment.BOTTOM);
            cellStyle.setWrapText(true);
            break;
        case 4:
            break;
        default:
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            cellStyle.setWrapText(true);
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
private static Font returnFontStyle(int identifier){ //not finished.
    /**
     * Styles
     * 0: titleFont
     * 1: subHeaderFont
     * 2: 
     *  */    
    Font font = wb.createFont();
    switch (identifier) {
        /*
         * 0: Title
         * 1: SubHeader
         */
            case 0:
                font.setFontHeightInPoints((short) 25);
                break;
            case 1:
                font.setFontHeightInPoints((short) 20);
                break;
        
            default:
                break;
        }
        return font;
    }
}
