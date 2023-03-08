package com.upvote.vote.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Dish {
    //    @GeneratedValue(generator="system-uuid")                        //for String autogeneration
    //    @GenericGenerator(name="system-uuid", strategy = "uuid")       //for String autogeneration
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private double price;
    @Column
    private String outlet;
    @Column
    private Integer count=0;
}
