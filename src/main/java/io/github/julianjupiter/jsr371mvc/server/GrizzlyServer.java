package io.github.julianjupiter.jsr371mvc.server;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.julianjupiter.jsr371mvc.config.ApplicationResourceConfig;

public class GrizzlyServer {    
    private static Logger logger = LoggerFactory.getLogger(GrizzlyServer.class);
    private static final String APP_NAME = "First JSR 371 MVC App";
    private static URI baseUri;
    private static final String PROTOCOL = "http://";
    private static final String HOST = "localhost";
    private static final String PATH = "/app";
    private static final int DEFAULT_PORT = 8080;
    
    private GrizzlyServer() {
    	
    }
    
	private static int port(String[] args) {
		if (args.length > 0) {
			String port = args[0];			
			try {
				return Integer.valueOf(port);
			} catch (NumberFormatException exception) {
				logger.error("Invalid port number {}", port);
				logger.error("Default port number {} will be used", DEFAULT_PORT);
			}
		}
		
		return DEFAULT_PORT;
	}
	
    public static HttpServer startServer(int port) {
        final ResourceConfig rc = new ApplicationResourceConfig();
        baseUri = UriBuilder.fromUri(PROTOCOL + HOST).port(port).path(PATH).build();
        HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(baseUri, rc);
        return httpServer;
    }


    public static void run(String[] args) throws IOException {
    	int port = port(args);
    	try {
	        final HttpServer server = startServer(port);
			logger.info("{} started with WADL available at {}/application.wadl", APP_NAME, baseUri);
			logger.info("Hit Enter to stop it...");
	        System.in.read();
	        server.shutdown();
    	} catch (IOException exception) {
			logger.error("{}", exception.getMessage());
			logger.error("Exit...");
			System.exit(1);
		}
    }
}
