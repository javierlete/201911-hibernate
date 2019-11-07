package com.ecna.hibernate.mappings.unoauno;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
public class StockDetail {

	private Integer stockId;
	@ToString.Exclude private Stock stock;
	private String compName;
	private String compDesc;
	private String remark;
	private Date listedDate;

}