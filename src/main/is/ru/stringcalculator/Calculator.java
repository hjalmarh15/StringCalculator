package is.ru.stringcalculator;

public class Calculator {
	public static int add(String text) {
		if(text.equals(""))
			return 0;
		String withoutDelimiterLine = text;
		String delimiter = ",|\n";
		if(text.startsWith("//")) {
			int index = text.indexOf("//") + 2;
			delimiter = text.substring(index, index + 1) + "|\n";
			withoutDelimiterLine = text.substring(text.indexOf("\n")+1);
		}
		String [] numbers = withoutDelimiterLine.split(delimiter);
		checkNegatives(numbers);
		return sum(numbers);
	}

	private static int toInt(String text) {
		return Integer.parseInt(text);
	}

	private static int sum(String [] numbers) {
		int result = 0;
		for(String number : numbers) {
			if(toInt(number) < 1001)
				result += toInt(number);
		}
		return result;
	}

	private static void checkNegatives(String[] numbers) {
		String negatives = "";
		for(String number : numbers) {
			if(toInt(number) < 0) 
				 negatives += number + ", ";
		}
		if (!negatives.equals(""))
			throw new IllegalArgumentException("Negatives not allowed: " + negatives);
	}
}
