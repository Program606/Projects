package src.View;

public class Visual {

    public void showStartMenu(){


        String menuOption1 = "Input Data";
        String menuOption2 = "Payment";
        String menuOption3 = "View Workers";
        String menuOption4 = "Add/Remove Buildings";

        System.out.println("+-------------------------------------------------+");
        System.out.printf("|%-49s|" + "\n", " ");
        System.out.printf("|"+" 1.%-46s|"+ "\n", menuOption1);
        System.out.printf("|"+" 2.%-46s|" + "\n", menuOption2);
        System.out.printf("|"+" 3.%-46s|" + "\n", menuOption3);
        System.out.printf("|"+" 4.%-46s|" + "\n", menuOption4);
        System.out.printf("|%-49s|" + "\n", " ");
        System.out.println("+-------------------------------------------------+");
        System.out.println();
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
    
    public void isEnterPressedMsg(){
        System.out.println();
        System.out.println("Press Enter to Continue...");
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
        System.out.println("Please enter an option that is found in the Menu...");
    }
}
