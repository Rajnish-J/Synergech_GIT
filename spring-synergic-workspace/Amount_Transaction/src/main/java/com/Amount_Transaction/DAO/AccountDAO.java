package com.Amount_Transaction.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Amount_Transaction.Entity.AccountVO;

@Repository
public interface AccountDAO extends JpaRepository<AccountVO, Long> {

	@Query("SELECT a FROM AccountVO a WHERE a.accountNumber = :accountNumber")
	AccountVO findByAccountNumber(@Param("accountNumber") Long accountNumber);

}
