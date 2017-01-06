package com.hand.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.dao.CustomerMapper;
import com.hand.entity.Customer;
import com.hand.entity.CustomerExample;
import com.hand.entity.CustomerExample.Criteria;
import com.hand.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerMapper customerMapper;
	@Override
	public boolean login(String first_name) {
		CustomerExample example =new CustomerExample();
		
		Criteria criteria=example.createCriteria();
		criteria.andFirstNameEqualTo(first_name);
		List<Customer> customers=customerMapper.selectByExample(example);
		if(customers !=null &&customers.size()>0){
			return true;			
		}
		return false;
	}

}
