package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "resources/Scenarios",
    glue = {"com.stepsdefi"},
    plugin = {"pretty","html:target/cucumber-report.html"},
    monochrome = true,
    dryRun = false
)

public class TestRunner extends AbstractTestNGCucumberTests {

}