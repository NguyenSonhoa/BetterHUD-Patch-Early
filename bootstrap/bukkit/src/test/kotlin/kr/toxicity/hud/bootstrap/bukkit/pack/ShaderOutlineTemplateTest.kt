package kr.toxicity.hud.bootstrap.bukkit.pack

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ShaderOutlineTemplateTest {

    @Test
    fun `text shader declares outline before generated layout cases`() {
        val source = requireNotNull(javaClass.classLoader.getResource("text_1_21_9.vsh")) {
            "Missing 1.21.9 text shader template"
        }.readText()

        val declaration = source.indexOf("bool outline = false;")
        val layout = source.indexOf("#CreateLayout")
        assertTrue(declaration >= 0 && declaration < layout, "Generated outline cases require a local declaration.")
    }
}
