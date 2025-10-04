package com.app.leave_manager.repository;

import com.app.leave_manager.model.entities.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Long> {

    List<LeaveBalance> findAllByUserId(Long userId);

    Optional<LeaveBalance> findByUserIdAndLeaveTypeId(Long userId, Long leaveTypeId);

}
