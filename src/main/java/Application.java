import java.sql.*;
import java.util.List;


public class Application {

    public static void main(String[] args) throws SQLException {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

//        Employee alexey = new Employee("Alexey", "Tolstov", "male", 21, 5);
//        employeeDAO.add(alexey);

        System.out.println(employeeDAO.getById(1));

        Employee irina = new Employee(1, "Irina", "Drozd", "female", 37, 1);
        employeeDAO.updateEmployee(irina);

        List<Employee> list = employeeDAO.readAll();

        for (Employee employee : list) {
            System.out.println(employee);
        }
//        employeeDAO.deleteEmployee(alexey);

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}

