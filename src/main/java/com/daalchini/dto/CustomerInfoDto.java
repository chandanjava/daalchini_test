package com.daalchini.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author CHANDAN transfer data from CustomerService to CustomerRestController
 */
@XmlRootElement(name="customer-info")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerInfoDto {

	@XmlElement(name="id")
	private int customerId;
	@XmlElement(name="name")
	private String customerName;
	@XmlElement(name="address")
	private String customerAddress;
	@XmlElement(name="dob")
	private Date customerDOB;
	@XmlElement(name="mobile")
	private String customerMobileNo;

	public CustomerInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerInfoDto(int customerId, String customerName, String customerAddress, Date customerDOB,
			String customerMobileNo) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerDOB = customerDOB;
		this.customerMobileNo = customerMobileNo;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Date getCustomerDOB() {
		return customerDOB;
	}

	public void setCustomerDOB(Date customerDOB) {
		this.customerDOB = customerDOB;
	}

	public String getCustomerMobileNo() {
		return customerMobileNo;
	}

	public void setCustomerMobileNo(String customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}

	@Override
	public String toString() {
		return "CustomerInfoDto [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerDOB=" + customerDOB + ", customerMobileNo=" + customerMobileNo + "]";
	}

}
