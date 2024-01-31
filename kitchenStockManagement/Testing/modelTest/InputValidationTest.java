package modelTest;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import model.InputValidation;

public class InputValidationTest {
private InputValidation testingclass = new InputValidation();
private String stringLength50 = new String("01234567890123456789012345678901234567890123456789");
	//string must be present
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
		assertEquals("only a-z and 0-9 allowed",testingclass.stringMustBePresetValidation(new String("MEW")));
	}
	
	@Test
	public void stringValidatioCharInRangeAndWriteTypeString() {
		assertEquals("",testingclass.stringMustBePresetValidation(new String("ditto")));
	}
	@Test
	public void stringValidatioCharInRangeAndWriteTypeStringInt() {
		assertEquals("",testingclass.stringMustBePresetValidation(new String("1234")));
	}
	@Test
	public void stringValidatioKeyWordTest() {
		assertEquals("a key word has been inputed and must be removed",testingclass.stringMustBePresetValidation(new String("amount")));
	}
	

	// string present is optional
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
	
	// int present is optional
	@Test
	public void intValidationMaxBoundary() {
		assertEquals("", testingclass.intPresentIsOptionalValidation(stringLength50));
	}
	@Test
	public void intValidationMaxBoundaryPlusOne() {
		assertEquals("user input has to many characters", testingclass.intPresentIsOptionalValidation(stringLength50 + "0"));
	}
	@Test
	public void intValidationMaxBoundaryMinusOne() {
		assertEquals("",testingclass.intPresentIsOptionalValidation((stringLength50.substring(1))));
	}
	@Test
	public void intValidationNotAcceptedChar() {
		assertEquals("only characters between 0-9 allowed", testingclass.intPresentIsOptionalValidation("hello world"));	
	}
	@Test
	public void intValidationNormalAccaptedInput() {
		assertEquals("", testingclass.intPresentIsOptionalValidation("215"));
	}
	@Test
	public void intValidationNoInput() {
		assertEquals("", testingclass.intPresentIsOptionalValidation(new String("")));
	}
	// int present is not optional
	@Test
	public void intValidationNotOptionalMaxBoundary() {
		assertEquals("", testingclass.intMustBePresetValidation(stringLength50));
	}
	@Test
	public void intValidationNotOptionalMaxBoundaryPlusOne() {
		assertEquals("user input has to many characters", testingclass.intMustBePresetValidation(stringLength50 + "0"));
	}
	@Test
	public void intValidationNotOptionalMaxBoundaryMinusOne() {
		assertEquals("",testingclass.intMustBePresetValidation((stringLength50.substring(1))));
	}
	@Test
	public void intValidationNotOptionalNotAcceptedChar() {
		assertEquals("only characters between 0-9 allowed", testingclass.intMustBePresetValidation("hello world"));	
	}
	@Test
	public void intValidationNotOptionalNormalAccaptedInput() {
		assertEquals("", testingclass.intMustBePresetValidation("215"));
	}
	@Test
	public void intValidationNotOptionalMinBoundary() {
		assertEquals("no input", testingclass.intMustBePresetValidation(new String("")));
	}
	@Test
	public void intValidationNotOptionalMinBoundaryPlusOne() {
		assertEquals("", testingclass.intMustBePresetValidation(new String("1")));
	}
	// double present is poptional
	@Test
	public void doubleValidationMaxBoundary() {
		assertEquals("", testingclass.doublePresentIsOptionalValidation(stringLength50));
	}
	@Test
	public void doubleValidationMaxBoundaryPlusOne() {
		assertEquals("user input has to many characters", testingclass.doublePresentIsOptionalValidation(stringLength50+1));
	}
	@Test
	public void doubleValidationMaxBoundaryMinusOne() {
		assertEquals("", testingclass.doublePresentIsOptionalValidation(stringLength50.substring(1)));
	}
	@Test
	public void doubleValidationNoInput() {
		assertEquals("",testingclass.doublePresentIsOptionalValidation(new String("")));
	}
	@Test
	public void doubleValidationNormalInputWithDecimal2DecmailPlace() {
		assertEquals("",testingclass.doublePresentIsOptionalValidation(new String("25.00")));
	}
	@Test
	public void doubleValidationInputWithDecimal3DecmailPlace() {
		assertEquals("only 2 decmal place allowed",testingclass.doublePresentIsOptionalValidation(new String("25.000")));
	}
	@Test
	public void doubleValidationNormalInputWithNoDecimalPlaces() {
		assertEquals("",testingclass.doublePresentIsOptionalValidation(new String("25")));
	}
	@Test
	public void doubleValidationWithInvalidCharcaters() {
		assertEquals("only 0-9 and \'.\' characters allowed",testingclass.doublePresentIsOptionalValidation(new String("bulbasaur")));
	}
	// double present is not optional 
	@Test
	public void doubleValidationNotOptionalMaxBoundary() {
		assertEquals("", testingclass.doubleMustBePresetValidation(stringLength50));
	}
	@Test
	public void doubleValidationNotOptionalMaxBoundaryPlusOne() {
		assertEquals("user input has to many characters", testingclass.doubleMustBePresetValidation(stringLength50+1));
	}
	@Test
	public void doubleValidationNotOptionalMaxBoundaryMinusOne() {
		assertEquals("", testingclass.doubleMustBePresetValidation(stringLength50.substring(1)));
	}
	@Test
	public void doubleValidationNotOptionalMinInputMinusOne() {
		assertEquals("no input",testingclass.doubleMustBePresetValidation(new String("")));
	}
	@Test
	public void doubleValidationNotOptionalMinInput() {
		assertEquals("",testingclass.doubleMustBePresetValidation(new String("1")));
	}
	@Test
	public void doubleValidationNotOptionalMinInputPlusOne() {
		assertEquals("",testingclass.doubleMustBePresetValidation(new String("11")));
	}
	@Test
	public void doubleValidationNotOptionalNormalInputWithDecimal2DecmailPlace() {
		assertEquals("",testingclass.doubleMustBePresetValidation(new String("25.00")));
	}
	@Test
	public void doubleValidationNotOptionalInputWithDecimal3DecmailPlace() {
		assertEquals("only 2 decmal place allowed",testingclass.doubleMustBePresetValidation(new String("25.000")));
	}
	@Test
	public void doubleValidationNotOptionalNormalInputWithNoDecimalPlaces() {
		assertEquals("",testingclass.doubleMustBePresetValidation(new String("25")));
	}
	@Test
	public void doubleValidationNotOptionalWithInvalidCharcaters() {
		assertEquals("only 0-9 and \'.\' characters allowed",testingclass.doubleMustBePresetValidation(new String("bulbasaur")));
	}
	// date validation test
	@Test
	public void dateValidationNoInput () {
		assertEquals("", testingclass.dateValidationPresentIsOptional("", null));
	}
	@Test
	public void dateValidationNormalInput () {
		assertEquals("", testingclass.dateValidationPresentIsOptional("01/01/2024", LocalDate.EPOCH));
	}
	@Test
	public void dateValidationUserNotClickedEntere () {
		assertEquals("no data found, if some does exists try selecting it and preesing enter", testingclass.dateValidationPresentIsOptional("01/01/2024", null));
	}
	//data validation not optional
	@Test
	public void dateValidationNotOptionalNoInput () {
		assertEquals("error no date", testingclass.dateValidation("", null));
	}
	@Test
	public void dateValidationNotOptionalNormalInput () {
		assertEquals("", testingclass.dateValidation("01/01/2024", LocalDate.EPOCH));
	}
	@Test
	public void dateValidationNotOptionalUserNotClickedEntere () {
		assertEquals("no data found, if some does exists try selecting it and preesing enter", testingclass.dateValidation("01/01/2024", null));
	}
	
	
	
}
