package taskthree;
import java.util.Scanner;

interface Taxable {
 double salesTax = 0.07; 
 double incomeTax = 0.105;

 
 void calcTax();
}


class Employee implements Taxable {

 private int empId;
 private String name;
 private double salary;

 
 public Employee(int empId, String name, double salary) {
     this.empId = empId;
     this.name = name;
     this.salary = salary;
 }

 
@Override
 public void calcTax() {
     double incomeTaxAmount = salary * incomeTax;
     System.out.println("Income Tax for Employee " + empId + ": $" + incomeTaxAmount);
 }
}


class Product implements Taxable {
 
 private int pid;
 private double price;
 private int quantity;

 
 public Product(int pid, double price, int quantity) {
     this.pid = pid;
     this.price = price;
     this.quantity = quantity;
 }

 
 @Override
 public void calcTax() {
     double salesTaxAmount = price * salesTax * quantity;
     System.out.println("Sales Tax for Product " + pid + ": $" + salesTaxAmount);
 }
}


public class XYZ {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     
     System.out.println("Enter Employee information:");
     System.out.print("Employee ID: ");
     int empId = scanner.nextInt();
     scanner.nextLine();  
     System.out.print("Employee Name: ");
     String empName = scanner.nextLine();
     System.out.print("Employee Salary: $");
     double empSalary = scanner.nextDouble();


     Employee employee = new Employee(empId, empName, empSalary);
     employee.calcTax();

     
     System.out.println("\nEnter Product information:");
     System.out.print("Product ID: ");
     int productId = scanner.nextInt();
     System.out.print("Unit Price: $");
     double unitPrice = scanner.nextDouble();
     System.out.print("Quantity: ");
     int productQuantity = scanner.nextInt();

     
     Product product = new Product(productId, unitPrice, productQuantity);
     product.calcTax();

     
 }
}

