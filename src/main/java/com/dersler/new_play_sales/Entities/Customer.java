package com.dersler.new_play_sales.Entities;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customers")
public class Customer {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="First_Name")
    private String firstName;

    @Column(name="Last_Name")
    private String lastName;

    @Column(name="User_Name")
    private String userName;

    @Column(name="Password")
    @NotNull
    private String password;

    @Column(name="Year_Of_Birth")
    private int yearOfBirth;

    @Column(name="Nationality_Id")
    private String nationalityId;

    /*@OneToMany
    @JoinColumn(name = "sales_id")
    private List<Sales> sales;*/

}
