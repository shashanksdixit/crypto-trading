package com.opentrading.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Candle {
	private String open;
	private String high;
	private String low;
	private String close;
	private String volume;
	private String period;
}
