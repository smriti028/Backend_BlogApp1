package com.BlogApp1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    private int id;
    private  String name;
    private int salary;
    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        //METHOD REFERENCE WE CAN REPLACE THE LAMBDA EXPRESSION WITH METHOD REFERENCE
        //Method reference is an alternative way of calling a method that is basically present in our program.
        Employee e;
    List<Employee> data  =  Arrays.asList(
                            new Employee(1,"Mike",2500),
                            new Employee(2,"Stallin",6000),
                            new Employee(3,"Smith",6000));

         //USING METHOD REFERENCE HERE INSTEAD LAMBDA EXPRESSION
        List<String> s = data.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(s);

        List<Employee> newData = data.stream().filter( n -> n.getSalary()>5000).collect(Collectors.toList());

        // Reduce salary of every employee 500
        List<Integer> newData1 = data.stream().map(n ->n.getSalary()-500).collect(Collectors.toList());
            System.out.println(newData1);

        //convert all name into uppercase
        List<String> newData2 = data.stream().map( u -> u.getName().toUpperCase()).collect(Collectors.toList());
        System.out.println(newData2);


    for (Employee emp: newData){
        System.out.println(emp.getId());
        System.out.println(emp.getName());
        System.out.println(emp.getSalary());
    }

    }

}
//Give those employees names and id whose salary is above> than 5K