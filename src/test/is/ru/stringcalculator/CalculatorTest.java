package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.Test;


public class CalculatorTest {
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testManyNumbers() {
		assertEquals(10, Calculator.add("1,2,3,4"));
	}

	@Test
	public void testNewLine() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testNewLine2() {
		assertEquals(6, Calculator.add("1,2\n3"));
	}

	@Test
	public void testNewLineWithoutComma() {
		assertEquals(3, Calculator.add("1\n2"));
	}
	@Rule
    public ExpectedException thrown= ExpectedException.none();

	@Test
	public void testNegativeNumber() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Negatives not allowed: -1");
		Calculator.add("-1,2");
	}

	@Test
	public void testAboveThousand() {
		assertEquals(2, Calculator.add("1001,2"));
	}

	@Test
	public void testAboveThousand2() {
		assertEquals(0, Calculator.add("1001,1002,1003"));
	}
}