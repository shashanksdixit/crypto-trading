package com.opentrading.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Exchange {
	private String id;
	private String name;
	private String rank;
	private String percentTotalVolume;
	private String volumeUsd;
	private String tradingPairs;
	private String socket;
	private String exchangeUrl;
	private long updated;
}
