package src.Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import src.Model.Employee;
import src.View.ExceptionView;
import src.View.Visual;

public class Cleaning_Manager {
    
    final String FILE_INFO = "res/worker_info.txt";
    public String tokens[];
    public String name;
    public int age;
    public float totalHours, totalSalary, wage;
    public ArrayList<Employee> EmployeeList;

    Visual viewObject = new Visual();
    ExceptionView viewException = new ExceptionView();
    Scanner keyboard = new Scanner(System.in);
    char TOTAL_OPTIONS = '4';
    String userInput;
    boolean userConfirm, validInput = false;
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
        writeData();
    }
    public void addWorker(boolean userConfirm){
        String name;
        int age = 0;
        float totalHours, totalPayment, wage;

        if(userConfirm){
            viewObject.enterNameMsg();
            name = keyboard.next();
            clearNewLine();
            isEnterPressed();

            age = checkAge();
            clearNewLine();
            isEnterPressed();

            viewObject.enterTotalHoursMsg();
            totalHours = keyboard.nextFloat();
            clearNewLine();
            isEnterPressed();

            viewObject.enterTotalPaymentMsg();
            totalPayment = keyboard.nextFloat();
            clearNewLine();
            isEnterPressed();

            viewObject.enterWageMsg();
            wage = keyboard.nextFloat();
            clearNewLine();
            isEnterPressed();
            
            viewObject.showAddingEmployeeMsg();
            Employee employee = new Employee(name, age, totalHours, totalPayment, wage);
            EmployeeList.add(employee);
            showMenu();
        }else{
            showMenu();
        }
    }
    public char validateMenuOption(){

        String userInput;
        char userInputChar = ' ';

        while(!validInput){
            
            viewException.showEnterOptionMsg();
            userInput = keyboard.nextLine();

            userInputChar = validateUserInput(userInput);

            if((userInputChar < TOTAL_OPTIONS) || (userInputChar == TOTAL_OPTIONS)){
                validInput = true;

            }else{
                if((userInputChar > TOTAL_OPTIONS) || userInputChar < 0){
                    viewException.notAvailableMsg();
                }
            }

        
    }

    return userInputChar;
        }
    public char validateUserInput(String userInput){

        char userInputChar = ' ';
        boolean isNum = false;

        while(!validInput && !isNum){

            if(!userInput.equals("")){
                userInputChar = userInput.charAt(0);

                if(Character.isDigit(userInputChar)){
                    isNum = true;

                }else

                    if(!Character.isDigit(userInputChar)){
                        viewException.optionNumberMsg();

                        userInput = keyboard.nextLine();
                    }
            }else{
                viewException.emptyOptionMsg();

                viewException.showEnterOptionMsg();
                userInput = keyboard.nextLine();
            
            }
        
        }
        return userInputChar;
    }
        /*Shows the inital Menu of the Program*/
    public void showMenu(){
        viewObject.showStartMenu();

        char menuOptionChar = validateMenuOption();
        switch(menuOptionChar){
            case '1': 
                isEnterPressed();
                viewObject.showInputData();
            break;

            case '2':

            break;

            case '3':

            viewObject.showWorkerMenu();
            viewException.showEnterOptionMsg();
            userInput = keyboard.nextLine();
            isEnterPressed();
            switch(userInput){
                case "1":
                    viewObject.showViewWorkers(EmployeeList);
                    break;
                case "2":
                    userConfirm = areYouSure();
                    addWorker(userConfirm);
                    writeData();

                    break;
                case "3":
                    break;
            }
            break;

            case '4':
            break;
        }
    }

    public int checkAge(){
        boolean ageValid = false;

        while(!ageValid){

                viewObject.enterAgeMsg();

                try{
                    age = keyboard.nextInt();
                    ageValid = true;
                }
                catch(java.util.InputMismatchException e){
                    viewException.mustIntMsg();
                }
            }

        return age;
    }

    public void isEnterPressed(){
        boolean enterPressed = false;
        String userInput = " ";
        
        while(!enterPressed){
            viewException.isEnterPressedMsg();
            userInput = keyboard.nextLine();

            if(userInput.equals("")){
                enterPressed = true;
            }
            else{
                viewException.isEnterPressedMsg();
            }
        }
    }
    public boolean areYouSure(){

        while(validInput){
            viewObject.areYouSureMsg();
            viewObject.yesOrNoMsg();
            userInput = keyboard.nextLine();

        if(userInput != null && (userInput.equals("y") || userInput.equals("n"))){
            validInput = false;
        }else{
            viewException.notAvailableMsg();
        }
    }

    if(userInput.equals("y")){
        return true;
    }else{
        return false;
    }
    }
    public void clearNewLine(){
        keyboard.nextLine(); //Clears any /n bc String scanner
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
