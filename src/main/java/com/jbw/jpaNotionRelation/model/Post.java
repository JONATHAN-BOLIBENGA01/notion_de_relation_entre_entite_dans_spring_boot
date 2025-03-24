package com.jbw.jpaNotionRelation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // pour qu'un post appartient a un seul user

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;
}
