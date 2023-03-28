import java.sql.*;
import java.util.List;


public class Application {

    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//
        System.out.println(employeeDAO.getById(1));
//
        Employee employee1 = new Employee(10, "Evgeniy", "Popov", "male", 32, 8);
//        employeeDAO.updateEmployee(employee1);
//        System.out.println(employeeDAO.getById(1));
//        List<Employee> employeeList = employeeDAO.readAll();
//        for (Employee employee : employeeList) {
//            System.out.println(employee);
//        }
//        employeeDAO.deleteEmployee(employee1);

        CityDao cityDao = new CityDAOImpl();

        List<Employee> employeesFromIjevsk = List.of(employee1);
        City ijevsk = new City("Ижевск", employeesFromIjevsk);

//        City ufa = new City("Уфа");
//        cityDao.add(ufa);

        City ufa = new City("Уфа");
        cityDao.add(ufa);


        List<City> cityList = cityDao.readAll();

        for (City city : cityList) {
            System.out.println(city);
        }
        cityDao.getById(1);

        City penza = new City(ufa.getCity_id(),"Пенза");

        cityDao.updateCity(ufa);

        for (City city : cityList) {
            System.out.println(city);
        }

        cityDao.deleteCity(ufa);
        for (City city: cityList) {
          System.out.println(city);}
    }
}

