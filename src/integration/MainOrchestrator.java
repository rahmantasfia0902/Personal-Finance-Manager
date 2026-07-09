package integration;

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
