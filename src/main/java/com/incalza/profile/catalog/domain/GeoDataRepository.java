package com.incalza.profile.catalog.domain;

import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

import java.util.Locale;

/**
 * Created by sincalza on 06/03/2017.
 */
public interface GeoDataRepository {

    Mono<GeoData> findByCity(String address, String country, String city, Locale locale) ;

}
