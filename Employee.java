# JavaOOP_HW9

package com.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

class Employee {

    public static enum Gender {

        MALE, FEMALE
    }

    private String name;
    private Gender gender;
    private LocalDate dob;
    private double income;
    private UUID code;

    private Employee(String name, Gender gender, LocalDate dob,
                     double income) {

        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.income = income;
        code = UUID.randomUUID();
    }

    public Employee() {
    }

    public Gender getGender() {
        return gender;
    }

    public double getIncome() {
        return income;
    }

    public static List<Employee> persons() {
        Employee p1 = new Employee("Jake", Gender.MALE, LocalDate.of(1971,
                Month.JANUARY, 1), 2343.0);
        Employee p2 = new Employee("Jack", Gender.MALE, LocalDate.of(1972,
                Month.JULY, 21), 7100.0);
        Employee p3 = new Employee("Jane", Gender.FEMALE, LocalDate.of(1973,
                Month.MAY, 29), 5455.0);
        Employee p4 = new Employee("Jode", Gender.MALE, LocalDate.of(1974,
                Month.OCTOBER, 16), 1800.0);
        Employee p5 = new Employee("Jeny", Gender.FEMALE, LocalDate.of(1975,
                Month.DECEMBER, 13), 1234.0);
        Employee p6 = new Employee("Jason", Gender.MALE, LocalDate.of(1976,
                Month.JUNE, 9), 3211.0);

        List<Employee> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

        return persons;
    }

    public static void statistics() {
        int sum = 0;
        for (Employee employee : persons()) {
            sum += employee.getIncome();
        }
        System.out.println(sum);
    }

    public void personsStatsByGenderCount() {
        List<Employee> employees = persons();
        Map<Gender, Long> groupByGender = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        groupByGender.forEach((gender, count) -> System.out.printf("there are %d %s employees", count, gender));
    }

    public void personStatsByGenderList() {
        List<Employee> employees = persons();
        Map<Gender, List<Employee>> groupByGender = employees.stream().collect(Collectors.groupingBy(Employee::getGender));
        groupByGender.forEach((gender, employeesList) -> {
            System.out.println(gender);
            employeesList.forEach(employee -> System.out.println(employee));
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.getIncome(), getIncome()) == 0 &&
                Objects.equals(name, employee.name) &&
                gender == employee.gender &&
                Objects.equals(dob, employee.dob) &&
                Objects.equals(code, employee.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, dob, getIncome(), code);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                ", income=" + income +
                ", code=" + code +
                '}';
    }
}

