package src.View;

public class ExceptionView {
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
    public void mustIntMsg(){
        System.out.println("Inputed number must be a whole number.");
        System.out.println();
        System.out.println("Please Try Again");
        System.out.println();
    }
}
