package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class dependencymethods {
	
	@Test(priority=1)
	void openapp() {
		System.out.println("Openapp is open successfully");
		Assert.assertTrue(false);
	}
	
	@Test(priority=2, dependsOnMethods= {"openapp"})
	void login() {
		Assert.assertTrue(false);
		System.out.println("Login is open successfully");
	}
	
	@Test(priority=3, dependsOnMethods= {"login"})
	void search() {
		System.out.println("Search is open successfully");
	}
	
	@Test(priority=4)
	void logout() {
		System.out.println("logout is open successfully");
	}
}
