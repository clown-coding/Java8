package com.clown.stream.service.impl;

import com.clown.stream.model.Employee;
import com.clown.stream.service.FilterEmployee;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/14
 **/
public class FilterEmployeeByAge implements FilterEmployee<Employee> {

    @Override
    public boolean filter(Employee employee) {
        return employee.getAge() >= 35;
    }
}
