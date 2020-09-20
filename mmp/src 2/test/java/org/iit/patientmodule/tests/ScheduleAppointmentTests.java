package org.iit.patientmodule.tests;

import java.util.HashMap;

import org.iit.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.iit.util.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class ScheduleAppointmentTests extends BaseClass {
	
	@Test
	public void validateScheduleAppointment() throws InterruptedException
	{
		 
		 SoftAssert sa = new SoftAssert();
		 login();
		 ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		 HashMap<String,String> hMap = sPage.bookAppointment("Sophia Rich");
		 boolean result=			   sPage.validateAppointmentDetailsinHomePage(hMap);
		 sa.assertTrue(result);
		 result = sPage.validateAppointmentDetailsinSPage(hMap);
		 sa.assertTrue(result);
		 sa.assertAll();
	}
	public void login()
	{
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
	}
	

}
