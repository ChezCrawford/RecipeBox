package org.hestia.RecipeBox.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.hestia.RecipeBox.Endpoint;
import org.hestia.RecipeBox.RecipeManager;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig() {
        register(Endpoint.class);
        register(RecipeManager.class);
    }

}
