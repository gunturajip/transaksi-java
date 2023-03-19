package com.investree.demo.repository;

import com.investree.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    @Query("FROM User u WHERE LOWER(u.username) = LOWER(?1)")
    User findOneByUsername(String username);
}
