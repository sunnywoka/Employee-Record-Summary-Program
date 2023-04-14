//Yuekai Wu 13113181

package nz.ac.massey.a1;



public class Employee {
    //private data members
    private String surname, firstname;
    private int id;
    private double salary;

    //constructor
    public Employee(String surname, String firstname, int id, double salary) {
        this.surname = surname;
        this.firstname = firstname;
        this.id = id;
        this.salary = salary;
    }
    //toString method return employee detail in format
    public String toString() {
        return String.format("Employee -  Name: %-7s %-10sID: %-5d Salary: %.1f", firstname, surname, id, salary);
    }
   //provide boolean value to main
    public boolean testRange(double lowRange, double upRange){
        return (salary > lowRange) && (salary < upRange);
    }

    //public String getSurname(){ return surname; }

    //public String getFirstname() { return firstname; }

    //public int getId() { return id; }

    //assess salary data
    public double getSalary() { return salary; }
}
