package platform.application.command.help;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class HelpCommand
{
    @ShellMethod(key = "help1")
    public String help1()
    {
        return "Available commands: help, time, echo, exit";
    }


    @ShellMethod(key = "help2")
    public String help2(@ShellOption(value = {"--name", "-n"}) String name)
    {
        return "Available commands: help, help2. " + name;
    }
}
