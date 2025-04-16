package io.github.fontysvenlo.ais.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;

/**
 * Provides DataSources for the database connection.
 */
public class DBProvider {
    /**
     * Private constructor to prevent instantiation.
     */


    static Map<String, DataSource> cache = new HashMap<>();
   
    static DataSource getDataSource(final DBConfig config) {
        return cache.computeIfAbsent(config.namespace(), namespace -> {
                PGSimpleDataSource source = new PGSimpleDataSource();

                String[] serverNames = {config.host()};
                source.setServerNames(serverNames);

                int[] portNumbers = {config.port()};
                source.setPortNumbers(portNumbers);
                source.setUser(config.username());
                source.setDatabaseName(config.name());
                source.setPassword(config.password());
                source.setCurrentSchema(config.schema());
                return source;
            }
        );
        
    }
   static Properties getProperties(String propertiesFileName){

        System.out.println("The user working dir is " + System.getProperty("user.dir"));

        // Usage of resource file is preferred way. No issues with working dir.
        // Uses the default location of resources (in src/main/java/resources dir)
        // getClassLoader() is necessary, unless you store your property file in a
        // subfolder according to package name
        // (src/main/resources/fontys/customerdbdemo in this case).

        Properties properties = new Properties();
        try (InputStream dbProperties = DBProvider.class.getClassLoader().getResourceAsStream(propertiesFileName);) {
            properties.load(dbProperties);
        } catch (IOException ex) {
            Logger.getLogger(DBProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return properties;
    }
}
