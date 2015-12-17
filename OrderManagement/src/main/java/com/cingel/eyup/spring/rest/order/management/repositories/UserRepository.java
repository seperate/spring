package com.cingel.eyup.spring.rest.order.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cingel.eyup.spring.rest.order.management.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
