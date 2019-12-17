import io.github.bonigarcia.wdm.WebDriverManager
import org.assertj.core.api.AbstractCharSequenceAssert
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.phantomjs.PhantomJSDriver

class EndToEndTest {

    private lateinit var browser: PhantomJSDriver
    private lateinit var vegetables: Vegetables

    @BeforeEach
    fun before() {
        WebDriverManager.phantomjs().setup()
        browser = PhantomJSDriver()
        vegetables = Vegetables(InMemoryVegetableRepository())
        vegetables.start()
    }

    @AfterEach
    fun after() {
        browser.close()
        vegetables.stop()
    }

    @Test
    fun `add a vegetable and see it in the box`() {
        addToTheBox("Carrot", "So good")

        assertBox().contains("Carrot")
    }

    @Test
    fun `see vegetable details`() {
        addToTheBox("Carrot", "Is orange (or violet) and has a shape like a daikon but smaller")

        browser.findElementById("Carrot").click()

        assertDetails().contains("Is orange (or violet) and has a shape like a daikon but smaller")
    }

    @Test
    fun `eat a vegetable`() {
        addToTheBox("Onion", "So good")

        browser.findElementById("EatOnion").click()

        assertBox().doesNotContain("Onion")
    }

    @Test
    fun `edit a vegetable`() {
        addToTheBox("Onion", "Very good")

        browser.findElementById("EditOnion").click()

        browser.findElementById("description").sendKeys("My favorite")
        browser.findElementById("save").click()

        browser.findElementById("Onion").click()

        assertDetails().contains("My favorite")
    }

    private fun assertDetails(): AbstractCharSequenceAssert<*, String> {
        assertThat(browser.pageSource).contains("Details of ")
        return assertThat(browser.pageSource)
    }

    private fun assertBox(): AbstractCharSequenceAssert<*, String> {
        assertThat(browser.pageSource).contains("Vegetable box")
        return assertThat(browser.pageSource)
    }

    private fun addToTheBox(name: String, description: String) {
        browser.get("http://localhost:4545")
        browser.findElementById("add").click()

        browser.findElementById("name").sendKeys(name)
        browser.findElementById("description")
            .sendKeys(description)
        browser.findElementById("save").click()
    }
}