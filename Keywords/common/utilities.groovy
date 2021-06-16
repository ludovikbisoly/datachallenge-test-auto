package common

import java.security.SecureRandom
import org.json.JSONObject  as JSONObject
import java.util.ArrayList
import internal.GlobalVariable as GlobalVariable
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By as By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver as WebDriver ;
import org.openqa.selenium.WebElement as WebElement;
import org.openqa.selenium.By.ByClassName
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import org.testng.Assert



public class utilities {


	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	@Keyword
	// Verify Options Presents
	// https://docs.katalon.com/display/KD/%5BWebUI%5D+Verify+Options+Present
	def CheckDropDownListElementExist(TestObject object, String option) {

		boolean flag;
		// Get the element
		WebElement element = WebUiCommonHelper.findWebElement(object, 20);
		Select ddl = new Select(element);

		for (WebElement elt : ddl.getOptions()) {
			if (elt.getText().equals(option)) {
				System.out.println("Element exist !!");
				flag = true;
			}
			else {
				System.out.println("Element does not exist !!");
				flag = false;
			}
		}

		// return the flag
		return flag;
	}
	@Keyword
	public static String runhightlightById(String id,WebDriver driver,String res) {
		try {
			WebElement element = driver.findElement(By.id(id))
			WebUI.executeJavaScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", Arrays.asList(
					element))
			WebUI.delay(1);
			WebUI.executeJavaScript("arguments[0].setAttribute('style','border: solid 2px orange');", Arrays.asList(
					element));

		} catch (Exception e) {
			res="KO!"
			println(e.getMessage());
		}
		println(res)
		return res
	}
	@Keyword
	public static String runhightlightByClassName(String classname,WebDriver driver,String res) {
		try {
			WebElement element = driver.findElement(ByClassName.className(classname))
			WebUI.executeJavaScript("arguments[0].setAttribute('style', 'background: black; border: 2px solid red;');", Arrays.asList(
					element))
			WebUI.delay(1);
			WebUI.executeJavaScript("arguments[0].setAttribute('style','border: solid 2px orange');", Arrays.asList(
					element));

		} catch (Exception e) {
			res="KO!"
			println(e.getMessage());
		}
		println(res)
		return res
	}
	@Keyword
	public static String runhightlightColor(String id,WebDriver driver,String BackgroundColor,String BorderColor) {
		try {
			WebElement element = driver.findElement(By.id(id))
			WebUI.executeJavaScript("arguments[0].setAttribute('style', 'background:'"+ BackgroundColor +"'; border: 2px solid '"+ BorderColor +"';');", Arrays.asList(
					element))
			WebUI.delay(1);
		} catch (Exception e) {
			println(e.getMessage());
		}
	}
	@Keyword
	Boolean CheckConnexion(WebDriver webdriver,TestObject objectto){
		//Test if connexion success
		boolean success = true ;
		try {
			WebUI.waitForElementVisible(objectto, 10)
		} catch (Exception e) {
			success = false
			e.printStackTrace()
		}
		println (success)
		return success
	}
	@Keyword
	public LocalStorage(WebDriver webDriver,JavascriptExecutor jsp) {
		this.js = (JavascriptExecutor) webDriver;
	}
	@Keyword
	public void removeItemFromLocalStorage(String item,JavascriptExecutor jsp) {
		js.executeScript(String.format(
				"window.localStorage.removeItem('%s');", item));
	}
	@Keyword
	public boolean isItemPresentInLocalStorage(String item,JavascriptExecutor jsp) {
		String myitem= !(js.executeScript(String.format(
				"return window.localStorage.getItem('%s');", item)) == null);
		System.out.println("item= " + myitem)
		return myitem
	}
	@Keyword
	public String getItemFromLocalStorage(String key,JavascriptExecutor jsp ) {
		String item= (String) jsp.executeScript(String.format(
				"return window.localStorage.getItem('%s');", key));
		System.out.println("item= " + item)
		return item

	}
	@Keyword
	public String getKeyFromLocalStorage(int key,JavascriptExecutor jsp) {
		String mykey =  (String) jsp.executeScript(String.format(
				"return window.localStorage.key('%s');", key));
		System.out.println("key= " + mykey)
		return mykey
	}
	@Keyword
	public Long getLocalStorageLength(JavascriptExecutor jsp) {
		long localStoragelenght=  (Long) js.executeScript("return window.localStorage.length;");
		System.out.println(localStoragelenght)
		return localStoragelenght
	}
	@Keyword
	public void setItemInLocalStorage(String item, String value,JavascriptExecutor jsp) {
		js.executeScript(String.format(
				"window.localStorage.setItem('%s','%s');", item, value));
	}
	@Keyword
	public void clearLocalStorage(JavascriptExecutor jsp) {
		js.executeScript(String.format("window.localStorage.clear();"));
	}
	@Keyword
	public String randomString(int len){
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@&!:=%*-_?+#";
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder( len );
		for( int i = 0; i < len; i++ )
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}
	@Keyword
	public void ClosedTabExceptFirstOne(){
		String originalHandle = driver.getWindowHandle();

		//Do something to open new tabs

		for(String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}

		driver.switchTo().window(originalHandle);
	}
	@Keyword
	ArrayList<String> removeDuplicates(ArrayList<String> list) {

		//Store unique items in result.
		ArrayList<String> result = new ArrayList<>();

		// Record encountered Strings in HashSet.
		HashSet<String> set = new HashSet<>();

		// Loop over argument list.
		for (String item : list) {

			// If String is not in set, add it to the list and the set.
			if (!set.contains(item)) {
				result.add(item);
				set.add(item);
			}
		}
		return result;
	}
	@Keyword
	public void CountItemsInDropDownList(String id,WebDriver mydriver){
		//Assign and Select the dropdown list element
		Select selectDropdown = new Select(mydriver.findElement(By.id(id)));

		//Get all the option from dropdown list and assign into List
		List<WebElement> listOptionDropdown = selectDropdown.getOptions();

		//Count the item dropdown list and assign into integer variable
		int dropdownCount = listOptionDropdown.size();

		//Print the total count of dropdown list using integer variable
		System.out.println("Total Number of item count in dropdown list = "  + dropdownCount);
	}
	@Keyword
	ArrayList<String> DiffBetweenTwolist(ArrayList<String> listAPI , ArrayList<String> listFront)
	{
		List  toReturn = new ArrayList(listAPI);
		toReturn.removeAll(listFront);
		return toReturn;
	}
	@Keyword
	public boolean retryingFindClick(By by) {
		boolean result = false;
		int attempts = 0;
		while(attempts < 2) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch(Exception e) {
			}
			attempts++;
		}
		return result;
	}
	@Keyword
	public String CheckJson(String Body , String item)
	{

		JSONObject jspp = new JSONObject(Body)
		org.json.JSONArray ar = jspp.getJSONArray("items")
		HashMap<String, String> HashMapById = new HashMap<String, String>();
		Iterator<Object> iterator = ar.iterator();

		for(int i=0;i<ar.length();i++){
			JSONObject jsonObject =  ar.getJSONObject(i)

			for(String key : jsonObject.keys()){
				System.out.println(key + ":" + jsonObject.get(key));
				HashMapById.put(key, jsonObject.get(key));}

			String Hash = HashMapById.toString()

			if(Hash == GlobalVariable.HashMapExpected){
				println("Expected Body correspond to API Body Response")}
			else{println("Check your response !!! ")}

		}
		return HashMapById.toString()
	}


	@Keyword
	boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false
		'Creating an object for File and passing the download Path as argument'
		File dir = new File(downloadPath)
		println(dir)
		'Creating an Array where it will store all the files from that folder'
		File[] dir_contents = dir.listFiles()
		println(dir_contents)

		println('Total Files Available in the folder are : ' + dir_contents.length)
		'Iterating a loop for number of files available in the folder to verify file name in the folder'
		for (int i = 0; i < dir_contents.length; i++) {
			println('File Name at '+ i + ' is : ' + dir_contents[i].getName())
			'Verifying the file name is available in the folder '
			if (dir_contents[i].getName().equals(fileName)) {
				'If the file is found then it will return a value as true'
				dir_contents[i].delete()
				return flag = true
			}
		}
		'If the file is found then it will return a value as false'
		return flag
	}

}


