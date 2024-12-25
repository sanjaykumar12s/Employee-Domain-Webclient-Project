package com.UST.Domains.Repository;

import com.UST.Domains.Model.Domains;
import reactor.core.publisher.Mono;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainsRepository extends ReactiveMongoRepository<Domains, String> {

    Mono<Domains> findById(String domain_id);
}
