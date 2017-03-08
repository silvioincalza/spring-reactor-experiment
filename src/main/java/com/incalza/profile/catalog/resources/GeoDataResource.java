package com.incalza.profile.catalog.resources;

import com.incalza.profile.catalog.domain.GeoData;
import com.incalza.profile.catalog.domain.GeoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Locale;

/**
 * Created by sincalza on 06/03/2017.
 */
@RestController
public class GeoDataResource {

    private final GeoDataRepository geoDataRepository;

    @Autowired
    public GeoDataResource(GeoDataRepository geoDataRepository) {
        this.geoDataRepository = geoDataRepository;
    }

    @GetMapping("/geoData")
    public Mono<GeoData> geoDataByCity(@RequestParam(value = "address") String address, @RequestParam(value = "country") String country, @RequestParam(value = "city") String city) {
        return geoDataRepository.findByCity(address, country, city, Locale.ENGLISH);
    }
}
