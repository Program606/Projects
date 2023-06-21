package src.Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import src.Model.Employee;

public class Cleaning_Manager {

    final String FILE_INFO = "res/worker_info.txt";
    
    public String tokens[];
    public String name;
    public int age;
    public float totalHours, totalSalary, wage;
    public ArrayList<Employee> EmployeeList;


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
            for(Employee employee: EmployeeList){
                System.out.println(employee);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return EmployeeList;
    }

    public void startProgram() throws IOException{
        loadData();


        writeData();
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
