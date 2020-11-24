/**
 * 
 */
package com.loblaw.falcon.GeoExtractor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loblaw.falcon.GeoExtractor.model.AppReq;
import com.loblaw.falcon.GeoExtractor.model.AppRes;
import com.loblaw.falcon.GeoExtractor.util.Helper;

/**
 * @author srisrid
 *
 */



@RestController
@RequestMapping(path = "/geodata")
public class GeoController 
{
    @Autowired
    Helper helper;
	
    @PostMapping(path="/", produces = "application/json")
    public AppRes getGeo(@RequestBody AppReq appReq) 
    {

    	AppRes appRes = helper.getGeoData(appReq);
    	return appRes;
    }
    
    @PostMapping(path="/getlatlong", produces = "application/json")
    public String getlatlong(@RequestBody AppReq appReq) 
    {

    	String outputAppRes = helper.getLatLongData(appReq);
    	return outputAppRes;
    }

    
}   
