package com.jbw.jpaNotionRelation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "persons")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //ici je defini ma relation
    @OneToOne
    @JoinColumn(name = "profile_id") //colone de la joiture
    private Profile profile;

    @OneToMany(mappedBy = "user")
    private List<Post> posts; // pour dire que plusieurs post peuvent appartenir un seul user

    @ManyToMany
    @JoinTable(
            name = "user_groups",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "groupId")
    )
    private Set<UserGroup> groups;
}
