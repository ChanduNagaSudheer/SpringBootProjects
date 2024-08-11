package com.chandu.Employee.Model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="Employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
     private String name;
     private String location;
     private String preference;
}
