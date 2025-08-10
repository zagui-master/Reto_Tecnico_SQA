package co.sqasa.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "co.sqasa.StepDef",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = "pretty"

)

public class TestRunner {
}
