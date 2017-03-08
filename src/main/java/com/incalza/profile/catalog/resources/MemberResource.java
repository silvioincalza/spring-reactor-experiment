package com.incalza.profile.catalog.resources;

import com.incalza.profile.catalog.domain.GeoDataRepository;
import com.incalza.profile.catalog.domain.Member;
import com.incalza.profile.catalog.domain.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;


/**
 * Created by sincalza on 05/03/2017.
 */
@RestController
public class MemberResource {

    private final MemberRepository memberRepository;
    @Autowired
    public MemberResource(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping(path = "/members")
    public Flux<Member> getMembers() {
        return this.memberRepository.findAll().delayElementsMillis(500);
    }



}
