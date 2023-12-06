package com.projectcoding;

import com.projectcoding.employee.CommissionedEmployee;
import com.projectcoding.employee.HourlyEmployee;
import com.projectcoding.employee.SalariedEmployee;
import com.projectcoding.payroll.PayrollSystem;

import java.util.Scanner;

public class Main {
    private final static Scanner input = new Scanner(System.in);
    private final static PayrollSystem payroll = new PayrollSystem();
    public static void main(String[] args) {
        simulator();
        input.close();
    }

    private static void simulator() {
        while (true) {
            System.out.println("-- Payroll Simulator --");
            menu();
            int prompt = (int) getDouble("Choose: ");

            if (prompt == 1) {
                add();
            } else if (prompt == 2) {
                payroll.printEmployees();
            } else if (prompt == 3) {
                return;
            } else {
                System.out.println("Invalid input!");
            }

            while (true) {
                int exit = (int) getDouble("Exit the program? [1] YES | [2] NO: ");

                if (exit == 1)
                    return;
                else if (exit == 2)
                    break;
                else
                    System.out.println("Invalid input!");
            }
        }
    }

    private  static void menu() {
        System.out.println("[1] Add | [2] Display employee report | [3] Exit");
    }

    private static void add() {
        System.out.println("\nPlease select the type of employee:");
        System.out.println("[1] - Salaried Employee | [2] - Hourly Employee | [3] - Commissioned Employee");

        int prompt = (int) getDouble("Choose: ");
        if (prompt == 1) {
            payroll.addEmployee(getSalariedEmployee());
        } else if (prompt == 2) {
            payroll.addEmployee(getHourlyEmployee());
        } else if (prompt == 3) {
            payroll.addEmployee(getCommissionedEmployee());
        } else {
            System.out.println("Invalid input!");
        }
    }

    private static SalariedEmployee getSalariedEmployee() {
        System.out.println("\n-- Salaried Employee --");

        String name = getString("Name: ");
        String jobTittle = getString("Job title: ");
        double tax = getDouble("Tax percentage: ") / 100;
        double salary = getDouble("Gross salary: ");

        return new SalariedEmployee(name, jobTittle, tax, salary);
    }

    private static HourlyEmployee getHourlyEmployee() {
        System.out.println("\n-- Hourly Employee --");
        String name = getString("Name: ");
        String jobTittle = getString("Job title: ");
        double tax = getDouble("Tax percentage: ") / 100;
        double hourlyRate = getDouble("Hourly rate: ");

        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        int totalHours = 0;

        System.out.println("\n-- Your work hours for each day --");
        for (String day : weekdays) {
            totalHours += (int) getDouble(String.format("%s: ", day));
        }

        System.out.printf("Your total work hours: %d hours%n", totalHours);
        return new HourlyEmployee(name, jobTittle, tax, hourlyRate, totalHours);
    }

    private static CommissionedEmployee getCommissionedEmployee() {
        System.out.println("\n-- Commissioned Employee --");

        String name = getString("Name: ");
        String jobTittle = getString("Job title: ");
        double tax = getDouble("Tax percentage: ") / 100;
        double commission = getDouble("Commission percentage: ") / 100;

        int numSales = (int) getDouble("Number of sales: ");

        CommissionedEmployee emp = new CommissionedEmployee(name, jobTittle, tax, commission, numSales);
        double[] sales = new double[numSales];

        for (int i = 0; i < numSales; i++) {
            sales[i] = getDouble(String.format("Sales #%d", i+1));
        }

        emp.setSales(sales);
        System.out.printf("Total sales: ₱%,.2f%n", emp.totalSales());
        return emp;
    }

    private static String getString(String message) {
        System.out.print(message);
        return input.nextLine();
    }
    private static double getDouble(String message) {
        System.out.print(message);
        double get = input.nextDouble();
        input.nextLine();

        return get;
    }
}
