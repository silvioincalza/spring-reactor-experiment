package com.incalza.profile.catalog;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.PendingResult;
import com.google.maps.model.ComponentFilter;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.incalza.profile.catalog.domain.GeoData;
import com.incalza.profile.catalog.domain.GeoDataRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

import java.util.Locale;

import static com.google.maps.model.AddressType.LOCALITY;
import static com.google.maps.model.ComponentFilter.*;
import static com.google.maps.model.ComponentFilter.route;
import static com.google.maps.model.LocationType.APPROXIMATE;

/**
 * Created by sincalza on 06/03/2017.
 */
@Component
public class ReactorGeoDataRepository implements GeoDataRepository {


    public Mono<GeoData> findByCity(String address, String country, String city, Locale locale) {
        GeoApiContext geoApiContext = new GeoApiContext().setApiKey("AIzaSyBDozeoKYryGOc_Tq5TFB0g5hj00t7g_1E");
        final GeocodingApiRequest request = GeocodingApi.newRequest(geoApiContext).language(locale.getLanguage())
                .components(locality(city), country(country))
                .locationType(APPROXIMATE)
                .resultType(LOCALITY);

        return Mono.create((MonoSink<GeocodingResult> sink) -> {
            request.setCallback(new PendingResult.Callback<GeocodingResult[]>() {
                @Override
                public void onResult(GeocodingResult[] result) {
                    sink.success(result[0]);
                }

                @Override
                public void onFailure(Throwable e) {
                    sink.error(e);
                }
            });
        }).map((a) -> {
            final LatLng location = a.geometry.location;
            return new GeoData(location.lat, location.lng);
        });
    }


//    @Override
//    public Mono<GeoData> findByCity(String city, Locale locale) {
//        return WebClient.create("https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyBDozeoKYryGOc_Tq5TFB0g5hj00t7g_1E")
//                .get()
//                .uri((uriBuilder) -> uriBuilder.queryParam("components", "locality:" + city)
//                        .queryParam("language", locale.getLanguage()).build())
//                .accept(APPLICATION_JSON)
//                .contentType(APPLICATION_JSON)
//                .exchange()
//                .then((response) -> response.
//                        bodyToMono(JsonNode.class).
//                        map((json) ->
//                                new GeoData(json.at("/results/0/location/lat").asLong(),
//                                        json.at("/results/0/location/lng").asLong())));
//
//    }
}
