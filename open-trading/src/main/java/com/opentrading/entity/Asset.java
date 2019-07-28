package com.opentrading.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Asset {
	private String id;
	private String rank;
	private String symbol;
	private String name;
	private String supply;
	private String maxSupply;
	private String marketCapUsd;
	private String volumeUsd24Hr;
	private String priceUsd;
	private String changePercent24Hr;
	private String vwap24Hr;
}
