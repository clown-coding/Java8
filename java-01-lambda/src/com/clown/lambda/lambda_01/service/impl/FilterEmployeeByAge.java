package com.clown.lambda.lambda_01.service.impl;

import com.clown.lambda.lambda_01.model.Employee;
import com.clown.lambda.lambda_01.service.FilterEmployee;

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
