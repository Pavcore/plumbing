package com.pavcore.plumbing.dao.postgres.entity;

import com.pavcore.plumbing.dto.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "login", unique = true, nullable = false, length = 32)
    private String login;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "email", unique = true, nullable = false, length = 128)
    private String email;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "role_id")
    private Role role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private UserInfo userInfo;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orderList;
}
