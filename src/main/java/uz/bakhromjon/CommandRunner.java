package uz.bakhromjon;

import io.quarkus.arc.Arc;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@QuarkusMain
public class CommandRunner implements QuarkusApplication {
    private final Logger LOG = Logger.getLogger(CommandRunner.class);
    Scanner scanner = new Scanner(System.in);
    FizzBuzz fizzBuzz;
    DataSource dataSource;
    EntityManager entityManager;

    public CommandRunner(FizzBuzz fizzBuzz, DataSource dataSource, EntityManager entityManager) {
        this.fizzBuzz = fizzBuzz;
        this.dataSource = dataSource;
        this.entityManager = entityManager;
    }

    @ConfigProperty(defaultValue = "Students", name = "application.greeting.recipient")
    String recipient;

    @ConfigProperty(defaultValue = "100", name = "application.maxNumber")
    int maxNumber;


    @Override
    public int run(String... args) throws Exception {
        LOG.info("Started Application");
        List<Room> rooms = new ArrayList<>();
        // Raw
//        String sql = "SELECT NAME, ROOM_NUMBER, BED_INFO FROM ROOM;";
//        try {
//            Connection connection = dataSource.getConnection();
//            try (Statement stmt = connection.createStatement();) {
//                ResultSet rs = stmt.executeQuery(sql);
//                while (rs.next()) {
//                    rooms.add(new Room(rs.getString("NAME"), rs.getString("ROOM_NUMBER"), rs.getString("BED_INFO")));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        // Hibernate
        Arc.container().requestContext().activate();
        rooms = entityManager.createQuery("select r from Room r", Room.class).getResultList();
        Arc.container().requestContext().deactivate();
        System.out.println(rooms);
        LOG.info("Completed Successfully");
        return 0;
    }
}
