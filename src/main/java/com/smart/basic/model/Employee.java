package com.smart.basic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "employee")
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "emoloyee_statue")
    private String employeeStatus;

    @Column(name = "department_name")
    private String department;

}
