import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import employee.entities.Employee;

public class ExEmployee {
  public static void main() {
    Scanner sc = new Scanner(System.in);
    List<Employee> employees = new ArrayList<>();

    String path = "../employee.csv";

    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      String line = reader.readLine();
      while (line != null) {
        String[] fields = line.split(",");
        String name = fields[0];
        String email = fields[1];
        Double salary = Double.parseDouble(fields[2]);
        Employee employee = new Employee(name, email, salary);
        employees.add(employee);

        line = reader.readLine();
      }

      System.out.print("Enter salary: ");
      double salary = sc.nextDouble();
      System.out.println("Email of people whose salary is more than: " + String.format("%.2f", salary));
      List<String> emailsMoreSalary = employees
        .stream()
        .filter(employee -> employee.getSalary() > salary)
        .map(employee -> employee.getEmail())
        .sorted((e1, e2) -> e1.toLowerCase().compareTo(e2.toLowerCase()))
        .toList();
      emailsMoreSalary.forEach(System.out::println);

      double sumSalary = employees
        .stream()
        .filter(employee -> employee.getName().toUpperCase().charAt(0) == 'M')
        .map(employee -> employee.getSalary())
        .reduce(0.0, (v1, v2) -> v1 + v2);

      System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sumSalary));
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    sc.close();
  }
}
