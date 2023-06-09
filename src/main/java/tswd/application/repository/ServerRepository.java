package tswd.application.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tswd.application.model.Server;
import java.util.List;
import java.util.Optional;

@Repository
public interface ServerRepository extends CrudRepository<Server, Integer> {

    @Query(value = "SELECT * FROM Server", nativeQuery = true)
    Optional<List<Server>> getAllServers();

    @Query(value = "SELECT ip FROM Server", nativeQuery = true)
    Optional<List<String>> getAllIpsFromServer();

    @Query(value = "SELECT IP FROM Server s WHERE s.ip = :ip", nativeQuery = true)
    Optional<String> findIpOnServer(@Param("ip") String ip);

}
