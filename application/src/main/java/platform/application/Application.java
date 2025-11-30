package platform.application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.cfg.DateTimeFeature;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.dataformat.yaml.YAMLMapper;

@SpringBootApplication
@ComponentScan(basePackages = {"platform"})
public class Application implements CommandLineRunner
{
    @Autowired private EntryPoint entryPoint;
    static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public YAMLMapper yamlMapper()
    {
        return YAMLMapper.builder().build();
    }


    @Bean
    public JsonMapper jsonMapper()
    {
        return JsonMapper.builder()
                        //.propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                        .enable(SerializationFeature.FAIL_ON_EMPTY_BEANS, SerializationFeature.FAIL_ON_SELF_REFERENCES)
                        .enable(DateTimeFeature.WRITE_DATES_AS_TIMESTAMPS)
                        .build();
    }


    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("Application started. Type 'help' to see available commands");
        entryPoint.run();
    }
}
