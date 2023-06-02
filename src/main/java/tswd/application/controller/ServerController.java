package tswd.application.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import tswd.application.model.Server;
import tswd.application.repository.ServerRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ServerController {

    @Autowired
    ServerRepository serverRepository;

    @PostMapping(path = "/addServer")
    public void produceEvent(@RequestBody Server server) {
        System.out.println("going to add server: " + server.toString());
        serverRepository.save(server);
    }

    @GetMapping(path = "/getServers")
    public List<Server> getServers() {
        Optional<List<Server>> allServers = serverRepository.getAllServers();
        List<Server> servers = allServers.get();
        servers.forEach(server -> System.out.println(server.toString()));
        return servers;
    }

}
