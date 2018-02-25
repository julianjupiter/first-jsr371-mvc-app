package io.github.julianjupiter.jsr371mvc.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.mvcspec.ozark.jersey.bootstrap.OzarkJerseyFeature;

public class ApplicationResourceConfig extends ResourceConfig {

    public ApplicationResourceConfig() {
        packages("io.github.julianjupiter.jsr371mvc");
        register(new ApplicationBinder());
        register(OzarkJerseyFeature.class);
    }
}
