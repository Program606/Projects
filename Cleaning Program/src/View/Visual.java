package src.View;

import java.lang.reflect.Array;
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
    public void showAddWorker(){

        System.out.println("To Add a Worker Please Enter the Following Inputs..");
    }
    public void enterNameMsg(){
       System.out.print("Please Enter a Name:" +"\n"); 
    }
    public void enterMonthHoursMsg(){
    }
    public void enterMonthPaymentMsg(){
        
    }
    public void enterTotalHoursMsg(){
    
    }
    public void enterTotalPaymentMsg(){
    
    }
    public void enterWageMsg(){}
    public void showRemoveWorker(){

    }
    
    public void showViewWorkers(ArrayList<Employee> employeeList){
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
            employee.getName(), "Monthly Hours $", "Monthly Payment", employee.getTotalHours(), employee.getTotalHours()
            ,employee.getWage());
        
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
            System.out.print("Please enter (y/n): " + "\n");
    }

    public void isEnterPressedMsg(){
        System.out.println();
        System.out.println("Press Enter to Continue...");
        System.out.println();
    }
    public void showEnterOptionMsg(){
        System.out.println("Please Enter an Option: ");
    }
    public void emptyOptionMsg(){
        System.out.println("The option must contain a character.");
    }
    public void optionContainsNoNumMsg(){
        System.out.println("The option must be a number..");
    }
    public void notAvailableMsg() {
        System.out.println("Option is not available in Menu...");
    }
    public void optionNumberMsg(){
        System.out.println("Input must be a numeral..");
        System.out.println();
        System.out.println("Please enter a numeral");
    }
}