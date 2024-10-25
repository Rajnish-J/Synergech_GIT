package com.Amount_Transaction.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Amount_Transaction.Entity.UserVO;

@Repository
public interface UserDAO extends JpaRepository<UserVO, Long> {

}
