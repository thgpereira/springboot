package com.gmail.tthiagoaze.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gmail.tthiagoaze.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findByNameContainingIgnoreCase(String name);
	
	@Query("from User where id = :xx")
	User findById2(@Param("xx") Long id);

}
