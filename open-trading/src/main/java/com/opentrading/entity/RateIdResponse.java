package com.opentrading.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties (ignoreUnknown = true)
public class RateIdResponse {
	private Rate data;
	private long timestamp;
}
