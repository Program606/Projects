package com.prince.controller;

import java.io.IOException;

import com.prince.application.FinanceApplication;
public class App
{
    public static void main( String[] args ) throws IOException
    {
        FinanceApplication fp = new FinanceApplication();
		fp.run();
    }
}
