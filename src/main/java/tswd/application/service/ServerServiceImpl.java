package tswd.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tswd.application.model.Server;
import tswd.application.repository.ServerRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ServerServiceImpl implements IServerService{

    @Autowired
    ServerRepository serverRepository;

    public boolean isIpAvailable(String ip) {
        return serverRepository.findIpOnServer(ip).isEmpty();
    }

    @Override
    public void addServer(Server server) {
        System.out.println("going to add server: " + server.toString());
        serverRepository.save(server);
    }

    @Override
    public List<Server> getAllServers() {
        Optional<List<Server>> allServers = serverRepository.getAllServers();
        List<Server> servers = allServers.get();
        servers.forEach(server -> System.out.println(server.toString()));
        return servers;
    }

    public List<String> getAllIPsFromServers() {
        Optional<List<String>> optionalIps = serverRepository.getAllIpsFromServer();
        List<String> ips = optionalIps.get();
        ips.forEach(ip -> System.out.println(ip));
        return ips;
    }
}
