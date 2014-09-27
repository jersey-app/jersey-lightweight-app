package com.metaphor.interfaces.runner;

import com.metaphor.interfaces.application.Application;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.net.URI;

import static javax.ws.rs.core.UriBuilder.fromUri;

public class StandaloneRunner {

    public static void main(String[] args) throws Exception {
        URI baseUri = fromUri("http://localhost/").port(8081).build();
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, new Application());
        server.start();
        while (true) System.in.read();
    }
}
