import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeesGreaterThan30 = employees.stream()
                .filter(employee -> employee.getAge() > 30)
                .collect(Collectors.toList());
        System.out.printf("Employees greater than 30 " + employeesGreaterThan30);


        Optional<Employee> highestSalaryEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getSalary));
        System.out.println("Highest salary employee " + highestSalaryEmployee);

        List<Employee> sortBySurname = employees.stream()
                .sorted(Comparator.comparing(Employee::getSurname))
                .collect(Collectors.toList());
        System.out.println("SortBySurname " + sortBySurname);

        long whoOld25 = employees.stream()
                .filter(employee -> employee.getAge() > 25)
                .count();
        boolean allgreaterThanOrNot = whoOld25 == employees.size();
        System.out.println("All employee greater than 25 " + allgreaterThanOrNot);

        List<String> itEmployeeNames = employees.stream()
                .filter(employee -> employee.getDepartment() == Department.IT)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("It department's employees " + itEmployeeNames);

        Map<Department, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Employee by dempartment " + employeesByDepartment);

        Map<Department, Long> employeeCountByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Count of each department " + employeeCountByDepartment);

        Map<Department, Double> averageAgeByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getAge)));
        System.out.println("average age in each department " + averageAgeByDepartment);

        Map<Boolean, List<Employee>> partitionByEmployer = employees.stream()
                .collect(Collectors.partitioningBy(Employee::isEmployer));
        System.out.println("Partitioning employer " + partitionByEmployer);

        double sumOfSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total salary " + sumOfSalary);

        Optional<Employee> employeeLowestSalary = employees.stream()
                .min(Comparator.comparing(Employee::getSalary));
        System.out.println("Minimum salary employee " + employeeLowestSalary);
//14

        Map<Double, List<String>> nameRespectToSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("Name respert with salary " + nameRespectToSalary);

        List<String> notEmployee = employees.stream()
                .filter(e -> !e.isEmployer())
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("Name of non-employers " + notEmployee);

        List<String> nameAndSurname = employees.stream()
                .map(employee -> employee.getName() + " " + employee.getSurname())
                .collect(Collectors.toList());
        System.out.println("Name and Surname " + nameAndSurname);
//18
        double totalSalaryIT = employees.stream()
                .filter(employee -> employee.getDepartment() == Department.IT)
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("IT department's total salary " + totalSalaryIT);

        Map<Department, Double> totalSalaryEachDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
        System.out.println("Each department salary " + totalSalaryEachDepartment);
//21
//      double averageSalary = employees.stream()
//                .mapToDouble(Employee::getSalary)
//                .average();
//
//        List<Employee> salaryGreaterThanAverageSalary =employees.stream()
//                .filter(employee -> employee.getSalary() > averageSalary)
//                .collect(Collectors.toList());

        Map<Integer, Employee> employeeMap = employees.stream()
                .collect(Collectors.toMap(Employee::getId, employee -> employee));
        System.out.println("Map of employee with id");

        List<String> decreaseSalary = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()).map(Employee::getName).toList();
        System.out.println("get salary decrease order " + decreaseSalary);
//24

//25
        //26

        int totalYearsOfExperience = employees.stream()
                .mapToInt(e -> Period.between(e.getStartDate(), LocalDate.now()).getYears())
                .sum();

        System.out.println("Total years of experience  all employees: " + totalYearsOfExperience);

        Optional<Employee> longestServingEmployee = employees.stream()
                .min(Comparator.comparing(Employee::getStartDate));
        System.out.println("The old in the work " +longestServingEmployee);
        //29
        Map<Position, Long> employeeCountByPosition = employees.stream()
                .collect(Collectors.groupingBy(Employee::getPosition, Collectors.counting()));
        System.out.println("Employee by pozition " + employeeCountByPosition);

    }
}
