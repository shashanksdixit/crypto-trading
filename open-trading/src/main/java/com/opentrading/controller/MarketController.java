package com.opentrading.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.opentrading.entity.AssetHistoryResponse;
import com.opentrading.entity.AssetIdResponse;
import com.opentrading.entity.AssetMarketResponse;
import com.opentrading.entity.AssetsResponse;
import com.opentrading.entity.Candle;
import com.opentrading.entity.CandleResponse;
import com.opentrading.entity.ExchangeIdResponse;
import com.opentrading.entity.ExchangeResponse;
import com.opentrading.entity.MarketResponse;
import com.opentrading.entity.RateIdResponse;
import com.opentrading.entity.RateResponse;

@RestController
public class MarketController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.server}")
	private String url;

	@GetMapping("assets")
	public ResponseEntity<AssetsResponse> getAssets() throws IOException, URISyntaxException {
		URI uri = new URI(url + "/assets");
		ResponseEntity<AssetsResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
				AssetsResponse.class);
		AssetsResponse response = responseEntity.getBody();
		System.out.println(response);
		return responseEntity;
	}

	@GetMapping("assets/{id}")
	public ResponseEntity<AssetIdResponse> getAssets(@PathVariable String id) throws IOException, URISyntaxException {
		URI uri = new URI(url + "/assets/" + id);
		ResponseEntity<AssetIdResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
				AssetIdResponse.class);
		AssetIdResponse response = responseEntity.getBody();
		System.out.println(response.getData());
		return responseEntity;
	}

	@GetMapping("assets/{id}/history")
	public ResponseEntity<AssetHistoryResponse> getAssetsHistory(@PathVariable String id,
			@RequestParam(required = false) String interval) throws IOException, URISyntaxException {
		if (interval == null || (interval != null && interval.equals(""))) {
			interval = "m1";
		}
		URI uri = new URI(url + "/assets/" + id + "/history?interval=" + interval);
		ResponseEntity<AssetHistoryResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
				AssetHistoryResponse.class);
		AssetHistoryResponse response = responseEntity.getBody();
		System.out.println(response);
		return responseEntity;
	}

	@GetMapping("assets/{id}/market")
	public ResponseEntity<AssetMarketResponse> getAssetMarkets(@PathVariable String id,
			@RequestParam(required = false) String limit) throws IOException, URISyntaxException {
		StringBuilder apiurl = new StringBuilder(url).append("/assets/").append(id).append("markets");
		if (limit != null && !"".equals(limit)) {
			apiurl.append("?limit=").append(limit);
		}
		URI uri = new URI(apiurl.toString());
		ResponseEntity<AssetMarketResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
				AssetMarketResponse.class);
		AssetMarketResponse response = responseEntity.getBody();
		System.out.println(response);
		return responseEntity;
	}

	@GetMapping("rates")
	public ResponseEntity<RateResponse> getRates() throws IOException, URISyntaxException {
		URI uri = new URI(url + "/rates");
		ResponseEntity<RateResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
				RateResponse.class);
		RateResponse rates = responseEntity.getBody();
		System.out.println(rates);
		return responseEntity;
	}

	@GetMapping("rates/{id}")
	public ResponseEntity<RateIdResponse> getRateOf(@PathVariable String id) throws IOException, URISyntaxException {
		URI uri = new URI(url + "/rates/" + id);
		ResponseEntity<RateIdResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
				RateIdResponse.class);
		RateIdResponse rateofId = responseEntity.getBody();
		System.out.println(rateofId);
		return responseEntity;
	}

	@GetMapping("exchanges")
	public ResponseEntity<ExchangeResponse> getExchanges() throws IOException, URISyntaxException {
		URI uri = new URI(url + "/exchanges");
		ResponseEntity<ExchangeResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
				ExchangeResponse.class);
		ExchangeResponse exchanges = responseEntity.getBody();
		System.out.println(exchanges);
		return responseEntity;
	}

	@GetMapping("exchanges/{id}")
	public ResponseEntity<ExchangeIdResponse> getExchangeOf(@PathVariable String id)
			throws IOException, URISyntaxException {
		URI uri = new URI(url + "/exchanges/" + id);
		ResponseEntity<ExchangeIdResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
				ExchangeIdResponse.class);
		ExchangeIdResponse exchangeofId = responseEntity.getBody();
		System.out.println(exchangeofId);
		return responseEntity;
	}

	@GetMapping("markets")
	public ResponseEntity<MarketResponse> getMarkets(@RequestParam(required = false) String exchangeId,
			@RequestParam(required = false) String baseSymbol, @RequestParam(required = false) String quoteSymbol,
			@RequestParam(required = false) String baseId, @RequestParam(required = false) String quoteId,
			@RequestParam(required = false) String assetSymbol, @RequestParam(required = false) String assetId,
			@RequestParam(required = false) String limit, @RequestParam(required = false) String offset)
			throws IOException, URISyntaxException {
		StringBuilder apiurl = new StringBuilder(url).append("/markets");
		// TODO query parameters
		URI uri = new URI(apiurl.toString());
		ResponseEntity<MarketResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
				MarketResponse.class);
		MarketResponse response = responseEntity.getBody();
		System.out.println(response);
		return responseEntity;
	}

	@GetMapping("candles")
	public ResponseEntity<CandleResponse> getCandles(@RequestParam(required = true) String exchange,
			@RequestParam(required = true) String interval, @RequestParam(required = true) String baseId,
			@RequestParam(required = true) String quoteId) throws IOException, URISyntaxException {
		StringBuilder apiurl = new StringBuilder(url).append("candles");
		apiurl.append("?exchange=" + exchange).append("&interval=" + interval).append("&baseId" + baseId)
				.append("&quoteId" + quoteId);
		URI uri = new URI(apiurl.toString());
		ResponseEntity<CandleResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null,
				CandleResponse.class);
		CandleResponse response = responseEntity.getBody();
		System.out.println(response);
		return responseEntity;
	}

}
