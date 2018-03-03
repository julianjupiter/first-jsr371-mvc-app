package io.github.julianjupiter.jsr371mvc.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.mvcspec.ozark.bootstrap.OzarkCoreFeature;
import org.mvcspec.ozark.jersey.bootstrap.OzarkJerseyFeature;

public class ApplicationResourceConfig extends ResourceConfig {

    public ApplicationResourceConfig() {
        packages("io.github.julianjupiter.jsr371mvc");
        register(new ApplicationBinder());
//        register(new OzarkCoreFeature()); // throws exception
//        register(OzarkCoreFeature.class); // throws exception
        register(OzarkJerseyFeature.class);
    }
}
