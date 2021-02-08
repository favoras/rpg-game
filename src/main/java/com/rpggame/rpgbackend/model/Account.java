package com.rpggame.rpgbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

//    @ManyToMany
//    @JoinTable(
//            name = "account_roles",
//            joinColumns = { @JoinColumn(name = "account_id") },
//            inverseJoinColumns = { @JoinColumn(name = "role_id") } )
//    private Collection<Role> roles;
//
//    @OneToMany(mappedBy = "account")
//    private Collection<Character> characters;

}
