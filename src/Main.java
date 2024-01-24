import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            performCalculations();
        } else if (args.length == 1 && args[0].equals("interactive"))
            executeInteractively();
        else if (args.length == 3)
            handleCommandLine(args);
        else
            System.out.println("Please provide an operation code and 2 numeric values");
    }

    private static void performCalculations() {

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation(MathOperation.DIVIDE, 100.0d, 50.0d);
        equations[1] = new MathEquation(MathOperation.ADD, 25.0d, 92.0d);
        equations[2] = new MathEquation(MathOperation.SUBTRACT, 225.0d, 17.0d);
        equations[3] = new MathEquation(MathOperation.MULTIPLY, 11.0d, 3.0d);
        for (MathEquation equation : equations) {
            equation.execute();
            System.out.println(equation);//println will call toString() method automatically
        }
        System.out.println("Average of result = " + MathEquation.averageOfResults());
        //useOverload();

    }

    private static void useOverload() {
        System.out.println();
        System.out.println("Using execute Overloads");
        System.out.println();
        MathEquation equationOverload = new MathEquation(MathOperation.ADD);
        double lNum = 9;
        double rNum = 4;
        equationOverload.execute(lNum, rNum);
        System.out.println("result for double =" + equationOverload.getResult());
        int llNum = 9;
        int rrNum = 4;
        equationOverload.execute(llNum, rrNum);
        System.out.println("result for double =" + equationOverload.getResult());
    }


    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        MathOperation opCode = MathOperation.valueOf(parts[0].toUpperCase());
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        MathEquation equation = new MathEquation(opCode, leftVal, rightVal);
        System.out.println(equation);
    }


    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);
    }

    static double execute(char opCode, double leftVal, double rightVal) {
        return switch (opCode) {
            case 'a' -> leftVal + rightVal;
            case 's' -> leftVal - rightVal;
            case 'm' -> leftVal * rightVal;
            case 'd' -> rightVal != 0 ? leftVal / rightVal : 0.0d;
            default -> {
                System.out.println("Invalid opCode: " + opCode);
                yield 0.0d;
            }
        };
    }


    static double valueFromWord(String word) {
        String[] numberWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        boolean isSetValue = false;
        double value = 0d;
        for (int index = 0; index < numberWords.length; index++) {
            if (word.equals(numberWords[index])) {
                value = index;
                isSetValue = true;
                break;
            }
        }
        if (!isSetValue)
            value = Double.parseDouble(word);
        return value;
    }
}