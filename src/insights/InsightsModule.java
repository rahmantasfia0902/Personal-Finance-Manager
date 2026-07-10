package insights;

import integration.AppModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Entry point for the Insights module.
 *
 * <p>This class implements {@link AppModule} so the Integration layer
 * can call the Insights module from the main application menu without
 * needing to know how the module works internally.</p>
 *
 * <p>The Insights module owns its own submenu and delegates financial
 * analysis work to {@link InsightsManager}.</p>
 *
 * @author Waliur Sun
 */
public class InsightsModule implements AppModule {

    /**
     * Registered module name used by the Integration registry.
     */
    private static final String MODULE_NAME = "insights";

    /**
     * Handles insight calculations and report generation.
     */
    private InsightsManager insightsManager;

    /**
     * Reads user input from the console.
     */
    private Scanner scanner;

    /**
     * Constructs a new InsightsModule.
     *
     * <p>No heavy setup is done in the constructor. Setup belongs in
     * {@link #initialize()}.</p>
     *
     * @author Waliur Sun
     */
    public InsightsModule() {
    }

    /**
     * Returns the unique module name used by Integration.
     *
     * @return the module name
     * @author Waliur Sun
     */
    @Override
    public String getModuleName() {
        return MODULE_NAME;
    }

    /**
     * Performs one-time setup for the Insights module.
     *
     * <p>This method creates the helper objects needed by the module.</p>
     *
     * @author Waliur Sun
     */
    @Override
    public void initialize() {
        insightsManager = new InsightsManager();
        scanner = new Scanner(System.in);
    }

    /**
     * Runs the Insights submenu.
     *
     * <p>This method is called by Integration when the user selects
     * the Insights module from the main menu.</p>
     *
     * @author Waliur Sun
     */
    @Override
    public void handleSelection() {
        boolean running = true;

        while (running) {
            printMenu();

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> handleDisplaySampleInsights();
                case "0" -> running = false;
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }

    /**
     * Prints the Insights submenu.
     *
     * @author Waliur Sun
     */
    private void printMenu() {
        System.out.println();
        System.out.println("=== Insights Module ===");
        System.out.println("1. Display sample yearly insights");
        System.out.println("0. Back to main menu");
        System.out.print("Choose an option: ");
    }

    /**
     * Displays sample yearly insights for the alpha build.
     *
     * <p>This allows Integration to verify that the Insights module
     * can be called successfully before the final Storage connection
     * is completed.</p>
     *
     * @author Waliur Sun
     */
    private void handleDisplaySampleInsights() {
        List<String[]> transactions = new ArrayList<>();

        transactions.add(new String[]{"01/15/2025", "Compensation", "3000"});
        transactions.add(new String[]{"01/20/2025", "Food", "-250"});
        transactions.add(new String[]{"02/01/2025", "Home", "-1200"});
        transactions.add(new String[]{"02/15/2025", "Allowance", "500"});
        transactions.add(new String[]{"03/10/2025", "Transportation", "-150"});
        transactions.add(new String[]{"04/05/2025", "Entertainment", "-100"});
        transactions.add(new String[]{"05/01/2025", "Utilities", "-200"});

        insightsManager.displayInsights(transactions);
    }
}