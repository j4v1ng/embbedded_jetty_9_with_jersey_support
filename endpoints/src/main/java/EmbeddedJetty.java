import gateways.GreetingsService;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

import static javax.ws.rs.core.UriBuilder.fromUri;
import static org.glassfish.jersey.jetty.JettyHttpContainerFactory.createServer;

public class EmbeddedJetty {

    public void start() {
        URI baseUri = fromUri("http://localhost/").port(9998).build();
        ResourceConfig config = new ResourceConfig(GreetingsService.class);
        createServer(baseUri, config);
    }

    public static void main(String[] args) {
        EmbeddedJetty embeddedJetty = new EmbeddedJetty();
        embeddedJetty.start();

    }
}
