package is.ru.stringcalculator;

public class Calculator {
	public static int add(String text) {
		if(text.equals(""))
			return 0;
		else if(text.contains("\n")) {
			String [] newLineSplit = text.split("\n");
			return sum(newLineSplit, "\n");
		}
		else if(text.contains(",")) {
			String[] numbers = text.split(",");
			return sum(numbers, ",");
		}
		else {
			return toInt(text);
		}
	}

	private static int toInt(String text) {
		return Integer.parseInt(text);
	}

	private static int sum(String [] numbers, String delimiter) {
		int result = 0;

		if(delimiter.equals("\n")) {
			for(String string : numbers ) {
				if(string.contains(",")) {
					String[] moreNumbers = string.split(",");
					result += sum(moreNumbers, ",");
				}
				else {
					result += toInt(string);
				}
			}
		}
		else if(delimiter.equals(",")) {
			for(String number : numbers) {
				result += toInt(number);
			}
		}

		return result;
	}
}