package modelTest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.InputValidation;

public class InputValidationTest {
private InputValidation testingclass = new InputValidation();
private String stringLength50 = new String("01234567890123456789012345678901234567890123456789");

	@Test
	public void stringValidationMinBoundary() {
		assertEquals("no input",testingclass.stringValidation(new String("")));
	}
	@Test
	public void stringValidationMinBoundaryPlusOne() {
		assertEquals("",testingclass.stringValidation(new String(" ")));
	}
	@Test
	public void stringValidationMaxBoundary() {
		assertEquals("",testingclass.stringValidation(stringLength50));
	}
	@Test
	public void stringValidationMaxBoundaryPlusOne() {
		assertEquals("user input to big",testingclass.stringValidation(stringLength50+"1"));
	}
	@Test
	public void stringValidationMaxBoundaryMinusOne() {
		assertEquals("",testingclass.stringValidation(stringLength50.substring(1)));
	}
	@Test
	public void stringValidatioCharWrongType() {
		assertEquals("only a-z and A-Z",testingclass.stringValidation(new String("@@@")));
	}
	@Test
	public void stringValidatioCharInRangeAndWriteTypeString() {
		assertEquals("",testingclass.stringValidation(new String("Hello")));
	}@Test
	public void stringValidatioCharInRangeAndWriteTypeStringInt() {
		assertEquals("",testingclass.stringValidation(new String("1234")));
	}
}
