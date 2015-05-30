package org.hestia.RecipeBox;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class RecipeBoxApplication extends SpringBootServletInitializer
{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RecipeBoxApplication.class);
    }

    public static void main(String[] args) {
        new RecipeBoxApplication().configure(
                new SpringApplicationBuilder(RecipeBoxApplication.class)).run(args);
    }
}
