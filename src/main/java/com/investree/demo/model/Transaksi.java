package com.investree.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "transaksi")
public class Transaksi implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenor", nullable = false, length = 3)
    private Integer tenor;

    @Column(name = "total_pinjaman")
    private Double totalPinjaman;

    @Column(name = "bunga_persen")
    private Double bungaPersen;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @ManyToOne(targetEntity=User.class)
    @JoinColumn(name="id_peminjam")
    private User peminjam;

    @ManyToOne(targetEntity=User.class)
    @JoinColumn(name="id_meminjam")
    private User meminjam;
}

