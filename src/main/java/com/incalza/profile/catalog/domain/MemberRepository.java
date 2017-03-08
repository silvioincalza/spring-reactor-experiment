package com.incalza.profile.catalog.domain;

import reactor.core.publisher.Flux;

/**
 * Created by sincalza on 06/03/2017.
 */
public interface MemberRepository {
    Flux<Member> findAll();
    Flux<Member> findByCity(String city);
}
