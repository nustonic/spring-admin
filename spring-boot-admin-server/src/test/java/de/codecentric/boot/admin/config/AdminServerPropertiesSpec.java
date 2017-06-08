package de.codecentric.boot.admin.config;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdminServerPropertiesSpec {
	@Test(expected = IllegalArgumentException.class)
	public void setContextPathSingleSlash() {
		new AdminServerProperties().setContextPath("/");
	}

	@Test(expected = IllegalArgumentException.class)
	public void setContextPathDoubleSlash() {
		new AdminServerProperties().setContextPath("/test/");
	}

	@Test(expected = IllegalArgumentException.class)
	public void setContextPathNoBeginSlash() {
		new AdminServerProperties().setContextPath("test/");
	}

	@Test
	public void setContextPathHappyPath() {
		AdminServerProperties adminServerProperties = new AdminServerProperties();
		adminServerProperties.setContextPath("/test");
		assertTrue(adminServerProperties.getContextPath().equalsIgnoreCase("/test"));
	}

	@Test
	public void setEndpoints(){
		String[] endpoints = {"one", "two"};
		AdminServerProperties adminServerProperties = new AdminServerProperties();
		adminServerProperties.getRoutes().setEndpoints(endpoints);
		assertFalse(adminServerProperties.getRoutes().getEndpoints().equals(endpoints));
		assertTrue(Arrays.equals(adminServerProperties.getRoutes().getEndpoints(), endpoints));
	}


}