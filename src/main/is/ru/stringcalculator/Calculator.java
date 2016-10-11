package is.ru.stringcalculator;

public class Calculator {
	public static int add(String text) {
		if(text.equals(""))
			return 0;
		else if(text.contains(",")) {
			String[] numbers = text.split(",");
			int result = 0;
			for(String number : numbers) {
				result += toInt(number);
			}
			return result;
		}
		else {
			return 1;
		}
	}

	private static int toInt(String text) {
		return Integer.parseInt(text);
	}
}