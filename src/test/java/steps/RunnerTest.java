package steps;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features") // Caminho para a pasta src/test/resources/features
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "steps") // Pacote onde estão os passos Java
public class RunnerTest {
    // Esta classe não precisa de código dentro dela. 
    // As anotações acima fazem todo o trabalho de ligar a Feature aos Steps.
}