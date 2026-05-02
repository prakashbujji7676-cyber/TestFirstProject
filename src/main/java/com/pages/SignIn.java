package com.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import base.BaseClass;

public class SignIn extends BaseClass {
	
	Properties prop = new Properties();

	public SignIn() throws IOException
	{
		// Prefer loading the locator file from the classpath (works in packaged/test runs).
		// Fallback to a relative 'resources' folder based on user.dir when classpath lookup fails.
		InputStream is = getClass().getClassLoader().getResourceAsStream("common/web/webpagelocators.loc");
		if (is != null) {
			try (InputStream in = is) {
				prop.load(in);
				return;
			}
		}

		// Fallback: try a relative path under the working directory (e.g., when running from IDE)
		String fallbackPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "common" + File.separator + "web" + File.separator + "webpagelocators.loc";
		FileInputStream file = new FileInputStream(fallbackPath);
		try (FileInputStream fin = file) {
			prop.load(fin);
		}
	}
	
	public void ValidCredentials() {
		System.out.println("Login data entered");
	}

	public void clickLogin()
	{
		WebElement el = driver.findElement(By.xpath(prop.getProperty("LoginBtn")));
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(el));
			el.click();
		} catch (Exception e) {
			// Fallback: scroll into view and click via JS if normal click fails
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
		}
		
	}
	
	public void clickOfficeLogin()
	{
		WebElement el = driver.findElement(By.xpath(prop.getProperty("OfficeLoginBtn")));
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(el));
			el.click();
		} catch (Exception e) {
			// Fallbacks: try scrolling into view and JS click
			try {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
			} catch (Exception ex) {
				// As a last resort, rethrow the original exception to surface the failure
				throw e;
			}
		}
	}
}