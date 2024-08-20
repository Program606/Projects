package com.prince.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.prince.excelHandling.ExcelFile;
import com.prince.view.*;
/*
 * Search up a specific member if they are presnt
 */
public class FinanceApplication<T> {
	/**
	 * Features to Implement in Future
	 * RunAndWait
	 * RFID
	 * NueralPepperOS 
	 * 
	 * Remove an existing Member (done)
	 * 		- Shows a list of members who have not attended that particular day
	 * Can edit specific values on existing members (done)
	 * Implement Calendar api 
	 * 	 	- to show each member's contribution per week
	 * 		- Shows area group's collective contribution
	 *  	- Saves data ( member data / fund collected) into a file. 2024-01-07.
	 *  	- Can view past files (immutable).
	 * Implement Excel api
	 * 		- create excel files, using program data for physical copies
	 * Shows Monthly Reports in Percentages
	 * 		- % of active members
	 * 		- % of inactive members
	 * 		- % of existing members contributing
	 * 		- % of bible students this month / which members bore fruit
	 * 		- % of current members attending activities
	 * 		
	 * More Secure Data Collection (maybe php)
	 * Implement program network (Easy transfer of members between individual programs) 
	 */
	final String INPUTLOCATION = "src/res/input.txt";
	final String OUTPUTLOCATION = "src/res/output.txt";
	File file1 = new File(OUTPUTLOCATION);
	File file2 = new File(OUTPUTLOCATION);
	final int MEMBERATTR = 7;
	final int CHOICES = 7;
	
	Scanner keyboard = new Scanner(System.in);
	String tokens[] = new String[MEMBERATTR];
	ArrayList<Member> memberList = new ArrayList<>(); //alphabetical
	BST<Member> alphabeticalMemberBST = new BST<>();
	BST<Member> areaGroupBST = new BST<>(new MemberComparatorAreaGroup());
	

	String firstName, middleName, lastName, areaGroup, 
	CFO, office, nationality, bloodType;
	int age;
	boolean notFinished = true, present = false;

