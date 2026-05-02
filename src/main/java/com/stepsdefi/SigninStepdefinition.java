package com.stepsdefi;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hooks.Hooks;
import com.pages.SignIn;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SigninStepdefinition extends BaseClass {

    SignIn objutil;

    public SigninStepdefinition() throws IOException {
        objutil = new SignIn();
    }


	
	@Given("user is on Registration login page")
	public void user_launch_browser()
	{
		launchBrowser();
	}
	
	@When("user enters valid credentials")
	public void Enter_valid_Credentials()
	{
		objutil.ValidCredentials();
		
	}
	
	@And("clicks on the Login button")
	public void clicks_onthe_Login_button()
	{
		
		System.out.println("DONE");
		objutil.clickLogin();
	}
	

	@And("clicks on the Office Loggin button")
	public void clicks_onthe_OfficeLogin_button()
	{
		
		objutil.clickOfficeLogin();
		System.out.println("JKML");
	}
	
	
	
}
	
