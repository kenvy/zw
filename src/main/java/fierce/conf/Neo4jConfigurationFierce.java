package fierce.conf;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

/**
 * Created by Fierce on 2016/4/29.
 */
@Configuration
@EnableNeo4jRepositories(
        basePackages = "fierce",
        includeFilters =
        @ComponentScan.Filter(
                type = FilterType.REGEX,
                pattern = "fierce.dao.PersonRepository"))
public class Neo4jConfigurationFierce extends Neo4jConfiguration {

    public Neo4jConfigurationFierce() {
        setBasePackage("fierce");
    }

    @Bean
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("target/hello.db");
    }

}
