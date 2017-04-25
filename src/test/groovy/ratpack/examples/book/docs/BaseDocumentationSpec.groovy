package ratpack.examples.book.docs

import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration

import io.restassured.builder.RequestSpecBuilder
import io.restassured.specification.RequestSpecification
import org.junit.Rule
import org.springframework.restdocs.JUnitRestDocumentation
import ratpack.examples.book.fixture.ExampleBooksApplicationUnderTest
import ratpack.test.ApplicationUnderTest
import spock.lang.Shared
import spock.lang.Specification

abstract class BaseDocumentationSpec extends Specification {

    @Shared
    ApplicationUnderTest aut = new ExampleBooksApplicationUnderTest()

    @Rule
    JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation('src/docs/generated-snippets')

    protected RequestSpecification documentationSpec

    void setup() {
        this.documentationSpec = new RequestSpecBuilder()
                .addFilter(documentationConfiguration(restDocumentation))
                .build()
    }
}
