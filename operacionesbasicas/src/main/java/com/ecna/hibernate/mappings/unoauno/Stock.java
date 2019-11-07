package com.ecna.hibernate.mappings.unoauno;

import lombok.Data;

@Data
public class Stock {

	private Integer stockId;
	private String stockCode;
	private String stockName;
	private StockDetail stockDetail;
	
}