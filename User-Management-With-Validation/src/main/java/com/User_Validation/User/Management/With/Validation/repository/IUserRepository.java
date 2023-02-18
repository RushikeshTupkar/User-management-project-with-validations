package com.User_Validation.User.Management.With.Validation.repository;

import com.User_Validation.User.Management.With.Validation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

}
