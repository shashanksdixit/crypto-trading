package com.opentrading.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties (ignoreUnknown = true)
public class MarketResponse {
	private List<Market> data;
	private long timestamp;
}
