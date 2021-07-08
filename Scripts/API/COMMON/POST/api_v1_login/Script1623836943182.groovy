import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import internal.GlobalVariable
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.impl.client.HttpClientBuilder
import com.kms.katalon.core.testobject.FormDataBodyParameter
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.ResponseObject

String url = "https://back.datachallenge-integration.ibm.ifsalpha.com/api/v1/login"

TestObjectProperty header1 = new TestObjectProperty("Content-Type", ConditionType.EQUALS, "multipart/form-data")

ArrayList defaultHeaders = Arrays.asList(header1)

RequestObject request = new RestRequestObjectBuilder()

		.withRestUrl(url)

		.withRestRequestMethod("POST")

 .withHttpHeaders(defaultHeaders)

	 .withMultipartFormDataBodyContent([

		 new FormDataBodyParameter('email', GlobalVariable.crypted_email, 'PARAM_TYPE_TEXT'),

		])

		.build()

ResponseObject response = WS.sendRequest(request)

String token = response.getResponseText().toString() 

System.out.println("token avant substring : " + token)

def tokenIncome = token.substring(18, token.indexOf(","))

GlobalVariable.token = tokenIncome.substring(0, tokenIncome.length()-1)

System.out.println("token : " + GlobalVariable.token)
