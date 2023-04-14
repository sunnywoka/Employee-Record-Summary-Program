//Yuekai Wu 13113181

package nz.ac.massey.a1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {


    private static Employee[] employee = new Employee[100];//creat class array

    private static void displayInfo(){//the information of student who contributed to the solution
        System.out.println("--------------------------------------");
        System.out.println("    Assignment 1 Semester 1 2020      ");
        System.out.println("  Submitted by: Yuekai, Wu 13113181   ");
        System.out.println("--------------------------------------");
    }

    public static void main(String[] args) {
	// write your code here
        displayInfo();//call information function
        int i=0;
        Scanner scanner;
        //read each line from test file and store in the Employee class
        try{
            scanner = new Scanner(new BufferedReader(new FileReader("a1.txt")));
            String item;
            try{
                while(scanner.hasNextLine()){
                    item = scanner.nextLine();
                    String[] parts = item.split(" ");
                    employee[i] = new Employee(parts[0], parts[1], Integer.parseInt(parts[2]), Float.parseFloat(parts[3]));
                    i++;
                }
            }finally {
                scanner.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        //start to display summary
        System.out.printf("Number of employee: %d\n", i);//print number of employee
        //calculate the average of salary
        double total = 0;
        for(int a=0; a<i; a++){
            total = total + employee[a].getSalary();
        }
        double average = total/i;
        System.out.printf("Average salary: %.1f\n", average);//print average salary
        //find out the lowest salary
        double lowSalary = employee[0].getSalary();
        for(int a=1; a<i; a++){
            if(lowSalary > employee[a].getSalary()){
                lowSalary = employee[a].getSalary();
            }
        }
        System.out.printf("The lowest salary: %.1f\n", lowSalary);//print lowest salary
        //find out the highest salary
        double highSalary = employee[0].getSalary();
        for(int a=1; a<i; a++){
            if(highSalary < employee[a].getSalary()){
                highSalary = employee[a].getSalary();
            }
        }
        System.out.printf("The highest salary: %.1f\n", highSalary);//print highest salary

        System.out.println();
        //repeat to ask user for salary range
        do {
            System.out.println("Do you want to find employees whose salaries are between the specified range?");
            //tell user only type 'n' or 'y'
            System.out.println("Type 'n' to quit, or type 'y' to continue: ");
            Scanner input = new Scanner(System.in);
            String enter = input.nextLine();
            //once user enter 'n', the program will stop
            if (enter.equals("n")) {
                System.out.println("Program quit.");
                System.exit(0);
            }
            //user enter'y' for find out whose salary in the range
            if (enter.equals("y")) {
                Scanner low = new Scanner(System.in);
                Scanner up = new Scanner(System.in);
                System.out.println("Enter lower boundary for salary: ");
                double enterLow = low.nextDouble();//set the lower boundary
                System.out.println("Enter upper boundary for salary: ");
                double enterUp = up.nextDouble();//ser the upper boundary
                int temp = 0;//count the number of matching records
                System.out.println("Employee: ");
                for(int a=0; a<i; a++){//print out the employees who match in range
                    if(employee[a].testRange(enterLow, enterUp)){
                        System.out.println(employee[a].toString());
                        temp++;
                    }
                }
                if(temp==0){ System.out.println("No employee is in this range"); }//if count is zero, there is no one in the certain range
                System.out.printf("Total matching employees in specified salary range: %d\n", temp);
                System.out.println();
                System.out.println();
            }
        }while(true);//loop the program until user enter 'n'
    }
}
