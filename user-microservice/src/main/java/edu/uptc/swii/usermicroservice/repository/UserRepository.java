package edu.uptc.swii.usermicroservice.repository;

import edu.uptc.swii.usermicroservice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    List<Users> findAll();
}
