import io.github.bonigarcia.wdm.WebDriverManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.openqa.selenium.phantomjs.PhantomJSDriver

class EndToEndTest {

    private lateinit var browser: PhantomJSDriver
    private lateinit var vegetables: Vegetables

    @BeforeEach
    fun before() {
        WebDriverManager.phantomjs().setup()
        browser = PhantomJSDriver()
        vegetables = Vegetables()
        vegetables.start()
    }

    @AfterEach
    fun after() {
        browser.close()
        vegetables.stop()
    }

    @Test
    fun `add a vegetable and see it in the box`() {
        browser.get("http://localhost:4545/add")
        browser.findElementById("name").sendKeys("Carrot")
        browser.findElementById("description").sendKeys("Is orange (or violet) and has a shape like a daikon but smaller")
        browser.findElementById("save").click()

        assertThat(browser.pageSource).contains("Vegetable box")
        assertThat(browser.pageSource).contains("Carrot")
    }
}