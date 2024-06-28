package src.View;

import java.util.ArrayList;

import src.Model.Employee;

public class Visual {

    public void showStartMenu(){

        String menuOptions[] = {"1.Input Data", "2.Payment", "3.View Workers", "4.Add/Remove Buildings",};

        System.out.println("+-------------------------------------------------+");
        System.out.printf("|%-49s|" + "\n", " ");

        for(String option: menuOptions){
            System.out.printf("|"+" %-48s|"+ "\n", option);
        }
        System.out.printf("|%-49s|" + "\n", " ");
        System.out.println("+-------------------------------------------------+");
        System.out.println();
    }
    
    public void showWorkerMenu(){
        String[] menuOptions = {"1.View Workers", "2.Add Worker", "3.Remove Worker"};
        
        System.out.println("+-------------------------------------------------+");
        System.out.printf("| %-48s| %n" , "");

        for(String option: menuOptions){
            System.out.printf("| %-48s| %n" , option);
        }
        System.out.printf("| %-48s| %n" , "");
        System.out.println("+-------------------------------------------------+");
    }
    public void showAddWorkerMsg(){
        System.out.println("To Add a Worker Please Enter the Following Inputs..");
    }
    public void showRemoveWorkerMsg(){
        System.out.println();
        System.out.println("To Remove a Worker Please Enter the Number that Corresponds with the Worker..");
        System.out.println();
    }
    public void enterNameMsg(){
        System.out.println();
       System.out.print("Please Enter a Name:" ); 
    }
    public void enterAgeMsg(){
        System.out.print("Please Enter an Age: ");
    }
    public void enterMonthHoursMsg(){
    }
    public void enterMonthPaymentMsg(){
        
    }
    public void enterTotalHoursMsg(){
        System.out.print("Please Enter Total Hours Worked: ");
    }
    public void enterTotalPaymentMsg(){
        System.out.print("Please Enter Previous Hours Worked: ");
    }
    public void enterWageMsg(){
        System.out.print("Please Enter Wage per Hour: ");
    }
    
    public void showViewWorkers(ArrayList<Employee> employeeList){
        int count = 1;
        String title1 = "Workers", 
               title2 = "Month Hours", 
               title3 = "Month Payment", 
               title4 = "Total Hours", 
               title5 = "Total Payment",
               title6 = "Wage";

        System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-5s | %n", title1, title2, title3, title4, title5, title6);
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");

        for(Employee employee: employeeList){
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-4s | %n", 
            count + ") "+ employee.getName(), "Monthly Hours $", "Monthly Payment", employee.getTotalHours(), employee.getTotalHours()
            ,employee.getWage());
            count++;
        
            System.out.println("+-------------------------------------------------------------------------------------------------------------------------+");
        }
    }

    public void showInputData(){
        String inputDataOption = "Day";
        String inputDataOption2 = "Month";
        System.out.println("+-------------------------------------------------+");
        System.out.printf("|%-49s|" + "\n", " ");
        System.out.printf("|"+" 1.%-46s|"+"\n", inputDataOption);
        System.out.printf("|"+" 1.%-46s|"+"\n", inputDataOption2);
        System.out.printf("|%-49s|" + "\n", " ");
        System.out.println("+-------------------------------------------------+");
        System.out.println();
    }
    public void areYouSureMsg(){
        System.out.println("Are you sure you want to continue?");
    }
    public void yesOrNoMsg(){
            System.out.print("Please enter (y/n): ");
    }

    public void showAddingEmployeeMsg() {
        System.out.println("Now Adding Worker.. Please Wait... "+ "\n");
    }
}