package com.app.leave_manager.repository;

import com.app.leave_manager.model.entities.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
    boolean existsByNameAndTenantIdAndDeletedFalse(String name, Long tenantId);
}
