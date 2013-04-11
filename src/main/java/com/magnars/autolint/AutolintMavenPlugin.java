package com.magnars.autolint;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;

/**
 * Goal which runs autolint.js
 *
 * @goal verify
 *
 * @phase verify
 */
public class AutolintMavenPlugin
    extends AbstractMojo {
    /**
     * Directory where the autolint.js configuration file resides.
     * @parameter expression="${project.build.directory}"
     * @required
     */
    private File rootDirectory;

    /**
     * Whether the test should be skipped
     * @parameter
     */
    private boolean skip;

    public void execute() throws MojoExecutionException, MojoFailureException {
        Log log = getLog();

        if (skip) {
            log.info("Skipping Autolint.js");
            return;
        }

        log.info("");
        log.info("------------------------------------------------------------------------");
        log.info("Running Autolint.js");
        log.info("------------------------------------------------------------------------");
        log.info("Using path " + rootDirectory.toString());

        ProcessBuilder pb = new ProcessBuilder("autolint", "--once");
        pb.directory(rootDirectory);
        pb.redirectErrorStream(true);

        Process process = null;
        try {
            process = pb.start();

            final BufferedReader inputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            for (String line = inputReader.readLine(); line != null; line = inputReader.readLine()) {
                    log.info(line);
            }

            int exitCode = process.waitFor();

            if (exitCode != 0) {
                throw new MojoFailureException("Linting of JavaScript code FAILED");
            }
        } catch (InterruptedException | IOException e) {
            throw new MojoExecutionException(e.getMessage());
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }
}
