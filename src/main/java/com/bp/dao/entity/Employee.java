package com.bp.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "fname", nullable = false)
    private String firstName;

    @Column(name = "minit")
    private String middleInitial;

    @Column(name = "lname", nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @Column(name = "job_lvl", nullable = false)
    private Integer jobLevel;

    @ManyToOne
    @JoinColumn(name = "pub_id", nullable = false)
    private Publisher publisher;

    @Column(name = "hire_date", nullable = false)
    private String hireDate;

}
