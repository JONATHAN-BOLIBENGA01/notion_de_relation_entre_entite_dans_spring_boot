package com.jbw.jpaNotionRelation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "userGroup")
@Data
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;

    @ManyToMany(mappedBy = "groups")
    private Set<User> users;
}
