package com.samdlc.jini.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.samdlc.jini.IProperty;
import com.samdlc.jini.PropertyImpl;

public class PropertyImplTest {

	@Test
	public void testPropertyImpl() {
		// Test basic valid arguments
		IProperty prop = new PropertyImpl("prop1", "test");
	}
	
	@Test
	public void testNullNamePropertyImpl() {
		try {
			IProperty prop = new PropertyImpl(null, "aVal");
		} catch(IllegalArgumentException e) {
			return;
		}
		fail("null name should throw exception");
	}
	
	@Test
	public void testEmptyNamePropertyImpl() {
		try {
			IProperty prop = new PropertyImpl("", "aVal");
		} catch(IllegalArgumentException e) {
			return;
		}
		fail("empty name should throw exception");
	}
	
	@Test
	public void testWhitespaceNamePropertyImpl() {
		try {
			IProperty prop = new PropertyImpl("   ", "aVal");
		} catch(IllegalArgumentException e) {
			return;
		}
		fail("whitespace name should throw exception");
	}
	
	@Test
	public void testNullValuePropertyImpl() {
		IProperty prop = new PropertyImpl("prop", null);
		assertTrue("Value did not return an empty string", "".equals(prop.getValue()));
	}
	
	@Test
	public void testEmptyValuePropertyImpl() {
		IProperty prop = new PropertyImpl("prop", "");
		assertTrue("Value did not return an empty string", "".equals(prop.getValue()));
	}

	@Test
	public void testGetName() {
		IProperty prop = new PropertyImpl("prop", "value");
		assertTrue("Name did not match expected value of 'prop'", "prop".equals(prop.getName()));
	}
	
	@Test
	public void testGetNameCaseInsensitive() {
		IProperty prop = new PropertyImpl("PrOp", "VaL");
		assertTrue("Failed case insensitivity test", "prop".equals(prop.getName()));
	}

	@Test
	public void testGetValue() {
		IProperty prop = new PropertyImpl("prop", "value");
		assertTrue("Value did not match expected value of 'value'", "value".equals(prop.getValue()));
	}
	
	@Test
	public void testGetValueCaseInsensitive() {
		IProperty prop = new PropertyImpl("prop", "value");
		assertTrue("Value did not match expected value of 'value'", "prop".equals(prop.getName()));
	}

}
