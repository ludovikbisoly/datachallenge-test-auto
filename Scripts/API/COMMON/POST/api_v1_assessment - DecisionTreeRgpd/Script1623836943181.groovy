import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.applitools.connectivity.api.HttpClient
import com.google.api.client.http.HttpRequest
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.common.HttpUriRequest
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.JsonBuilder
import internal.GlobalVariable as GlobalVariable
import org.apache.http.HttpHeaders
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.RequestBuilder
import org.apache.http.impl.client.HttpClients
import org.eclipse.jetty.http.HttpURI
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


// Set header

HttpHeaders header_content_type = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json")
HttpHeaders header_url = new BasicHeader(HttpHeaders.LOCATION, "https://back.datachallenge-integration.ibm.ifsalpha.com/api/v1/gdpr-assessment")
List <Header> headers = Arrays.asList(header_content_type,header_url)

HttpClient httpclient = HttpClients.custom().setDefaultHeaders(headers).build()
HttpUriRequest request = RequestBuilder.get().setUri("https://back.datachallenge-integration.ibm.ifsalpha.com/api/v1/gdpr-assessment").build()
request.setHeader(headers)
request.setMethod("POST")
// Set Body if exist for post method

JSONObject jsonObj =new JsonObject();


// Send request

// get reponse code + respond

//compare responce code with expected code

// get responce 
