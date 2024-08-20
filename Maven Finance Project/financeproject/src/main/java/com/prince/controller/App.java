package com.prince.controller;

import java.io.IOException;

import com.prince.application.FinanceApplication;
import com.prince.excelHandling.ExcelFile;
public class App
{
    public static void main( String[] args ) throws IOException
    {
        @SuppressWarnings("rawtypes")
        FinanceApplication fp = new FinanceApplication();
		fp.run();
    }
}
