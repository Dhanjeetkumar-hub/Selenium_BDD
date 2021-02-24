package rough;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	private static WebDriver driver=null;
	static HttpURLConnection con=null;
	public static void main(String[] args) {
		String homeURL="https://www.zlti.com";
		String url="";
		int respCode=200;
		
		System.setProperty("webdriver.chrome.driver", "/home/jeet/Downloads/chromedriver");
		driver=new ChromeDriver();
        driver.get(homeURL);
        List<WebElement> link=driver.findElements(By.tagName("a"));
        Iterator<WebElement> it=link.iterator();
        while(it.hasNext()) {
        	url=it.next().getAttribute("href");
        	if(url==null||url.isEmpty()) {
        		System.out.println("url tag is not configured or url is empty");
        		continue;
        	}
        	if(!url.startsWith(homeURL)) {
        		System.out.println("url belongs to another domain,skipping it");
        		continue;
        	}
        	try {
        		con=(HttpURLConnection)(new URL(url)).openConnection();
        		con.setRequestMethod("HEAD");
        		con.connect();
        		respCode=con.getResponseCode();
        		if(respCode>=400) {
        			System.out.println(url+" is not a valid url");
        		}
        		else {
        			System.out.println(url+" is a valid url");
        		}
        	}
        	catch(MalformedURLException e) {
        		e.printStackTrace();
        	}
        	catch(IOException e) {
        		e.printStackTrace();
        		
        	}
        }
        
	}

}
