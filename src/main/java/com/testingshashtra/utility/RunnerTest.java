package com.testingshashtra.utility;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/resources/Features", 
glue ="com.testingshashtra.stepdefination",
tags="@Smoke")
//glue ="src.main.java.com.testingshashtra.stepdefination")
public class RunnerTest extends AbstractTestNGCucumberTests  {



}
