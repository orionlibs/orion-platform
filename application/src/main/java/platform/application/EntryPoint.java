package platform.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import platform.application.command.help.HelpCommand;

@Component
public class EntryPoint
{
    @Autowired HelpCommand helpCommand;


    public void run() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = reader.readLine()) != null)
        {
            line = line.trim();
            if(line.isEmpty())
            {
                continue;
            }
            if(Argument.HELP.name().equalsIgnoreCase(line))
            {
                helpCommand.run();
            }
            else if(Argument.TIME.name().equalsIgnoreCase(line))
            {
                System.out.println("Current time: " + LocalTime.now());
            }
            else if(line.toLowerCase().startsWith(Argument.ECHO.name()))
            {
                System.out.println(line.substring(5));
            }
            else if(Argument.EXIT.name().equalsIgnoreCase(line))
            {
                System.out.println("Bye");
                System.exit(0);
            }
            else
            {
                System.out.println("Unknown command: " + line + "  (type 'help')");
            }
        }
    }
}
