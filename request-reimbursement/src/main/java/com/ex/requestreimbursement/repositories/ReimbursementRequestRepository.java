package com.ex.requestreimbursement.repositories;

import com.ex.requestreimbursement.models.ReimbursementRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Repository for reimbursement request data
 */

@Qualifier("reimbursementrequests")
@Repository
public interface ReimbursementRequestRepository extends JpaRepository<ReimbursementRequest, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update reimbursementrequest set manager_id = ?2 where id = ?1", nativeQuery = true)
    void updateManager(Integer id, Integer manager_id);

    @Transactional
    @Modifying
    @Query(value = "update reimbursementrequest set status = ?2 where id = ?1", nativeQuery = true)
    void updateStatus(Integer id, String status);

    List<ReimbursementRequest> findAllByManagerId(Integer managerId);

    List<ReimbursementRequest> findAllByEmployeeId(Integer employeeId);

}
