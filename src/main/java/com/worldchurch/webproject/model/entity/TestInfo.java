package com.worldchurch.webproject.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "TEST_INFO")
@Builder
@AllArgsConstructor
public class TestInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(length = 200)
    private String name;

    @NotNull
    @Column()
    private Long age;

}
