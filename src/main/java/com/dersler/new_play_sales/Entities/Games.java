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
@Table(name="games")
public class Games {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="game_Name")
    private String gameName;

    @Column(name="first_Quantity")
    private int firstQuantity;

    @Column(name="last_Quantity")
    private int lastQuantity;

    @Column(name="sold_Quantity")
    private int soldQuantity;

    /*@OneToMany
    @JoinColumn(name = "sales_id")
    private List<Sales> sales;*/

}
