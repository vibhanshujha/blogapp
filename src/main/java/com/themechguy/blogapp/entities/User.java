package com.themechguy.blogapp.entities;

import java.util.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_seq_gen")
    @SequenceGenerator(name="my_seq_gen", sequenceName="MY_SEQUENCE")
    private Long id;

    @Column(name ="user_name", nullable = false, length = 100)
    // @Size(min = 3, message = "Name must be 3 character long")
    private String name;
    @Column(name ="user_id", nullable = false, length = 100)
    private String email;
    @Column(name ="password", nullable = false)
    // @Size(min = 6, message = "Password must have 6 or more character") 
    private String password;
    @Column(name="profile_description", length = 300)
    private String about;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts=new ArrayList<>();

    
}
