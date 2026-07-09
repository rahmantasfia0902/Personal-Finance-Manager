package integration;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

enum MenuOptions {
    ACCOUNTS,
    INSIGHTS,
    DATA_AUDIT,
    REPORTS,
    STORAGE,
    EXIT
}

class ModuleRegistry {

    private final Map<String, AppModule> modules;

    public ModuleRegistry() {
        this.modules = new HashMap<>();
    }

    public void registerModule(AppModule module) {
        modules.put(module.getModuleName(), module);
    }

    public AppModule getModule(String name) {
        return modules.get(name);
    }

    public Collection<AppModule> getAllModules() {
        return modules.values();
    }

    public void validateRegistrations() {
    }
}

final class MenuUtil {

    private MenuUtil() {
    }

    public static String promptChoice(Scanner scanner, String prompt, List<String> options) {
        return null;
    }

    public static boolean promptYesNo(Scanner scanner, String prompt) {
        return false;
    }
}

public class MainOrchestrator {

    private final ModuleRegistry registry;

    public MainOrchestrator() {
        this.registry = new ModuleRegistry();
    }

    public static void main(String[] args) {
        MainOrchestrator orchestrator = new MainOrchestrator();
        orchestrator.startApplication();
    }

    public void startApplication() {
    }

    public void runMainMenuLoop() {
    }

    public void dispatchSelection(MenuOptions option) {
    }

    public void shutdownApplication() {
    }
}
