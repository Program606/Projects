package src.Application;
import java.io.IOException;

import src.Controller.Cleaning_Manager;

public class Cleaning_App {

    public static void main(String[] args) throws IOException{
        Cleaning_Manager cleaningManageObject = new Cleaning_Manager();
        cleaningManageObject.startProgram();
    }
}
