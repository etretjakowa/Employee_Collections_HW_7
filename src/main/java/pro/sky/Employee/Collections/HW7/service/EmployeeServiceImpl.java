package pro.sky.Employee.Collections.HW7.service;

import org.springframework.stereotype.Service;
import pro.sky.Employee.Collections.HW7.Employee;
import pro.sky.Employee.Collections.HW7.EmployeeAlreadyAddedException;
import pro.sky.Employee.Collections.HW7.EmployeeNotFoundException;
import pro.sky.Employee.Collections.HW7.EmployeeStorageIsFullException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service


public class EmployeeServiceImpl implements EmployeeService {


    private final int STORAGE_SIZE = 10;

    public Map <String , Employee>  employees;

    {
        employees = new HashMap<>(Map.of(
                "Иван Иванов",new Employee("Иван", "Иванов"),
                "Пётр Петров",new Employee("Пётр", "Петров"),
                "Сергей Новиков", new Employee("Сергей", "Новиков"),
                "Татьяна Тихонова", new Employee("Татьяна", "Тихонова"),
                "Наталья Семёнова", new Employee("Наталья", "Семёнова"),
                "Николай Шевцов", new Employee("Николай", "Шевцов"),
                "Анна Зайцева", new Employee("Анна", "Зайцева")
        ));
    }
    @Override


    public Employee add(String name, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {

        Employee employee = new Employee(name, lastName);

        if (employees.size() >= STORAGE_SIZE) {


            throw new EmployeeStorageIsFullException("Список заполнен!");

        }


        if (employees.containsKey(employee.getFullName()))  {

            throw new EmployeeAlreadyAddedException("Сотрудник уже есть в списке");

        }

        employees.put(employee.getFullName(), employee );

        return employee;

    }

    @Override


    public Employee remove(String name, String lastName) throws EmployeeNotFoundException {

        Employee employee = new Employee(name, lastName);

        if (employees.containsKey(employee.getFullName())) {

            return employees.remove(employee.getFullName());



        }

        throw new EmployeeNotFoundException("Такого  сотрудника нет в списке");

    }


    @Override

    public Employee find(String name, String lastName) throws EmployeeNotFoundException {

        Employee employee = new Employee(name, lastName);

        if (employees.containsKey (employee.getFullName())) {

            return employees.get(employee.getFullName());

        }

        throw new EmployeeNotFoundException("Такого  сотрудника нет в списке");

    }

    @Override

    public Collection<Employee> getAll() {

        return Collections.unmodifiableCollection(employees.values());
    }

    private String getFullName (String name, String lastName) {return  name + lastName;}
    private void checkExistence (String fullName) {
        if (! employees.containsKey (fullName)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет");
        }
    }


}