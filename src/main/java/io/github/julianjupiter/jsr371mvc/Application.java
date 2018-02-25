package io.github.julianjupiter.jsr371mvc;

import io.github.julianjupiter.jsr371mvc.server.GrizzlyServer;

public class Application {

    public static void main(String[] args) throws Exception {
        GrizzlyServer.run(args);
    }
}
