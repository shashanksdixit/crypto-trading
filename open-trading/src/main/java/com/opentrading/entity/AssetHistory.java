package com.opentrading.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public class AssetHistory {
	private BigDecimal priceUsd;
	private Date date;
	private long time;
	private BigDecimal circulatingSupply;
}
