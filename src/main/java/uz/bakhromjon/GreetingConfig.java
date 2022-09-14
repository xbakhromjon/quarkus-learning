package uz.bakhromjon;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingConfig {
    @ConfigProperty(defaultValue = "Students", name = "application.greeting.recipient")
    String recipient;
}
