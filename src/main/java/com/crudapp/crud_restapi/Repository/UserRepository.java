package com.crudapp.crud_restapi.Repository;

import com.crudapp.crud_restapi.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long>{
    
}
