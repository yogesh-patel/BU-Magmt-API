package com.synerzip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synerzip.model.BillingStatus;

public interface BillingStatusRepository extends JpaRepository<BillingStatus, Long>{

	long countByBillableStatus(String billableStatus);
}
