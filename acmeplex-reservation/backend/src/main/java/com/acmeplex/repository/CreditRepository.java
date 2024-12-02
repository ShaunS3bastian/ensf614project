package com.acmeplex.repository;

import com.acmeplex.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Integer> {
    List<Credit> findByUser_UserID(int userID); // Find credits by user ID
    List<Credit> findByRedeemCode(String redeemCode); // Find credits by redeem code
}
