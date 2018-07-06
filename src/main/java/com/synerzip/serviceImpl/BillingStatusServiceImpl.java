package com.synerzip.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synerzip.repository.BillingStatusRepository;
import com.synerzip.service.BillingStatusService;

@Service
public class BillingStatusServiceImpl implements BillingStatusService{
	
	@Autowired
	BillingStatusRepository billingStatusRepository;

	@Override
	public Long getStatusCount(String string) {
		return billingStatusRepository.countByBillableStatus(string);
	}

	

}
