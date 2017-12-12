package com.sahabt.automation.testmasters;

import org.junit.Test;
import org.junit.Assert;

public class AppTest {

	@Test
	public void Test2() {
		int x = 2;
		double y = 2.0;
		Assert.assertEquals(x, y, 0.0);
	}

	public void Test1() {
		String karsilamaMesaji = "Merhaba Melih";
		Assert.assertTrue("karsilama mesaji hatali", karsilamaMesaji.contains("Merhaba"));
	}

	public void bolmeTesti() {
		Assert.assertEquals(bolme(4, 2), 2, 0.0);
		Assert.assertEquals(bolme(4, 0), -1, 0.0);
	}

	public double bolme(double bolen, double bolunen) {
		if (bolen == 0)
			return -1;
		else
			return bolen / bolunen;
	}

}
