package com.worldchurch.webproject.model.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USER_INFO")
@Builder
@AllArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String userId;
    private String password;
    private String name;
    private String email;
    private String phoneNo;
    private String birthDt;

}
