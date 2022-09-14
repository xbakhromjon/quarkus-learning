package uz.bakhromjon;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {
    GreetingConfig config;
    @ConfigProperty(defaultValue = "Students", name = "application.greeting.recipient")
    String recipient;

    @Inject
    public ExampleResource(GreetingConfig greetingConfig) {
        this.config = greetingConfig;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello " + recipient;
    }
 }