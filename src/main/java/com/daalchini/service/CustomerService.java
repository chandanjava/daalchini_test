package com.daalchini.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daalchini.dao.CustomerDao;
import com.daalchini.dto.CustomerInfoDto;
import com.daalchini.entities.Customer;

@Service
public class CustomerService {
	
	private CustomerDao customerDao;

	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	//return CustomerInfoDto 
	public CustomerInfoDto getCustomerInfoByMobile(String mobileNo) {
		Customer customer = customerDao.getCutomerByMobile(mobileNo);
		CustomerInfoDto customerInfoDto = getCustomerDto(customer);
		return customerInfoDto;
	}
	
	//return all customers
	public List<CustomerInfoDto> getAllCustomers(){
		List<Customer> customers = customerDao.getAllCustomers();
		List<CustomerInfoDto> customersDto = new ArrayList<>();
		for(Customer customer : customers)
			customersDto.add(getCustomerDto(customer));
		return customersDto;
	}

	//convert Customer object to CustomerInfoDto object
	private CustomerInfoDto getCustomerDto(Customer customer) {
		CustomerInfoDto cInfoDto = new CustomerInfoDto();
		cInfoDto.setCustomerId(customer.getCustomerId());
		cInfoDto.setCustomerName(customer.getCustomerName());
		cInfoDto.setCustomerDOB(customer.getCustomerDOB());
		cInfoDto.setCustomerAddress(customer.getCustomerAddress());
		cInfoDto.setCustomerMobileNo(customer.getCustomerMobileNo());
		return cInfoDto;
	}
	

}
