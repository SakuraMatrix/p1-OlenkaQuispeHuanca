import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class ServerConnection {
    //creates the server connection
    public void Connect() throws URISyntaxException {
          Path fileHTML = Paths.get(Objects.requireNonNull(App.class.getResource("/test.html")).toURI());

          DisposableServer server = HttpServer.create()
                  .port(8080)
                  .route(routes ->
                          routes.get("/test",(request, response) ->
                                  response.sendFile(fileHTML)))
                  .bindNow();

          server.onDispose()
                .block();
    }

}
