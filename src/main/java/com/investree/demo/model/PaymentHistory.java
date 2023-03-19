package com.investree.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "payment_history")
public class PaymentHistory implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pembayaran_ke", nullable = false, length = 3)
    private Integer pembayaranKe;

    @Column(name = "jumlah")
    private Double jumlah;

    @Column(name = "bukti_pembayaran")
    private String buktiPembayaran;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_transaksi", referencedColumnName = "id")
    private Transaksi transaksi;

}

