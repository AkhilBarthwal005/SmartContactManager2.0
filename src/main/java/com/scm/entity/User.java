package com.scm.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    @Column(unique = true , nullable = false)
    private String username;
    private String password;
    @Column(unique = true , nullable = false)
    private String email;
    @Column(unique = true)
    private String phone;
    @Column(length = 1000)
    private String about;
    @Column(length = 1000)
    private String profile_pic;

    private boolean isEnabled;
    private boolean emailVerified;
    private boolean phoneVerified;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Provider provider = Provider.SELF;
    private String providerId;

    @OneToMany(mappedBy = "user",cascade =CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Contact> contacts = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<SocialLink> socialLink = new ArrayList<>();


}
