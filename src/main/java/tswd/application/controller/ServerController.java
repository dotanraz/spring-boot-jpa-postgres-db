package tswd.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tswd.application.model.Server;
import tswd.application.service.IServerService;
import java.util.List;

@RestController
@RequestMapping("api")
public class ServerController {

    @Autowired
    IServerService serverService;

    @PostMapping(path = "/addServer")
    public void produceEvent(@RequestBody Server server) {
        serverService.addServer(server);
    }

    @GetMapping(path = "/getServers")
    public List<Server> getServers() {
        return serverService.getAllServers();
    }

    @GetMapping(path = "/getAllIps")
    public boolean isIpAvailable(@RequestParam String ip) {
        return serverService.isIpAvailable(ip);
    }

}
