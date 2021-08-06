package com.wangrui.javaadvance.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AserviceTest {

	 private Aservice as = new Aservice();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("init");
//		as = new Aservice();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("destory");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("------new test-------");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("--------end test-------");
	}

	@Test
	public void testAdd() {
//		fail("Not yet implemented");
		
		int result = as.add(1, 2);
		assertEquals(result, 3);
		
	}

	@Test
	public void testFind() {
//		fail("Not yet implemented");
		String r = as.find(1);
//		assertEquals(r, "hello!");
		
		assertNotNull(r);
		
	}

}
