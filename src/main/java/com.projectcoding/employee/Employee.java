package com.projectcoding.employee;

public abstract class Employee {
    protected static int nextEmployeeId = 0;
    protected int employeeId;
    protected String name;
    protected String jobTitle;
    protected double tax;

    protected Employee(String name, String jobTitle, double tax) {
        nextEmployeeId++;
        this.employeeId = nextEmployeeId;
        this.name = name;
        this.jobTitle = jobTitle;
        this.tax = tax;
    }

    public abstract double grossPay();

    @Override
    public String toString() {
        return String.format("%-11d | %-15s | %-25s | ₱%,-19.2f | ₱%,-19.2f | ₱%,-19.2f |",
                this.getEmployeeId(), this.getName(), this.getJobTitle(), this.grossPay(),
                this.taxPay(), this.netPay());
    }

    public double taxPay() {
        return this.grossPay() * this.tax;
    }

    public double netPay() {
        return this.grossPay() - this.taxPay();
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public String getName() {
        return this.name;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public double getTax() {
        return this.tax;
    }
}
