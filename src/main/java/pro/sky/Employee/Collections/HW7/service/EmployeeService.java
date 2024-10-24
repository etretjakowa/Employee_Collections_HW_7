package pro.sky.Employee.Collections.HW7.service;

import pro.sky.Employee.Collections.HW7.Employee;
import pro.sky.Employee.Collections.HW7.EmployeeAlreadyAddedException;
import pro.sky.Employee.Collections.HW7.EmployeeNotFoundException;
import pro.sky.Employee.Collections.HW7.EmployeeStorageIsFullException;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String name, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;

    Employee remove(String name, String lastName) throws EmployeeNotFoundException;

    Employee find(String name, String lastName) throws EmployeeNotFoundException;

    Collection<Employee> getAll();
}