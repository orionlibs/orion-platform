package platform.application.command.help;

import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.stereotype.Component;

@Component
public class HelpCommand
{
    @Command(command = "help")
    public void run()
    {
        System.out.println("Available commands: help, time, echo, exit");
    }


    @Command(command = "help2")
    public void help2(@Option(defaultValue = "temp") String name)
    {
        System.out.println("Available commands: help, help2. " + name);
    }
}
