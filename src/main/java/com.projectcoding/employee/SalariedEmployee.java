package com.projectcoding.employee;

public class SalariedEmployee extends Employee {
    private final double salary;

    public SalariedEmployee(String name, String jobTitle, double tax, double salary) {
        super(name, jobTitle, tax);
        this.salary = salary;
    }

    @Override
    public double grossPay() {
        return this.salary;
    }
}
