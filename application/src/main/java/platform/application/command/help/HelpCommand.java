package platform.application.command.help;

import org.springframework.stereotype.Component;

@Component
public class HelpCommand
{
    public void run()
    {
        System.out.println("Available commands: help, time, echo, exit");
    }
}
