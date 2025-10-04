package com.app.leave_manager.repository;

import com.app.leave_manager.model.entities.LeaveRequest;
import com.app.leave_manager.model.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

    Page<LeaveRequest> findAllByStatus(Status status, Pageable pageable);

}
