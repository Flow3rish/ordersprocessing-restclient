package cloud.chrubasik.ordersprocessingrestclient.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

import cloud.chrubasik.ordersprocessingrestclient.cli.commands.CliCommand;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@Component
public class CliRestRunner implements CommandLineRunner, ExitCodeGenerator {

    @Autowired
    private final CliCommand cliCommand;

    private final IFactory factory;

    private int exitCode;


    public CliRestRunner(CliCommand cliCommand, IFactory factory) {
        this.cliCommand = cliCommand;
        this.factory = factory;
    }

    @Override
    public void run(String... args) throws Exception {
        this.exitCode = new CommandLine(cliCommand, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }

}
