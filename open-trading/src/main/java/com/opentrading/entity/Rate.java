package com.opentrading.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rate {
	private String id;
	private String symbol;
	private String currencySymbol;
	private String rateUsd;
	private String type;
}
