package com.Rishabh.Security.Repositotry;

import com.Rishabh.Security.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, String > {
    // This interface can be used to define custom query methods if needed.
    // For example, you can add methods like findByUserName(String userName) to retrieve users by their username.
    Optional<UserEntity> findByUserName(String userName);
}
