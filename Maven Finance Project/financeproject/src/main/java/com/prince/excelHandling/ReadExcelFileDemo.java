
package com.prince.excelHandling;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.GroupLayout.Alignment;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook; 

public class ReadExcelFileDemo   {
// create a new workbook
static Workbook wb = new HSSFWorkbook();
// create a new sheet
static Sheet s = wb.createSheet();
// declare a row object reference
static Row r = null;
// declare a cell object reference
static Cell c = null;

public static void test() throws IOException{
FileOutputStream out = new FileOutputStream("workbook.xls");
createForm_1503(out);
cleanup(out);
}
public static void createForm_1503(FileOutputStream out) throws IOException{

short rownum;


for (rownum = (short) 0; rownum < 30; rownum++) //create 30 rows
{
    // create a row
    r = s.createRow(rownum);
    // on every other row
    // if ((rownum % 2) == 0)
    // {
    //     // make the row height bigger  (in twips - 1/20 of a point)
    //     r.setHeight((short) 0x250);
    // }

    for (short cellnum = (short) 0; cellnum < 9; cellnum++) //create 9 cells
    {
        c = r.createCell(cellnum);

        if(rownum == 0 && (cellnum == 0 || cellnum == 1)){
            s.setColumnWidth(cellnum, 20 * 256);
            r.setHeight( (short) 0x350);
            c.setCellValue("Testing");

            CellStyle cellStyle = c.getCellStyle();
            cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
            cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        }
        else if(rownum == 0 && (cellnum == 3)){
            
        }
        else{
        // do some goofy math to demonstrate decimals
        c.setCellValue(rownum * 10000 + cellnum
                + (((double) rownum / 1000)
                + ((double) cellnum / 10000)));
        String cellValue;
        // create a string cell (see why += 2 in the
        c = r.createCell((short) (cellnum + 1));
        // make this column a bit wider
        // s.setColumnWidth((short) (cellnum + 1), (short) ((50 * 8) / ((double) 1 / 20)));
    }
    }

//end draw thick black border
// demonstrate adding/naming and deleting a sheet
// create a sheet, set its title then delete it
s = wb.createSheet();
wb.setSheetName(1, "DeletedSheet");
wb.removeSheetAt(1);
//end deleted sheet
// write the workbook to the output stream
wb.write(out);
}

    // // create 3 cell styles
    // CellStyle cs = wb.createCellStyle();
    // CellStyle cs2 = wb.createCellStyle();
    // CellStyle cs3 = wb.createCellStyle();
    // DataFormat df = wb.createDataFormat();
    // // create 2 fonts objects
    // Font f = wb.createFont();
    // Font f2 = wb.createFont();
    // //set font 1 to 12 point type
    // f.setFontHeightInPoints((short) 12);
    // //make it blue
    // f.setColor( (short)0xc );
    // // make it bold
    // //arial is the default font
    // f.setBoldweight(Font.BOLDWEIGHT_BOLD);
    // //set font 2 to 10 point type
    // f2.setFontHeightInPoints((short) 10);
    // //make it red
    // f2.setColor( (short)Font.COLOR_RED );
    // //make it bold
    // f2.setBoldweight(Font.BOLDWEIGHT_BOLD);
    // f2.setStrikeout( true );
    // //set cell stlye
    // cs.setFont(f);
    // //set the cell format
    // cs.setDataFormat(df.getFormat("#,##0.0"));
    // //set a thin border
    // cs2.setBorderBottom(cs2.BORDER_THIN);
    // //fill w fg fill color
    // cs2.setFillPattern((short) CellStyle.SOLID_FOREGROUND);
    // //set the cell format to text see DataFormat for a full list
    // cs2.setDataFormat(HSSFDataFormat.getBuiltinFormat("text"));
    // // set the font
    // cs2.setFont(f2);

    // // set the sheet name in Unicode
    // wb.setSheetName(0, "\u0422\u0435\u0441\u0442\u043E\u0432\u0430\u044F " +
    //                 "\u0421\u0442\u0440\u0430\u043D\u0438\u0447\u043A\u0430" );
}
public static void cleanup(FileOutputStream out) throws IOException{
    out.close();
}
}
