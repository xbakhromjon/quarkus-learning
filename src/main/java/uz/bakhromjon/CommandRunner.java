package uz.bakhromjon;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import java.util.Scanner;

@QuarkusMain
public class CommandRunner implements QuarkusApplication {
    private final Logger LOG = Logger.getLogger(CommandRunner.class);
    Scanner scanner = new Scanner(System.in);
    FizzBuzz fizzBuzz;

    @Inject
    public CommandRunner(FizzBuzz fizzBuzz) {
        this.fizzBuzz = fizzBuzz;
    }

    @ConfigProperty(defaultValue = "Students", name = "application.greeting.recipient")
    String recipient;

    @ConfigProperty(defaultValue = "100", name = "application.maxNumber")
    int maxNumber;

    @Override
    public int run(String... args) throws Exception {
        LOG.info("Started Application");
        fizzBuzz.execute(maxNumber);
        LOG.info("Completed Successfully");
        return 0;
    }
}
