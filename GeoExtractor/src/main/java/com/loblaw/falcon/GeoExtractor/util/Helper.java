/**
 * 
 */
package com.loblaw.falcon.GeoExtractor.util;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.loblaw.falcon.GeoExtractor.model.AppReq;
import com.loblaw.falcon.GeoExtractor.model.AppRes;

/**
 * @author srisrid
 *
 */
@Component
public class Helper {

	@Autowired
	RestTemplate restTemplate;

	public AppRes getGeoData(AppReq appReq) {

		AppRes appRes = null;
		appRes = getData(appReq.data);

		return appRes;
	}

	public String getLatLongData(AppReq appReq) {

			String output="";
			String customO = appReq.data;

			String locatArr[] = customO.split(",");
			for (String tempLocate : locatArr) {
				AppRes appRes = getData(tempLocate);
				output=output+appRes.postal+","+appRes.latt+","+appRes.longt+System.lineSeparator();
			}

		return output;
	}

	public AppRes getData(String locateStr) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String uri = "https://geocoder.ca/?locate=" + locateStr + "&geoit=XML&json=1";

		return restTemplate.exchange(uri, HttpMethod.GET, entity, AppRes.class).getBody();
	}

}
