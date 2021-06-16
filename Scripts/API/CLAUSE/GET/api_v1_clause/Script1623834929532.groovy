import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.junit.Assert;

WebUI.callTestCase(findTestCase('API/COMMON/POST/api_v1_login'), ["userName":GlobalVariable.username,"password":GlobalVariable.password], FailureHandling.STOP_ON_FAILURE)

// nom de la request
def request = new RequestObject("login")

// set la methode de la reqête
request.setRestRequestMethod(GlobalVariable.request_method_get)

// Url ou endoint en format string
url = GlobalVariable.baseUrl +'/api/v1/clause/Template_gdpr_en.docx'
System.out.println("endpoint : " + url)

// set l'url de la requete
request.setRestUrl(url)

// Creation d'un list de parametre pour le header
ArrayList<TestObjectProperty> HTTPHeader = new ArrayList<TestObjectProperty>()

//Add token to header
HTTPHeader.add(new TestObjectProperty('Authorization', ConditionType.EQUALS, "Bearer "+ GlobalVariable.token ))

// set le header de la requête
request.setHttpHeaderProperties(HTTPHeader)

// envoie de la requête
def response = WS.sendRequest(request)

//Affichage du status code de la requête
println("Status code : " + response.getStatusCode().toString());

//Vérifier que le status code est bien 200
def responseCode = response.getStatusCode()

boolean PASSED = WS.verifyMatch(responseCode.toString(), '200', true)

//Affichage de la réponse
println('Response body: ' + response.getResponseText())
String body_rep = response.getResponseText()

print("Clause file informations :: " + body_rep)

