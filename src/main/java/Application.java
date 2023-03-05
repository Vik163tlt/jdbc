import java.sql.*;
import java.util.List;


public class Application {

    public static void main(String[] args) throws SQLException {

        final Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/skypro", "postgres", "********");

        try (connection) {

            PreparedStatement getEmployeeById = connection.prepareStatement(
                    "SELECT * FROM employee FULL OUTER JOIN city " +
                            "ON employee.city_id = city.city_id WHERE id = (?)");
            getEmployeeById.setInt(1, 1);
            final ResultSet resultSet = getEmployeeById.executeQuery();
            while (resultSet.next()) {

                String firstName = "Имя: " + resultSet.getString("first_name");
                String lastName = "Фамилия: " + resultSet.getString("last_name");
                String gender = "Пол: " + resultSet.getString("gender");
                String age = "Возраст: " + resultSet.getInt("age");
                String city = "Город: " + resultSet.getString("city_name");

                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(gender);
                System.out.println(age);
                System.out.println(city);

                EmployeeDAO employeeDAO = new EmployeeDAOImpl();

                List<Employee> list = employeeDAO.readAll();

                for (Employee employee : list) {
                    System.out.println(employee);
                }
            }
        }
    }
}
