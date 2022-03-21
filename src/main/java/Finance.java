


import com.h2.BestLoanRates;
import com.h2.MortgageCalculator;
import com.h2.SavingsCalculator;

import java.util.Arrays;
import java.util.Map;

public class Finance {
    public static final String BEST_LOAN_RATES = "bestLoanRates";
    public static final String SAVINGS_CALCULATOR = "savingsCalculator";
    public static final String MORTGAGE_CALCULATOR = "mortgageCalculator";


    public final static Map<String, String> commandsToUsage = Map.of(
            BEST_LOAN_RATES, "usage: bestLoanRates",
            SAVINGS_CALCULATOR, "usage: savingsCalculator <credits separated by ','> <debits separated by ','>",
            MORTGAGE_CALCULATOR, "usage: mortgageCalculator <loanAmount> <termInYears> <annualRate>"
    );

    private static boolean validateCommandArguments(String[] args) {

        switch (args[0]) {
            case BEST_LOAN_RATES:
                System.out.println(commandsToUsage.get(1));
                return args.length == 1;
            case SAVINGS_CALCULATOR:
                System.out.println(commandsToUsage.get(2));
                return args.length == 3;
            case MORTGAGE_CALCULATOR:
                System.out.println(commandsToUsage.get(3));
                return args.length == 4;
        }
        return false;
    }

    private static void executeCommand(String command, String[] arguments) {

        switch (command) {
            case BEST_LOAN_RATES:
                System.out.println("Finding best loan rates ...");
                BestLoanRates.main(arguments);
                return;
            case SAVINGS_CALCULATOR:
                System.out.println("Finding your net savings ...");
                SavingsCalculator.main(arguments);
                return;
            case MORTGAGE_CALCULATOR:
                System.out.println("Finding your monthly payment ...");
                MortgageCalculator.main(arguments);
                return;
        }

    }

    public static void main(String[] args) {
        String command = args[0];
        if(!commandsToUsage.containsKey(command)) {
            System.out.println(command + ": command not found");
            return;
        }
        boolean isValidCommand = validateCommandArguments(args);

        if(!isValidCommand) {
            System.out.println(commandsToUsage.get(args[0]).trim());
            return;
        }

        executeCommand(command, Arrays.copyOfRange(args, 1, args.length));
    }
}
