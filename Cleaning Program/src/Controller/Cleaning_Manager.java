package src.Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import src.Model.Employee;
import src.View.Visual;

public class Cleaning_Manager {
    
    final String FILE_INFO = "res/worker_info.txt";
    public String tokens[];
    public String name;
    public int age;
    public float totalHours, totalSalary, wage;
    public ArrayList<Employee> EmployeeList;

    Visual viewObject = new Visual();
    Scanner keyboard = new Scanner(System.in);
    int TOTAL_OPTIONS = 4;

    /* 
     * Reads the Worker Information to give program information oF Worker Names, Hours, etc.
    */
    public ArrayList<Employee> loadData() throws IOException{

        try {
            //Adding the file location into a file_reader
            BufferedReader reader = new BufferedReader(new FileReader(FILE_INFO));

            //To make a reading loop, make a var that occupies a line, stops until reaches bottom
            String line;

            //Making an EmployeeList that holds all Employees.
            EmployeeList = new ArrayList<Employee>();

            while((line = reader.readLine()) != null){             
                //Splitting line into tokens to separate data.
                String tokens[] = line.split(";");
                name = tokens[0];
                age = Integer.parseInt(tokens[1]);
                totalHours = Float.parseFloat(tokens[2]);
                totalSalary = Float.parseFloat(tokens[3]);
                wage = Float.parseFloat(tokens[4]);

                //Creating Employees, using Employee object, using tokenized info.
                Employee employee = new Employee(name, age, totalHours, totalSalary, wage);
                EmployeeList.add(employee);

            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return EmployeeList;
    }

    public void startProgram() throws IOException{
        loadData();
        showMenu();
        isEnterPressed();
        writeData();
    }
    
    public char validateOption(){
        String userInput;
        char userInputChar = ' ';
        boolean validInput = false;

        while(!validInput){
            userInput = keyboard.nextLine();

            if(!userInput.equals("")){
                userInputChar = userInput.charAt(0);

                if (Character.isDigit(userInputChar)){

                }else{
                    viewObject.optionContainsNoNumMsg();

            }if(userInputChar <= TOTAL_OPTIONS){
                validInput = true;
                
            }else{
                viewObject.notAvailableMsg();
            }
        }
            else{
                viewObject.emptyOptionMsg();
            }
        }

        return userInputChar;
    }
    /*Shows the inital Menu of the Program*/
    public void showMenu(){
        viewObject.showStartMenu();
        viewObject.showEnterOptionMsg();

        char menuOptionChar = validateOption();
        switch(menuOptionChar){
            case '1': 
                isEnterPressed();
                viewObject.showInputData();
                
            break;

            case '2':
            break;

            case '3':
            break;

            case '4':
            break;
        }
    }

    public void isEnterPressed(){
        boolean enterPressed = false;
        viewObject.isEnterPressedMsg();


        while(!enterPressed){
            String userInput = keyboard.nextLine();

        if(userInput.equals("")){
            enterPressed = true;
        }
    }
    }




    /*
    Overwriting new content to worker info if any
    */
    public void writeData(){

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_INFO));

            for(Employee employee: EmployeeList){
                 writer.write(employee.getName() + ";" + employee.getAge() + ";" + employee.getTotalHours() + ";" + employee.getTotalSalary() + ";" + employee.getWage() + "\n");
            }
            writer.close();
        
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
