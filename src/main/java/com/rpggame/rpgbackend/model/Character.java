package com.rpggame.rpgbackend.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nickname;

   // @Column(columnDefinition = "default 50")
    private Integer gold;

   // @Column(columnDefinition = "default 1")
    private Integer level;

//    @ManyToOne
//    @JoinColumn(name = "account_id")
//    private Account account;


}
