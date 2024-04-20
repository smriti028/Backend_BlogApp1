package com.BlogApp1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployerMain {
    public static void main(String[] args) {
        Employer e1 = new Employer();
        e1.setId(1);
        e1.setName("mike");
        Employer e2 = new Employer();
        e2.setId(2);
        e2.setName("Stallin");

        List<Employer> emp = Arrays.asList(e1,e2);
        List<EmployerDto> empDto = emp.stream().map(e -> mapToDto(e)).collect(Collectors.toList());
        System.out.println(empDto);
    }

   static EmployerDto mapToDto(Employer e7 ){
        EmployerDto dto = new EmployerDto();
        dto.setId(e7.getId());
        dto.setName(e7.getName());
        return dto;
    }
}
