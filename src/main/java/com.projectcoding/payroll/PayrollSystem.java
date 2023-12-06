package com.projectcoding.payroll;

import com.projectcoding.employee.Employee;

import java.util.Arrays;

public class PayrollSystem {
    private Employee[] employees;

    public PayrollSystem() {
        this.employees = new Employee[0];
    }

    public void addEmployee(Employee employee) {
        this.employees = Arrays.copyOf(this.employees, this.employees.length + 1);
        this.employees[this.employees.length - 1] = employee;
    }

    public void printEmployees() {
        if (this.employees.length == 0) {
            System.out.println("No employees found in the system. Please add at least one employee to proceed.");
            return;
        }

        System.out.printf("%-11s | %-15s | %-25s | %-20s | %-20s | %-20s |%n",
                "EMPLOYEE ID", "NAME", "JOB TITLE", "GROSS PAY", "TAX PAY", "NET PAY");

        for (Employee emp : this.employees) {
            System.out.println(emp);
        }
    }
}
