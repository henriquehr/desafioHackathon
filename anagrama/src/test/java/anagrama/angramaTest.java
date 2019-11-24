package anagrama;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class angramaTest {
	
	@Test
	public void when_isArgsValid_receivesValidArg_shouldReturnTrue() {
		boolean isValid;
		String[] args = {"word"};
		
		isValid = anagrama.isArgsValid(args);
		assertTrue(isValid);
	}
	
	@Test
	public void when_isArgsValid_receivesEmptyArg_shouldReturnFalse() {
		String[] args = new String[0];
		boolean isValid;
		
		isValid = anagrama.isArgsValid(args);
		assertFalse(isValid);
	}
	
	@Test
	public void when_isArgsValid_receivesMoreThanOneArg_shouldReturnFalse() {
		String[] args = {" ", " "};
		boolean isValid;
		
		isValid = anagrama.isArgsValid(args);
		assertFalse(isValid);
	}
	
	@Test
	public void when_isInputValid_receivesValidParam_shouldReturnTrue() {
		boolean isValid;
		
		isValid = anagrama.isStringValid("ABC");
		assertTrue(isValid);
	}
	
	@Test
	public void when_isInputValid_receivesOnlySpaces_shouldReturnFalse() {
		boolean isValid;
		
		isValid = anagrama.isStringValid(" ");
		assertFalse(isValid);
		
		isValid = anagrama.isStringValid(" 	");
		assertFalse(isValid);
	}
	
	@Test
	public void when_isInputValid_receivesParamWithSpaces_shouldReturnTrue() {
		boolean isValid;
		
		isValid = anagrama.isStringValid(" A");
		assertTrue(isValid);
		
		isValid = anagrama.isStringValid(" A	");
		assertTrue(isValid);
	}

	@Test
	public void when_isInputValid_receivesEmptyParam_shouldReturnFalse() {
		boolean isValid;
		
		isValid = anagrama.isStringValid("");
		assertFalse(isValid);
	}
	
	@Test
	public void when_isInputValid_receivesNotCharacterParam_shouldReturnFalse() {
		boolean isValid;
		
		isValid = anagrama.isStringValid("ABC1DE");
		assertFalse(isValid);
		
		isValid = anagrama.isStringValid("á");
		assertFalse(isValid);
		
		isValid = anagrama.isStringValid("!");
		assertFalse(isValid);
		
		isValid = anagrama.isStringValid("2");
		assertFalse(isValid);
		
		isValid = anagrama.isStringValid("ABC.DEF");
		assertFalse(isValid);
	}
	
	@Test
	public void when_isInputValid_receivesNullParam_shouldReturnFalse() {
		boolean isValid;
		
		isValid = anagrama.isStringValid(null);
		assertFalse(isValid);
	}
	
	@Test
	public void when_makeStringReady_receivesValidParam_shouldReturnParamCleanAndSorted() {
		String input;
		String actual;
		String expected;
		
		input = "ebCaD";
		expected = "ABCDE";
		actual = anagrama.makeStringReady(input);
		assertEquals(expected, actual);
	}
	
	@Test
	public void when_makeStringReady_receivesEmptyParam_shouldReturnEmpty() {
		String actual;
		String expected;
		
		actual = anagrama.makeStringReady("");
		expected = "";
		assertEquals(expected, actual);
	}
	
	@Test
	public void when_makeStringReady_receivesNullParam_shouldReturnEmpty() {
		String actual;
		String expected;
		
		actual = anagrama.makeStringReady(null);
		expected = "";
		assertEquals(expected, actual);
	}
	
	@Test
	public void when_cleanString_receivesValidParam_shouldReturnUppercaseParamWithNoSpace() {
		String actual;
		String expected;
		
		actual = anagrama.cleanString("abCdeFg");
		expected = "ABCDEFG";
		assertEquals(expected, actual);
	}
	
	@Test
	public void when_cleanString_receivesParamWithMultipleSpaces_shouldReturnUppercaseParamWithNoSpace() {
		String actual;
		String expected;
		
		actual = anagrama.cleanString("a  b C         de	F		g");
		expected = "ABCDEFG";
		assertEquals(expected, actual);
	}
		
	@Test
	public void when_cleanString_receivesParamWithSpace_shouldReturnEmpty() {
		String actual;
		String expected;
		
		actual = anagrama.cleanString(" ");
		expected = "";
		assertEquals(expected, actual);
	}
	
	@Test
	public void when_cleanString_receivesEmptyParam_shouldReturnEmpty() {
		String actual;
		String expected;
		
		actual = anagrama.cleanString("");
		expected = "";
		assertEquals(expected, actual);
	}
	
	@Test
	public void when_cleanString_receivesNullParam_shouldReturnEmpty() {
		String actual;
		String expected;
		
		actual = anagrama.cleanString(null);
		expected = "";
		assertEquals(expected, actual);;
	}
	
	@Test
	public void when_sortString_receivesValidParam_shouldReturnParamSorted() {
		String actual;
		String expected;
		
		actual = anagrama.sortString("FAEDBC");
		expected = "ABCDEF";
		
		assertEquals(expected, actual);
	}

	@Test
	public void when_sortString_receivesEmptyParam_shouldReturnEmpty() {
		String actual;
		String expected;
		
		actual = anagrama.sortString("");
		expected = "";
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void when_sortString_receivesNullParam_shouldReturnEmpty() {
		String actual;
		String expected;
		
		actual = anagrama.sortString(null);
		expected = "";
		
		assertEquals(expected, actual);
	}
		
}
