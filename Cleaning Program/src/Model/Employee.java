package src.Model;

import java.text.DecimalFormat;

public class Employee {

    private String name;
    private int age;
    private float totalHours, totalSalary, wage;

    /*Initilizing a constructor so each employee has these attr */
    public Employee(String name, int age, float totalHours, float totalSalary, float wage){
        this.name = name; 
        this.age = age;
        this.totalHours = totalHours;
        this.totalSalary = totalSalary;
        this.wage = wage;
    }
    

    public String toString(){
        //Formating Numbers with Commas in between
        DecimalFormat formatterTotalSalary = new DecimalFormat("#, ###.00");
        String formatedTotalSalary = formatterTotalSalary.format(totalSalary);
        
        DecimalFormat formattertotalHours = new DecimalFormat("#, ###.0");
        String formatedTotalHours = formattertotalHours.format(totalHours);

        String toString = name + " " + age + " " + formatedTotalHours + " " + "$"+ formatedTotalSalary + " " + "$"+ wage  ;
        return toString;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public float getTotalHours() {
        return totalHours;
    }
    public void setTotalHours(float totalHours) {
        this.totalHours = totalHours;
    }
    public float getTotalSalary() {
        return totalSalary;
    }
    public void setTotalSalary(float totalSalary) {
        this.totalSalary = totalSalary;
    }
    public float getWage() {
        return wage;
    }
    public void setWage(float wage) {
        this.wage = wage;
    }

    
}
    
