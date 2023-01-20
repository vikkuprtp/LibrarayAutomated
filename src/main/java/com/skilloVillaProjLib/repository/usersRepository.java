package com.skilloVillaProjLib.repository;

import com.skilloVillaProjLib.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usersRepository extends JpaRepository<Users,Integer> {
}
