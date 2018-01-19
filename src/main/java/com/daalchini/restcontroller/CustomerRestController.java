package com.daalchini.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daalchini.dto.CustomerInfoDto;
import com.daalchini.dto.CustomerListDto;
import com.daalchini.exceptions.CustomerNotAvailableException;
import com.daalchini.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

	private CustomerService customerService;
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	//return CustomerInfo as response 
	@RequestMapping(value="/find/{mobileNo}", produces="application/xml")
	public CustomerInfoDto findCustomerByMobile(@PathVariable("mobileNo") String mobileNo) {
		return customerService.getCustomerInfoByMobile(mobileNo);
	}
	
	@RequestMapping(value="/get-customers", produces="application/xml")
	public ResponseEntity<CustomerListDto> allCustomers() {
		CustomerListDto cListDto = null;
		try {
			 cListDto = new CustomerListDto(customerService.getAllCustomers());
		} catch(CustomerNotAvailableException e) {
			return new ResponseEntity<CustomerListDto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CustomerListDto>(cListDto, HttpStatus.OK);
	}
}
