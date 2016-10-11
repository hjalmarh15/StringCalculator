package is.ru.stringcalculator;

public class Calculator {
	public static int add(String text) {
		if(text.equals(""))
			return 0;
		else if(text.contains("\n")) {
			String [] newLineSplit = text.split("\n");
			int result = 0	;
			for(String string : newLineSplit ) {
				if(string.contains(",")) {
					String[] numbers = string.split(",");
					result += sum(numbers);
				}
				else {
					result += toInt(string);
				}
			}
			return result;
		}
		else if(text.contains(",")) {
			String[] numbers = text.split(",");
			return sum(numbers);
		}
		else {
			return toInt(text);
		}
	}

	private static int toInt(String text) {
		return Integer.parseInt(text);
	}

	private static int sum(String [] numbers) {
		int result = 0;
		for(String number : numbers) {
			result += toInt(number);
		}
		return result;
	}
}