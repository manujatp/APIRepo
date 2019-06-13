package com.rest.qa.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rest.qa.base.TestBase;
import com.rest.qa.client.RestClient;
import com.rest.qa.util.TestUtil;

public class GetAPITest extends TestBase {
	
	CloseableHttpResponse closeableHttpResponse;
@Test
public void get() throws ClientProtocolException, IOException{
	String serviceURL = prop.getProperty("serviceURL");
	String apiURL = prop.getProperty("apiURL");
	
	String url = serviceURL+apiURL;
	
	RestClient restClient = new RestClient();
	closeableHttpResponse = restClient.get(url);
	
	//Satus code
			int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
			System.out.println("Status code is : "+statusCode);
			
			Assert.assertEquals(statusCode,RESPONSE_STATUS_CODE_200);
			
			//Response
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
			JSONObject responseJson = new JSONObject(responseString);
			System.out.println("Resposne from API-------->"+responseJson);
			
			String perPageValue = TestUtil.getValueByJPath(responseJson,"/per_page");
			System.out.println(perPageValue);
			
			String totalPage = TestUtil.getValueByJPath(responseJson,"/total");
			System.out.println(totalPage);
			
			Assert.assertEquals(Integer.parseInt(totalPage), 12);	
			
			//get the valuefrom JSON array
			
			String lastName = TestUtil.getValueByJPath(responseJson,"/data[0]/last_name");
			String id = TestUtil.getValueByJPath(responseJson,"/data[0]/id");
			String avatar = TestUtil.getValueByJPath(responseJson,"/data[0]/avatar");
			String firstName = TestUtil.getValueByJPath(responseJson,"/data[0]/first_name");
			
			System.out.println(lastName+" "+ id+ " "+avatar+" "+firstName);
			
			//All Headers
			Header[] headerArray = closeableHttpResponse.getAllHeaders();
			
			HashMap<String,String> allHeaders = new HashMap<String,String>();
			
			for(Header header : headerArray){
				allHeaders.put(header.getName(), header.getValue());
			}
			
			System.out.println("Headers Array--->"+allHeaders);
			
		
			
}

@Test
public void getWithHeaders() throws ClientProtocolException, IOException{
	String serviceURL = prop.getProperty("serviceURL");
	String apiURL = prop.getProperty("apiURL");
	
	String url = serviceURL+apiURL;
	
	RestClient restClient = new RestClient();
	
	HashMap<String,String> headerMap = new HashMap<String,String>();
	headerMap.put("Content-Type", "application/json");
	
	closeableHttpResponse = restClient.get(url,headerMap);
	
	//Satus code
			int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
			System.out.println("Status code is : "+statusCode);
			
			Assert.assertEquals(statusCode,RESPONSE_STATUS_CODE_200);
			
			//Response
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
			JSONObject responseJson = new JSONObject(responseString);
			System.out.println("Resposne from API-------->"+responseJson);
			
			String perPageValue = TestUtil.getValueByJPath(responseJson,"/per_page");
			System.out.println(perPageValue);
			
			String totalPage = TestUtil.getValueByJPath(responseJson,"/total");
			System.out.println(totalPage);
			
			Assert.assertEquals(Integer.parseInt(totalPage), 12);	
			
			//get the valuefrom JSON array
			
			String lastName = TestUtil.getValueByJPath(responseJson,"/data[0]/last_name");
			String id = TestUtil.getValueByJPath(responseJson,"/data[0]/id");
			String avatar = TestUtil.getValueByJPath(responseJson,"/data[0]/avatar");
			String firstName = TestUtil.getValueByJPath(responseJson,"/data[0]/first_name");
			
			System.out.println(lastName+" "+ id+ " "+avatar+" "+firstName);
			
			//All Headers
			Header[] headerArray = closeableHttpResponse.getAllHeaders();
			
			HashMap<String,String> allHeaders = new HashMap<String,String>();
			
			for(Header header : headerArray){
				allHeaders.put(header.getName(), header.getValue());
			}
			
			System.out.println("Headers Array--->"+allHeaders);
			
		
			
}
	
}
