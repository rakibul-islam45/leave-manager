package com.app.leave_manager.repository;

import com.app.leave_manager.model.entities.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
    boolean existsByNameAndDeletedFalse(String name);
    List<LeaveType> findAllByDeletedFalse();
}
