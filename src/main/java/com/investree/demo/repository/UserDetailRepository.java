package com.investree.demo.repository;


import com.investree.demo.model.UserDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDetailRepository extends PagingAndSortingRepository<UserDetail, Long> {
}