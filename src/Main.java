import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
//        input = input.trim()
//                .replaceAll("\\n+", "")
//                .replaceAll("\\t+", "")
//                .replaceAll("\\s+", "");

        int greatestNumber = Integer.valueOf(input);

        if ((greatestNumber > -10) && (greatestNumber < 10)) {
            throw new IllegalArgumentException();
        }

        String sOnlyNumbers = input;
        if (greatestNumber < 0) {
            sOnlyNumbers = input.substring(1);
        }

        for (int i = 0; i < sOnlyNumbers.length() - 1; i++) {
            for (int j = i + 1; j < sOnlyNumbers.length(); j++) {
                String result = sOnlyNumbers.substring(0, i) + Character.toString(sOnlyNumbers.charAt(j))
                        + sOnlyNumbers.substring(i + 1, j) + Character.toString(sOnlyNumbers.charAt(i))
                        + sOnlyNumbers.substring(j + 1);
                if (result.charAt(0) != '0') {
                    if (input.charAt(0) == '-') {
                        result = '-' + result;
                    }
                    int number = Integer.valueOf(result);
                    greatestNumber = Math.max(number, greatestNumber);
                }
            }
        }

        System.out.println(greatestNumber);
    }
}
