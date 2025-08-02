package com.app.leave_manager.repository;

import com.app.leave_manager.model.entities.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Long> {
}
