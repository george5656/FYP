package modelTest;

import static org.junit.Assert.*;

import org.junit.Test;

import model.WritableDatabase;

public class WritableDatabaseTest {
private WritableDatabase testingClass = new WritableDatabase();
	@Test
	public void validUserNameAndInput() {
		assertTrue(testingClass.passwordAndUsernameAreValid("Test", "Test"));
	}
	@Test
	public void usernameAndPasswordAllInvalid() {
		assertFalse(testingClass.passwordAndUsernameAreValid("Hello", "There"));
	}
	@Test
	public void passwordAndUsernameDontMatchButBothExists() {
		assertFalse(testingClass.passwordAndUsernameAreValid("Test", "Demo"));
	}
}
