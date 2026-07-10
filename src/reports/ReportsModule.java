package reports;

import integration.AppModule;

import java.util.Scanner;

/**
 * Entry point for the Reports module.
 * <p>
 * Implements {@link AppModule} so the Integration layer can invoke
 * the Reports module without knowing its internal implementation.
 * This class owns the Reports submenu and delegates report generation
 * and display to the other classes in the reports package.
 * </p>
 *
 * @author Tahsin Abid
 * @version 1.0
 * @since 1.0
 */

public class ReportsModule implements AppModule {

    /**
     * Registered module name
     */
    private static final String MODULE_NAME = "reports";

    private Scanner scanner;
    private ReportMenu reportMenu;
    private ReportManager reportManager;

    /**
     * Constructs a ReportsModule.
     */

    public ReportsModule() {
    }

    @Override
    public String getModuleName() {
        return MODULE_NAME;
    }

    @Override
    public void initialize() {
        scanner = new Scanner(System.in);
        reportMenu = new ReportMenu();
        reportManager = new ReportManager();
    }

    @Override
    public void handleSelection() {
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {

                case "1":
                    System.out.println("Annual Report selected.");
                    // Designate annual report generation to ReportManager
                    break;

                case "2":
                    System.out.println("Monthly Summary selected.");
                    //Designate Monthly Summary generation to ReportManager
                    break;

                case "3":
                    System.out.println("Category Totals selected.");
                    // Designate Category Totals generation to ReportManager
                    break;

                case "4":
                    System.out.println("Budget Summary selected.");
                    // Designate Budget Summary generation to ReportManager
                    break;

                case "0":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    /**
     * Prints the Reports submenu.
     */
    private void printMenu() {

        System.out.println();
        System.out.println("=== Reports Module ===");
        System.out.println("1. Annual Report");
        System.out.println("2. Monthly Summary");
        System.out.println("3. Category Totals");
        System.out.println("4. Budget Summary");
        System.out.println("0. Return to Main Menu");
        System.out.print("Choose an option: ");

    }

}