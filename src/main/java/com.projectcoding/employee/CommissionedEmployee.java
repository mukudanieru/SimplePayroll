package com.projectcoding.employee;

public class CommissionedEmployee extends Employee {
    private final double commissionPercent;
    private final int numberOfSales;
    private double[] sales;

    public CommissionedEmployee(String name, String jobTitle, double tax, double commissionPercent, int numberOfSales) {
        super(name, jobTitle, tax);
        this.commissionPercent = commissionPercent;
        this.numberOfSales = numberOfSales;
        this.sales = new double[numberOfSales];
    }

    public double totalSales() {
        double sumSales = 0;

        for (int i = 0; i < this.numberOfSales; i++) {
            sumSales += this.sales[i];
        }

        return sumSales;
    }

    @Override
    public double grossPay() {
        return this.commissionPercent * this.totalSales();
    }

    public void setSales(double[] sales) {
        this.sales = sales;
    }
}
