package com.investree.demo.repository;


import com.investree.demo.model.Transaksi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransaksiRepository extends PagingAndSortingRepository<Transaksi, Long> {
    @Query("select c from Transaksi c WHERE c.id = :id")
    public Transaksi getByID(@Param("id") Long id);

    //soal 4
    @Query("select c from Transaksi c")
    Page<Transaksi> getList( Pageable pageable);

    Page<Transaksi> findByStatusLike(String status, Pageable pageable);
}