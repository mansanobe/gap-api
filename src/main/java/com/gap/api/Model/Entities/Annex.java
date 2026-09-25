package com.gap.api.Model.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="annex")
public class Annex {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name="url", nullable = false)
    private String url;

    @Column(name="name", nullable = false)
    private String name;


}
