package com.brianc.testRepo;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class GrabBagTests extends TestCase {

	TestProgram tp = null;

	public GrabBagTests(String name) {
		super(name);
	}

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		 tp = new TestProgram();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testCase1() throws Exception {
		
		String sentence = tp.joinWords( "I", "hope", "I", "get", "this", "job!");
		
		Assert.assertEquals( "I hope I get this job!", sentence);
	}

	@Test
	public void testCase2() throws Exception {
//		TestProgram tp = new TestProgram();
		
		String sentence = tp.stringJoinReduce( "I", "hope", "I", "get", "this", "job!");
		
		Assert.assertEquals( "I hope I get this job!", sentence);
	}

	@Test
	public void testCase3() throws Exception {
//		TestProgram tp = new TestProgram();
		
		String sentence = tp.collectorsJoiningWords( Arrays.asList( "I", "hope", "I", "get", "this", "job!" ));
		
		Assert.assertEquals( "I hope I get this job!", sentence);
	}

}
