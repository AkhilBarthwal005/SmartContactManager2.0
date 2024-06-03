package com.scm.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    @Column(unique = true , nullable = false)
    @Getter(AccessLevel.NONE)
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

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
