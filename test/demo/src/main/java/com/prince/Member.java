package com.prince;

public class Member implements Comparable<Member>{
	String firstName = "";
	String middleName = "";
	String lastName = "";
	String areaGroup= "";
	String CFO = ""; //Binhi/Kadiwa/Buklod
	String office = ""; //Finance/Secretary/SCAN/CWS/Leadership
	String nationality = "";
	String bloodType = "";
	int age = 0;
	boolean present = false;
	
	
	/**
	 * Implement in the future**
	 * 
	 * String address = "";
	 * int dateLastAttended = 0;
	 * boolean active = true;
	 * 
	 */
	
	Member(String firstName, String middleName, String lastName, boolean present, String areaGroup, int age, String CFO, String office, 
			String nationality, String bloodType){
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.areaGroup = areaGroup;
		this.CFO = CFO;
		this.age = age;
		this.office = office;
		this.nationality = nationality;
		this.bloodType = bloodType;
		this.present = present;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCFO() {
		return CFO;
	}


	public void setCFO(String cFO) {
		CFO = cFO;
	}


	public String getOffice() {
		return office;
	}


	public void setOffice(String office) {
		this.office = office;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public String getBloodType() {
		return bloodType;
	}


	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	public String toString(){
		return String.format("FirstName: %8s, MiddleName: %8s, LastName: %8s, isPresent: %b, AreaGroup: %2s, Age: %d, CFO: %S, Office: %8s, Nationality: %s, bloodType: %s",
		firstName, middleName, lastName, present, areaGroup, age, CFO, office, nationality, bloodType);
	}


	public String getAreaGroup() {
		return areaGroup;
	}

	public void setAreaGroup(String areaGroup) {
		this.areaGroup = areaGroup;
	}
	
	public boolean getPresent(){
		return present;
	}
	public void setPresent(boolean present){
		this.present = present;
	}


	@Override
	public int compareTo(Member o) {
		int result = this.getLastName().compareTo(o.getLastName());
		if(result == 0){
		result = this.getFirstName().compareTo(o.getFirstName());
		}
		return result;
	}
	
}
