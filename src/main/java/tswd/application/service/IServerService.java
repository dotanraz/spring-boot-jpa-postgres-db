package tswd.application.service;

import tswd.application.model.Server;
import java.util.List;

public interface IServerService {
    boolean isIpAvailable(String ip);
    List<String> getAllIPsFromServers();
    void addServer(Server server);
    List<Server> getAllServers();
}
