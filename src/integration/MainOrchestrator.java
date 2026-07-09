package integration;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Enum for main menu options presented to the user.
 * Internal to the Integration module. Feature modules are looked up by
 * name from ModuleRegistry rather than referencing this enum directly.
 */
enum MenuOptions {

    /** Manage user accounts. */
    ACCOUNTS,

    /** View financial insights. */
    INSIGHTS,

    /** Run a data audit. */
    DATA_AUDIT,

    /** Generate reports. */
    REPORTS,

    /** Manage data storage. */
    STORAGE,

    /** Exit the application. */
    EXIT
}

/**
 * Holds the mapping of module names to their AppModule implementations.
 */
class ModuleRegistry {

    private final Map<String, AppModule> modules;

    /**
     * Constructs an empty registry.
     */
    public ModuleRegistry() {
        this.modules = new HashMap<>();
    }

    /**
     * Registers a single module under its own name.
     *
     * @param module the module to register
     */
    public void registerModule(AppModule module) {
        modules.put(module.getModuleName(), module);
    }

    /**
     * Looks up a registered module by name.
     *
     * @param name the module's name
     * @return the matching module, or null if none is registered
     */
    public AppModule getModule(String name) {
        return modules.get(name);
    }

    /**
     * Returns all currently registered modules.
     *
     * @return the registered modules
     */
    public Collection<AppModule> getAllModules() {
        return modules.values();
    }

    /**
     * Verifies that a module is registered for every MenuOptions value
     * except EXIT, assuming a module's registered name matches its
     * MenuOptions constant name.
     *
     * @throws IllegalStateException if any expected module is missing
     */
    public void validateRegistrations() {
    }
}

/**
 * Stateless static helper providing common console prompting utilities
 * used across menus.
 */
final class MenuUtil {

    private MenuUtil() {
    }

    /**
     * Prompts the user to choose from a list of options, re-prompting
     * until a valid choice is made.
     *
     * @param scanner the scanner to read input from
     * @param prompt  the prompt message
     * @param options the available options
     * @return the chosen option
     * @author Mohsen Kanj
     */
    public static String promptChoice(Scanner scanner, String prompt, List<String> options) {
        while (true) {
            System.out.println(prompt);

            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Enter choice: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);

                if (choice >= 1 && choice <= options.size()) {
                    return options.get(choice - 1);
                }
            } catch (NumberFormatException e) {
                // keep asking
            }

            System.err.println("Invalid choice. Please try again.");
        }
    }

    /**
     * Prompts the user for a yes/no response.
     *
     * @param scanner the scanner to read input from
     * @param prompt  the prompt message
     * @return true for yes, false for no
     * @author Mohsen Kanj
     */
    public static boolean promptYesNo(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("y") || input.equals("yes")) {
                return true;
            }

            if (input.equals("n") || input.equals("no")) {
                return false;
            }

            System.err.println("Please enter y or n.");
        }
    }
}

/**
 * Application entry point. Holds the module registry,
 * main menu loop, and dispatches user selections
 * to the appropriate module.
 */
public class MainOrchestrator {

    private final ModuleRegistry registry;

    /**
     * Constructs the orchestrator with a fresh registry.
     */
    public MainOrchestrator() {
        this.registry = new ModuleRegistry();
    }

    /**
     * Application entry point.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        MainOrchestrator orchestrator = new MainOrchestrator();
        orchestrator.startApplication();
    }

    /**
     * Validates the registry, initializes every registered module, and
     * starts the main menu loop.
     */
    public void startApplication() {
    }

    /**
     * Runs the main menu loop, prompting for a menu option and
     * dispatching it until the user selects EXIT.
     */
    public void runMainMenuLoop() {
    }

    /**
     * Dispatches a single main menu selection to the corresponding module,
     * assuming the module's registered name matches the option's constant
     * name.
     *
     * @param option the selected menu option
     */
    public void dispatchSelection(MenuOptions option) {
    }

    /**
     * Performs any cleanup needed before the application exits.
     */
    public void shutdownApplication() {
    }
}
