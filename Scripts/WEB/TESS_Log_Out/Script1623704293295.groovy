import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By as By;
import org.openqa.selenium.By.ByClassName
import org.openqa.selenium.By.ById
import org.openqa.selenium.WebElement as WebElement;
import common.utilities

WebUI.callTestCase(findTestCase('WEB/TESS_Login_In_Cas_Passant'), ["userName":GlobalVariable.username,"password":GlobalVariable.password], FailureHandling.STOP_ON_FAILURE)

String res = "KO"

//Create instance of WebDriver
WebDriver webdriver ;
webdriver = DriverFactory.getWebDriver()

//instance class for keyword
my_use= new utilities()

// Find Elements
WebElement logout = webdriver.findElement(By.id("user-icon")).click()
WebElement logoutitem = webdriver.findElement(By.id("logout-menu-item")).click()
WebElement login = webdriver.findElement(By.id("login-button"))

//Highlight button
my_use.runhightlightById("login-button", webdriver, "res")

//Delay of 3 seconds
WebUI.delay(3)

webdriver.quit()