	View v = new View();
	Calendar c = Calendar.getInstance();
	
public void run() throws IOException {
// showCalendar();
loadData();
createAlternateOrderBST();
showMainMenu();
saveData();
ExcelFile.test(memberList);
}

//Main Methods
public void loadData() throws IOException {
	BufferedReader reader = new BufferedReader(new FileReader(file1.getAbsolutePath()));
	String readLine = "";
	
	while((readLine = reader.readLine()) != null) {
		Scanner member = new Scanner(readLine);
		member.useDelimiter(";");
	
			firstName = member.next();
			middleName = member.next();
			lastName = member.next();
			present = member.nextBoolean();
			areaGroup = member.next();
			age = member.nextInt();
			CFO = member.next();
			office = member.next();
			nationality = member.next();
			bloodType = member.next(); //Error if member has no bloodType
		
		createMember(firstName, middleName, lastName, present, areaGroup, age, 
				CFO, office, nationality, bloodType);
		member.close();
	}
	reader.close();
}
public void createAlternateOrderBST(){
	for(Member item :memberList ){
		alphabeticalMemberBST.add(item);
		areaGroupBST.add(item);
	}
}
public void saveData() throws IOException{
	BufferedWriter writer = new BufferedWriter(new FileWriter(file2.getAbsolutePath())); 
	for(Member member: memberList) {
		writer.write(member.getFirstName()+";"+member.getMiddleName()+";"+member.getLastName()+";"+member.getPresent()+";"+member.getAreaGroup()+";"
				+member.getAge()+";"+member.getCFO()+";"+member.getOffice()+";"+member.getNationality()
				+";"+member.getBloodType()+"\n");
	}
	writer.close();
}

//Menu Methods
private void showMainMenu() {
	boolean isNotFound = true;

	while(notFinished) {
	v.showMainMenu();
	int userInput = verifyInput();
	
	switch (userInput) {
	case 0:
		boolean start = inputValidation(); 
		if(start){
			showPresentMenu();
		}
	break;
	case 1:
		start = inputValidation(); 
		if(start){
			v.showAllMembers(memberList);
		}
		showMainMenu();
		break;
	case 2:
		start = inputValidation();
		if(start){
			v.showAddMemberMenu();
			addMemberMenu();
		}
		showMainMenu();
		break;
	
	case 3:
		start = inputValidation(); 
		if(start){
			v.showAllMembers(memberList);
			removeMethodsMenu(1);
			
		}
		showMainMenu();
	break;
	case 4:
		start = inputValidation();
		if(start){
			v.showEditMemberMenu();
			v.showAllMembers(memberList);
			//Add future updates for searching by LastName, CFO, or Duty
			String value = keyboard.nextLine();
		
			for(Member member: memberList){
				if(member.getFirstName().toLowerCase().equals(value.toLowerCase())){
					v.showMember(member);
					editMemberMenu(member);
					isNotFound = false;
			}
		}
			if(isNotFound){
				v.showNoFind();
			}
		}
		
		showMainMenu();
	break;
	case 5:
		showCalendar();
	break;
	case 6:
	notFinished = false;
	System.out.println("Finished Program.. Thank you for using Eden");
	break;
	}
	
	if(notFinished){
		isEnterPressed();
	}
  }
}


private void addMemberMenu() {

	v.showUserInputFirstName();
	firstName = keyboard.nextLine();
	
	v.showUserInputMiddleName();
	middleName = keyboard.nextLine();

	v.showUserInputLastName();
	lastName = keyboard.nextLine();
	
	v.showUserInputAreaGroup();
	areaGroup = keyboard.nextLine();
	
	v.showUserInputAge();
	try {
		age = keyboard.nextInt();
	}  catch (InputMismatchException ime) {
		System.out.println("InputMismatchException");
	}catch(NoSuchElementException nse){
		System.out.println("NoSuchElementException");
	}


	keyboard.nextLine();
	
	v.showUserInputCFO();
	CFO = keyboard.nextLine();
	
	v.showUserInputOffice();
	try {
		office = keyboard.nextLine();
	}  catch (InputMismatchException ime) {
		System.out.println("InputMismatchException");
	}catch(NoSuchElementException nse){
		System.out.println("NoSuchElementException");
	}
	
	v.showUserInputNationality();
	nationality = keyboard.nextLine();
	
	v.showUserInputBloodType();
	bloodType = keyboard.nextLine();
	
	createMember(firstName, middleName, lastName, present = true, areaGroup, age, 
			CFO, office,nationality, bloodType);
			
}
private void removeMethodsMenu(int locator) {
	boolean notFound = true;
	switch(locator) {
	case 1:
		v.viewRemoveMenuName();
		String nameRemoval = keyboard.nextLine();
		for(Member member: memberList) {
			if(nameRemoval.equals(member.getFirstName())) {
				memberList.remove(member);
				v.showDeletingMemberMsg();
				notFound = false;
				break;
			}
		}
		if(notFound){
			v.showNoFind();
		}
		
	}
}
private void editMemberMenu(Member member){
	v.showUserInputFirstName();
	firstName = keyboard.nextLine();
	member.setFirstName(firstName);
	
	v.showUserInputLastName();
	lastName = keyboard.nextLine();
	member.setLastName(lastName);
	
	v.showUserInputAreaGroup();
	areaGroup = keyboard.nextLine();
	member.setAreaGroup(areaGroup);
	
	v.showUserInputAge();
	age = keyboard.nextInt();
	member.setAge(age);
	keyboard.nextLine();
	
	v.showUserInputCFO();
	CFO = keyboard.nextLine();
	member.setCFO(CFO);
	
	v.showUserInputOffice();
	office = keyboard.nextLine();
	member.setOffice(office);
	
	v.showUserInputNationality();
	nationality = keyboard.nextLine();
	member.setNationality(nationality);
	
	v.showUserInputBloodType();
	bloodType = keyboard.nextLine();
	member.setBloodType(bloodType);
}
private void showCalendar() {
	LocalDate currentDate = LocalDate.now();
	int maxDays = currentDate.lengthOfMonth();
	LocalDate lastMonth = currentDate.minusMonths(1);
	int lastMonthMaxDays = lastMonth.lengthOfMonth();

	LocalDate lastDayOfLastMonth = lastMonth.with(TemporalAdjusters.lastDayOfMonth());
	int dayOfLM = lastDayOfLastMonth.getDayOfWeek().getValue();
	
	int lastMonthLastWeekDay = lastDayOfLastMonth.minusDays(dayOfLM).getDayOfMonth();
	
	int count, daysOfLastMonth;

	v.showCalendarHeader();

	for(count=1, daysOfLastMonth = lastMonthLastWeekDay; daysOfLastMonth <= lastMonthMaxDays; count++, daysOfLastMonth++){
		if(count % 7 == 1){
			v.showCalendarStart(daysOfLastMonth);
		}else if (count % 7 > 1 || count == 6){
			v.showCalendarMid(daysOfLastMonth);
		}else{
			v.showCalendarEnd(daysOfLastMonth);
		}
	}

	for(int currDay = 1, buffer = dayOfLM; count-1 <= (maxDays + buffer); count++, currDay++){
		if(count % 7 == 1){
			v.showCalendarStart(currDay);
		}else if (count % 7 > 1 || count == 6){
			v.showCalendarMid(currDay);
		}else if(count % 7 == 0){
			v.showCalendarEnd(currDay);
		}
	}
	//get buffer of last month
	/*
	 * Get Current Day, move next month
	 * change to first day of the next month
	 * keep adding until end of the week
	 */
	
	LocalDate currMonthMaxDays = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
	int currMonthLastDays = currMonthMaxDays.getDayOfWeek().getValue();
	
	LocalDate nextMonth = currentDate.plusMonths(1);
	LocalDate firstDayNextMonth = nextMonth.withDayOfMonth(1);
	int firstDaysNextMonth = firstDayNextMonth.getDayOfWeek().getValue();

	
	// 1 5
	// 2 4
	// 3 3
	// 4 2
	// 5 1
	// 6 1
	v.showCalendarFooter();
}

//Menu Methods 0
private void showPresentMenu(){
	v.showPresentMenu();
	char userInput = keyboard.next().charAt(0);
	keyboard.nextLine();
	switch (userInput) {
		case '1':
			checkMembersAttended();
			break;
		case '2':
			showMembersPresent();
			break;
	}

}
private void checkMembersAttended(){
	v.showSearchMember();
	String nameInput[] = keyboard.nextLine().toLowerCase().trim().split(" ");
	String fname = nameInput[0];
	String mname = "";
	String lname = nameInput[nameInput.length-1];
	
	if(fname != null && nameInput.length > 1){
		for(int i = 1; i<nameInput.length-1;i++){
			mname = mname.concat(nameInput[i]+" ");
		}
	}
	String result = String.format("%s %s%s",fname, mname, lname);

	Iterator<Member> areaGroupBSTIterator = areaGroupBST.iterator();
	while(areaGroupBSTIterator.hasNext()){
		Member currMember = areaGroupBSTIterator.next();
		String currMemberName = String.format("%s %s %s",currMember.getFirstName(), currMember.getMiddleName(), currMember.getLastName()).toLowerCase();
		if(result.equals(currMemberName)){
			currMember.setPresent(true);
			break;
		}
	}
}
private void showMembersPresent(){
	//Show all members who have a value of hasAttended = false;
		// They are ordered by Area Group.
	Iterator<Member> areaGroupBSTIterator = areaGroupBST.iterator();
	v.showPresentMenuMsg();
	while(areaGroupBSTIterator.hasNext()){
		Member currMember = areaGroupBSTIterator.next();
		if(currMember.getPresent()){
			v.showMember(currMember);
		}
	}
}

//Helper Methods
private void createMember(String firstName, String middleName, String lastName, boolean present, String areaGroup, 
		int age, String CFO, String office, String nationality, String bloodType) {
	Member person = new Member(firstName, middleName, lastName, present, areaGroup, age, CFO, office, nationality, bloodType);
	memberList.add(person);
}
private void isEnterPressed() {
	v.pressEnterToContinue();
	String input = keyboard.nextLine();
	while(input == null) {
		v.pressEnterToContinue();
		input = keyboard.nextLine();	
	}
	
	
}
private boolean inputValidation(){
	char charInput;
	
	do{
		v.showValidationMsg();
		String input = keyboard.next();
		charInput = input.charAt(0);
		keyboard.nextLine();
		if(charInput == 'y'){
			return true;
		}else if(charInput == 'n'){
			return false;
		}
	}while(charInput != 'y' || charInput != 'n');
	return false;
}
private boolean isNumeric(String input){
	boolean result = true;
	try{
		Double.parseDouble(input);
	}catch(NumberFormatException e){
		result = false;
	}
	return result;

}

//Verify Methods
private int verifyInput() {
String userInput = "";
boolean result = true;
int intInput = 0;

while(result){
	v.showPromptInputMsg();
	userInput = keyboard.nextLine();

	if(userInput.isBlank()){
		v.showBlankInputMsg();
	}
	else if (!isNumeric(userInput)){
		v.showNotNumeralInputMsg();
	}
	else{
		intInput = Integer.parseInt(userInput);
		if(intInput >= 0 && intInput <= CHOICES){
			result = false;
		}else{
			v.showInputIncorrect(CHOICES-1);
		}
	}
	}

return intInput;
}
}

