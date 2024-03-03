package com.dersler.new_play_sales.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="Sales_GameName")
    private String salesGameName;

    @Column(name="Sales_Quantity")
    private int salesQuantity;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Customer customer;

    /*@ManyToOne
    @JoinColumn(name = "game_Name")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Games games1;*/

    @ManyToOne
    @JoinColumn(name = "games_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Games games;

}
