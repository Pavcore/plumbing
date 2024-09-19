package com.pavcore.plumbing.entiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "first_name", length = 64)
    private String firstName;

    @Column(name = "last_name", length = 128)
    private String lastName;

    @Column(name = "phone", length = 16)
    private int phone;

    @Column(name = "address", length = 256)
    private String address;
}
