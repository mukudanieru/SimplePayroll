package com.projectcoding.employee;

public class HourlyEmployee extends Employee {
    private final double hourlyRate;
    private int workHours;

    public HourlyEmployee(String name, String jobTitle, double tax, double hourlyRate, int workHours) {
        super(name, jobTitle, tax);
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }

    @Override
    public double grossPay() {
        return this.hourlyRate * this.workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }
}
