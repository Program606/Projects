package view;

import java.util.ArrayList;
import application.Member;

public class View {
	//Main Menu View
	public void showMainMenu() {
		System.out.println("0. Determine Attendance");
		System.out.println("1. Show All Members");
		System.out.println("2. Create a Member");
		System.out.println("3. Remove a Member");
		System.out.println("4. Edit a Member");
		System.out.println("5. Show Monthly Report");
		System.out.println("6. End Program");
		System.out.println();
	}
	
	//Remove Member View
	public void viewRemoveMenuName() {
		System.out.println();
		System.out.print("Provide a Name: ");
	}
	public void showDeletingMemberMsg() {
		System.out.print("Now deleting Provided Member...");
		System.out.println();
		System.out.println();
		
	}
	
	//Calendar View
	public void showCalendarHeader(){
		System.out.printf("| %4S | %4S | %4S | %4S | %4S | %4S | %4S | \n", "----", "----", "----", "----", "----", "----", "----");
        System.out.printf("| %4S | %4S | %4S | %4S | %4S | %4S | %4S | \n", "Sun", "Mom", "Tue", "Wed", "Th", "Fri", "Sat");
		System.out.printf("| %4S | %4S | %4S | %4S | %4S | %4S | %4S | \n", "----", "----", "----", "----", "----", "----", "----");
	}
	public void showCalendarStart(int currDay){
		System.out.printf("| %4d |", currDay);
	}
	public void showCalendarMid(int currDay){
		System.out.printf(" %4d |", currDay);
	}
	public void showCalendarEnd(int currDay){
		System.out.printf(" %4d | \n", currDay);
	}
	public void showCalendarFooter() {
		System.out.println();
		System.out.printf("| %4S | %4S | %4S | %4S | %4S | %4S | %4S | \n", "----", "----", "----", "----", "----", "----", "----");
	}
	
	//Find Member View
	public void showEditMemberMenu() {
		System.out.println();
		System.out.print("Pick a member to edit");
		
	}
	public void showNoFind(){
		System.out.println("The member cannot be found");
	}
	public void showMember(Member member){
		System.out.println(member);
		System.out.println();
	}

	//Add Member View
	public void showAddMemberMenu() {
		System.out.println();
		System.out.print("Please provide information to create a member: ");
		System.out.println();
	}
	public void showUserInputFirstName(){
		System.out.print("Please Provide a First Name: ");
	}
	public void showUserInputMiddleName() {
        System.out.print("Please Provide a Middle Name (if none type \' \"\" \'): ");
    }
	public void showUserInputLastName(){
		System.out.print("Please Provide a Last Name: ");
	}
	public void showUserInputAreaGroup(){
		System.out.print("Please Provide an Area Group: ");
	}
	public void showUserInputAge(){
		System.out.print("Please Provide an Age: ");
	}
	public void showUserInputCFO(){
		System.out.print("Please Provide a CFO: ");
	}
	public void showUserInputOffice(){
		System.out.print("Please Provide an Office: ");
	}
	public void showUserInputNationality(){
		System.out.print("Please Provide a Nationality: ");
	}
	public void showUserInputBloodType(){
		System.out.print("Please Provide a BloodType: ");
	}
    
	//Helper View
	public void showValidationMsg() {
		System.out.println();
		System.out.print("Please enter (y/n): ");
		
    }
	public void showAllMembers(ArrayList<Member> membersList) {
		for(Member person: membersList) {
			System.out.println(person);
		}
		System.out.println();
		System.out.println();
	}
	public void pressEnterToContinue() {
		System.out.println();
		System.out.print("Press Enter to continue");
	}

	//Present Member View
	public void showIsPresent(Member member) {
		System.out.printf("Is %8s %8s %S present?", member.getFirstName(), member.getLastName(), member.getAreaGroup());
		System.out.println("Is this member Present? (y/n)");
	}
	public void showPresentMenu() {
		System.out.println("1. Determine Members Attended");
		System.out.println("2. Show Members Attended");
	}
	public void showPresentMenuMsg() {
		System.out.println("Here are all Present Members: ");
	}

	public void showSearchMember(){
		System.out.println();
		System.out.print("Provide a name to Determine Attendance:");
	}

	//Validation Msgs
	public void showBlankInputMsg(){
		System.out.print("Input is blank");
		System.out.println();
		System.out.println();
	}
	public void showNotNumeralInputMsg(){
		System.out.print("Input must be numeral");
		System.out.println();
		System.out.println();
	}
	public void showPromptInputMsg(){
		System.out.print("Sumbit a Response: ");
	}
	public void showInputIncorrect(int choices){
		System.out.print("Response must be between 0-"+choices);
		System.out.println();
		System.out.println();
	}

    
}
