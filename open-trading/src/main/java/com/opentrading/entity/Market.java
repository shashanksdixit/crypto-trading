package com.opentrading.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Market {
	private String exchangeId;
	private String rank;
	private String baseSymbol;
	private String baseId;
	private String quoteSymbol;
	private String quoteId;
	private String priceQuote;
	private String priceUsd;
	private String volumeUsd24Hr;
	private String percentExchangeVolume;
	private String tradesCount24Hr;
	private String updated;
}
