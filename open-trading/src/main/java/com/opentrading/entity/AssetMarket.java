package com.opentrading.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssetMarket {
	private String exchangeId;
	private String baseId;
	private String quoteId;
	private String baseSymbol;
	private String quoteSymbol;
	private String volumeUsd24Hr;
	private String priceUsd;
	private String volumePercent;
}
