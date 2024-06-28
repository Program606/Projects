package controller;

import java.io.IOException;

import application.FinanceApplication;

public class FinanceDriver {

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("rawtypes")
		FinanceApplication fp = new FinanceApplication();
		fp.run();

	}

}
