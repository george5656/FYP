package modelTest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.InputValidation;

public class InputValidationTest {
private InputValidation testingclass = new InputValidation();
private String stringLength50 = new String("01234567890123456789012345678901234567890123456789");

	@Test
	public void stringValidationMinBoundary() {
		assertEquals("no input",testingclass.stringMustBePresetValidation(new String("")));
	}
	@Test
	public void stringValidationMinBoundaryPlusOne() {
		assertEquals("",testingclass.stringMustBePresetValidation(new String(" ")));
	}
	@Test
	public void stringValidationMaxBoundary() {
		assertEquals("",testingclass.stringMustBePresetValidation(stringLength50));
	}
	@Test
	public void stringValidationMaxBoundaryPlusOne() {
		assertEquals("user input to big",testingclass.stringMustBePresetValidation(stringLength50+"1"));
	}
	@Test
	public void stringValidationMaxBoundaryMinusOne() {
		assertEquals("",testingclass.stringMustBePresetValidation(stringLength50.substring(1)));
	}
	@Test
	public void stringValidatioCharWrongType() {
		assertEquals("only a-z and A-Z",testingclass.stringMustBePresetValidation(new String("@@@")));
	}
	@Test
	public void stringValidatioCharInRangeAndWriteTypeString() {
		assertEquals("",testingclass.stringMustBePresetValidation(new String("Hello")));
	}@Test
	public void stringValidatioCharInRangeAndWriteTypeStringInt() {
		assertEquals("",testingclass.stringMustBePresetValidation(new String("1234")));
	}
}
