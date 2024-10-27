package pro.sky.Employee.Collections.HW7.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.Employee.Collections.HW7.Employee;
import pro.sky.Employee.Collections.HW7.service.EmployeeService;

import java.util.Collection;


@RestController


@RequestMapping("/employees")




public class EmployeeController {


    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity< String> handleException (Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<String>(e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
        System.out.println(responseEntity);


        return responseEntity;
    }


    private  final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")

    public Employee addEmployee(

            @RequestParam("name") String name,

            @RequestParam ("lastName") String lastName

    ) {

        return   employeeService.add(name,lastName);

    }

    @GetMapping("/remove")

    public Employee removeEmployee(

            @RequestParam ("name") String name,

            @RequestParam ("lastName") String lastName

    ) {

        return employeeService.remove(name, lastName);

    }

    @GetMapping("/find")

    public Employee findEmployee(

            @RequestParam ("name") String name,

            @RequestParam ("lastName") String lastName

    ) {

        return employeeService.find(name, lastName);

    }

    @GetMapping("/allEmployees")

    public Collection <Employee>  getAllEmployees() {


        return employeeService.getAll();


    }
}