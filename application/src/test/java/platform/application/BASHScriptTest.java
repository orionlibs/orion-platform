package platform.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BASHScriptTest
{
    private static final Path PROJECT_ROOT = Paths.get("").toAbsolutePath();
    private static final Path SCRIPT = PROJECT_ROOT.resolve("run-all-commands.sh");


    @BeforeEach
    public void ensureScriptExecutable() throws IOException
    {
        // Make sure the script file exists and is executable
        assertTrue(Files.exists(SCRIPT), "run-all-commands.sh must exist in project root before running tests");
        SCRIPT.toFile().setExecutable(true);
    }


    @Test
    public void testRunHereDocScript() throws IOException, InterruptedException
    {
        ProcessBuilder pb = new ProcessBuilder()
                        .command("bash", SCRIPT.toAbsolutePath().toString())
                        .directory(PROJECT_ROOT.toFile())
                        .redirectErrorStream(true);
        Process p = pb.start();
        boolean finished = p.waitFor(30, TimeUnit.SECONDS);
        if(!finished)
        {
            p.destroyForcibly();
            fail("Script did not finish within timeout");
        }
        int exitCode = p.exitValue();
        String output = new String(p.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        assertThat(exitCode).isEqualTo(0);
        assertThat(output.contains("Application started")).isTrue();
        assertThat(output.contains("Available commands: help, time, echo, exit")).isTrue();
        assertThat(output.contains("Hello")).isTrue();
        assertThat(output.contains("Bye")).isTrue();
    }
}
