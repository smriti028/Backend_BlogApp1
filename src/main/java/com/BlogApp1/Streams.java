package com.BlogApp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(10,20,41,53);
        List<Integer> newData = data.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
        List<Integer> newDatas = data.stream().filter(n ->n%2 != 0).collect(Collectors.toList());
        System.out.println("EVEN : "+newData+" "+ " ODD : "+newDatas);
    }
}
