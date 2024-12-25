package com.UST.Domains.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.UST.Domains.Model.Domains;
import com.UST.Domains.Repository.DomainsRepository;
import com.UST.Domains.dto.Domainsdto;
import com.UST.Domains.dto.Employeedto;
import com.UST.Domains.dto.Responsedto;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class DomainsService {

    @Autowired
    private DomainsRepository domainsRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Mono<Domains> addDomains(Domains domain) {
        return domainsRepository.save(domain);
    }

    public Mono<Domains> getDomainsById(String domain_id) {
        return domainsRepository.findById(domain_id);
    }

    public Flux<Domains> getAllDomains() {
        return domainsRepository.findAll();
    }

    public Mono<Responsedto> getDomainWithEmployees(String domain_id) {
        Mono<Domains> domainMono = domainsRepository.findById(domain_id);
        Flux<Employeedto> employeeFlux = getEmployeesByDomainId(domain_id);

        return domainMono.zipWith(employeeFlux.collectList(), (domain, employees) -> {
            Responsedto responseDto = new Responsedto();
            responseDto.setDomainsdto(mapToDomainsdto(domain));
            responseDto.setEmployees(employees);
            return responseDto;
        });
    }

    private Flux<Employeedto> getEmployeesByDomainId(String domain_id) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8083/employees/" + domain_id)
                .retrieve()
                .bodyToFlux(Employeedto.class);
    }

    private Domainsdto mapToDomainsdto(Domains domain) {
        Domainsdto domainsdto = new Domainsdto();
        domainsdto.setDomain_id(domain.getDomain_id());
        domainsdto.setDomain_name(domain.getDomain_name());
        domainsdto.setCount(domain.getCount());
        return domainsdto;
    }
}
