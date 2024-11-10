package com.hari.model;





import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String department;
    private String position;
    private BigDecimal salary;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public static Builder builder(){
        return new  Builder();
    }

    public static class Builder{
        private final Employee employee;
        public Builder(){
            this.employee = new Employee();
        }
        public Builder id(Long id){
            employee.setId(id);
            return this;
        }
        public Builder firstName(String firstName){
            employee.setFirstName(firstName);
            return this;
        }
        public Builder lastName(String lastName){
            employee.setLastName(lastName);
            return this;
        }
        public Builder department(String department){
            employee.setDepartment(department);
            return this;
        }
        public Builder position(String position){
            employee.setPosition(position);
            return this;
        }
        public Builder salary(BigDecimal salary){
            employee.setSalary(salary);
            return this;
        }
        public Employee build(){
            return employee;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
