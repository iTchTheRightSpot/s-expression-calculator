import java.util.regex.Pattern;

public class ExpressionCalculator {
    enum Constant {
        MULTIPLY, ADD, EXPONENT;
    }
    public ExpressionCalculator() {}

    /*
    * Takes input from the user to perform calculation
    *
    * @param string
    * @return Integer
    * */
    public long evaluate(String str) {
        String input = checkForLeadingSpaces(str).trim();
        if (input.length() == 0) { // Base case
            return 0L;
        }

        // Checks if user input is starts with an opening bracket or not
        return str.charAt(0) == '(' ? firstCharParentheses(input) : noParentheses(str);
    }

    /*
    * Validates user input to remove leading empty spaces
    *
    * @param String
    * @return String
    * */
    private String checkForLeadingSpaces(String str) {
        return str.replaceFirst("^\\s+", "");
    }

    /*
    * Method validates if string is a valid number
    *
    * @param String
    * @return boolean
    * */
    private boolean validateStringIsAnInteger(String str) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (str == null || str.length() == 0) {
            return false;
        }
        return pattern.matcher(str).matches();
    }

    /*
    * This method in the bulk of the calculation
    * It breaks down strings to chucks to help with calculation
    *
    * @param String
    * @return Integer
    * */
    private long firstCharParentheses(String str) {
        StringBuilder sb = new StringBuilder(str);
        String subString;

        while (sb.length() != 1 && !validateStringIsAnInteger(sb.toString())) {
            int close = 0;

            // Get innermost closing bracket
            while (sb.charAt(close) != ')') {
                close++;
            }

            // Get open bracket of innermost bracket
            int open = close;
            while (sb.charAt(open) != '(') {
                open--;
            }

            close = close + 1;

            subString = sb.substring(open, close);
            sb.replace(open, close, calculateString(subString));
        }

        return Long.parseLong(sb.toString());
    }

    private long noParentheses(String str) {
        if (Character.isDigit(str.charAt(0))) {
            return Integer.parseInt(str);
        }
        String[] arr = str.split("\\s+");

        String operator = arr[0];
        long res = Long.parseLong(arr[1]);
        for (int i = 2; i < arr.length; i++) {
            if (operator.equals(Constant.ADD.toString().toLowerCase())) {
                res += Long.parseLong(arr[i]);
            } else if (operator.equals(Constant.MULTIPLY.toString().toLowerCase())){
                res *= Long.parseLong(arr[i]);
            }
        }

        return res;
    }

    /*
    * Method calculates string
    * E.g (multiply 2 3) -> 2 * 3 = 6
    *
    * @param String
    * @return String
    * */
    private String calculateString(String str) {
        String res = "";
        String string = str.substring(1, str.length() - 1);
        String[] arr = string.split("\\s+");

        switch (arr[0]) {
            case "add" -> {
                long addition = 0;
                for (int i = 1; i < arr.length; i++) {
                    addition += Long.parseLong(arr[i]);
                }
                res = String.valueOf(addition);
            }
            case "multiply" -> {
                long addition = 1;
                for (int i = 1; i < arr.length; i++) {
                    addition *= Long.parseLong(arr[i]);
                }
                res = String.valueOf(addition);
            }
            case "exponent" -> {
                long first = Integer.parseInt(arr[1]);
                long pow = Integer.parseInt(arr[2]);
                long calc = (long) Math.pow(first, pow);
                res = String.valueOf(calc);
            }
        }

        return res;
    }


}
