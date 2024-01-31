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
		assertEquals("only a-z and 0-9 allowed",testingclass.stringMustBePresetValidation(new String("@@@")));
	}
	@Test
	public void stringValidatioCharWrongTypeCaptial() {
		assertEquals("only a-z and 0-9 allowed",testingclass.stringMustBePresetValidation(new String("Hellow")));
	}
	@Test
	public void stringValidatioCharInRangeAndWriteTypeString() {
		assertEquals("",testingclass.stringMustBePresetValidation(new String("hello")));
	}
	@Test
	public void stringValidatioCharInRangeAndWriteTypeStringInt() {
		assertEquals("",testingclass.stringMustBePresetValidation(new String("1234")));
	}
	@Test
	public void stringValidatioKeyWordTest() {
		assertEquals("a key word has been inputed and must be removed",testingclass.stringMustBePresetValidation(new String("amount")));
	}
	

	
	@Test
	public void stringValidationOptionalMinBoundary() {
		assertEquals("",testingclass.stringPresentIsOptionalValidation(new String("")));
	}
	
	@Test
	public void stringValidationOptionalMaxBoundary() {
		assertEquals("",testingclass.stringPresentIsOptionalValidation(stringLength50));
	}
	@Test
	public void stringValidationOptionalMaxBoundaryPlusOne() {
		assertEquals("user input to big",testingclass.stringPresentIsOptionalValidation(stringLength50+"1"));
	}
	@Test
	public void stringValidationOptionalMaxBoundaryMinusOne() {
		assertEquals("",testingclass.stringPresentIsOptionalValidation(stringLength50.substring(1)));
	}
	@Test
	public void stringValidatioOptionalCharWrongType() {
		assertEquals("only a-z and 0-9 allowed",testingclass.stringPresentIsOptionalValidation(new String("@@@")));
	}
	@Test
	public void stringValidatioOptionalCharWrongTypeCaptial() {
		assertEquals("only a-z and 0-9 allowed",testingclass.stringPresentIsOptionalValidation(new String("Hellow")));
	}
	@Test
	public void stringValidatioOptionalCharInRangeAndWriteTypeString() {
		assertEquals("",testingclass.stringPresentIsOptionalValidation(new String("hello")));
	}
	@Test
	public void stringValidatioOptionalCharInRangeAndWriteTypeStringInt() {
		assertEquals("",testingclass.stringPresentIsOptionalValidation(new String("1234")));
	}
	@Test
	public void stringValidatioOptionalKeyWordTest() {
		assertEquals("a key word has been inputed and must be removed",testingclass.stringPresentIsOptionalValidation(new String("amount")));
	}
	
}
