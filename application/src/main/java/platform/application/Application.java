package platform.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.command.annotation.CommandScan;
import org.springframework.shell.command.annotation.EnableCommand;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.cfg.DateTimeFeature;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.dataformat.yaml.YAMLMapper;

@SpringBootApplication
//@ComponentScan(basePackages = {"platform"})
@CommandScan(basePackages = {"platform.application.command"})
@EnableCommand
public class Application
{
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
}
