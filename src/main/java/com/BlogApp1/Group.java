package com.BlogApp1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Group {
    public static void main(String[] args) {
        //whenever do grouping it should be store as a key value pair
        List<Employee> data =  Arrays.asList(
                new Employee(1,"mike",5000),
                new Employee(2,"stallin",7000),
                new Employee(3,"Stallin",5000),
                new Employee(4,"Adam",7000),
                new Employee(5,"Thyson",3000),
                new Employee(6,"mike",9000)
        );
        //Group By salary
        Map<Integer, List<Employee>> newData = data.stream().collect(Collectors.groupingBy( s ->s.getSalary()));
        System.out.println(newData);

        //Group By Name
        Map<String, List<Employee>> name = data.stream().collect(Collectors.groupingBy( n -> n.getName()));
        System.out.println(name);
    }

}
