package com.daalchini.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="customer-details")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerListDto {
	
	@XmlElement(name="customer-infos")
	private List<CustomerInfoDto> cInfoDtos;
	
	public CustomerListDto(List<CustomerInfoDto> cInfoDtos) {
		super();
		this.cInfoDtos = cInfoDtos;
	}

	public CustomerListDto() {
		super();
	}

	public List<CustomerInfoDto> getcInfoDtos() {
		return cInfoDtos;
	}

	public void setcInfoDtos(List<CustomerInfoDto> cInfoDtos) {
		this.cInfoDtos = cInfoDtos;
	}
	
	

}
