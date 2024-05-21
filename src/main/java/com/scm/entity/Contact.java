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
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contact_id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String image;
    @Column(length = 1000)
    private String description;
    private boolean favorite;
    private boolean blocked;
    private boolean deleted;

    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<SocialLink> socialLink = new ArrayList<>();


}
