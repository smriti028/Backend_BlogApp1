package com.BlogApp1;

import org.w3c.dom.ls.LSInput;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Streamss {
    public static void main(String[] args) {

        //PREDICATE - It takes input and produces boolean value

        List<String> data  = Arrays.asList("Adam","Smith","Mike","Lucy","Sam");
        List<String> newData = data.stream().filter(str -> str.startsWith("S")).collect(Collectors.toList());
        System.out.println(newData);

        //Find out how many times word Adam has occurred

        List<String> data1 = Arrays.asList("Adam","adam","Smith","Ameen","Mike");
        List<String> newData1 = data1.stream().filter(str -> str.equalsIgnoreCase("adam")).collect(Collectors.toList());
        System.out.println("Total adam present in this list is :"+newData1);

        //Find the Number of occurrence of Adam

        List<String> data2 = Arrays.asList("Adam","adam","smith","sam");
        List<String> newdata2 = data2.stream().filter(str -> str.equalsIgnoreCase("Adam")).collect(Collectors.toList());
        System.out.println("The number of occurrence of Adam is :" +newdata2.size());

        //return unique elements
        List<String> data3 = Arrays.asList("Adam","Adam","Smith","sam","Smith","Lucy","lucy");
        List<String> newdata3 = data3.stream().distinct().collect(Collectors.toList());
        System.out.println(newdata3);

        //return unique numbers
        List<Integer> data4 = Arrays.asList(10,20,30,30,50,89,89,76,40,30,20);
        List<Integer> newData4 = data4.stream().distinct().collect(Collectors.toList());
        System.out.println(newData4);

        //FUNCTION FUNCTIONAL INTERFACE  - USE TO MANIPULATION OF DATA (it takes an input and produces an output)

        //Sum of two numbers
        Function<Integer,Integer> val = n -> n+10;
        Integer newVal = val.apply(10);
        System.out.println("The sum of two number is :"+newVal);

        //Subtract the two numbers
        Function<Integer,Integer> values = n -> n-10;
        Integer newValues = values.apply(59);
        System.out.println(newValues);

        //multiply
        Function<Integer,Integer> res = n -> n*n;
        Integer result = res.apply(29);
        System.out.println(result);

        //concatenate
        Function<Integer,String> c = n ->"The output is "+n;
        String newC = c.apply(10);
        System.out.println(newC);

        //Find the square of every number given
        List<Integer> square = Arrays.asList(10,20,30,40,50);
        List<Integer> newSquare = square.stream().map( sq -> sq * sq).collect(Collectors.toList());
        System.out.println(newSquare);

        //Convert every name in collection into UPPERCASE

        List<String> upperCase = Arrays.asList("adam","smith","rio","bonnie");
        List<String> newUpperCase = upperCase.stream().map(uc -> uc.toUpperCase()).collect(Collectors.toList());;
        System.out.println(newUpperCase);

        //Consumer - it takes input but produces no output
        Consumer<Integer> cn = n -> System.out.println(n);
        cn.accept(10);

        Consumer<String> con = n -> System.out.println(n);
        con.accept("Mike");

        //SUPPLIER - it does not tak any input but produces output

        Supplier<Double> sup = () -> Math.random();
        Double newSup = sup.get();
        System.out.println(newSup);


    }
}
