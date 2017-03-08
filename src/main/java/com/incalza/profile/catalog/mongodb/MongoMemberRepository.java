package com.incalza.profile.catalog.mongodb;

import com.incalza.profile.catalog.domain.Member;
import com.incalza.profile.catalog.domain.MemberRepository;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Created by sincalza on 06/03/2017.
 */
@Repository
public class MongoMemberRepository implements MemberRepository {

    private static final String COLLECTION_NAME_MEMBER = "members";
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public MongoMemberRepository(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Override
    public Flux<Member> findAll() {
        return reactiveMongoTemplate.findAll(Member.class, COLLECTION_NAME_MEMBER);
    }

    @Override
    public Flux<Member> findByCity(String city) {
        return reactiveMongoTemplate.find(Query.query(Criteria.where("city").is(city)), Member.class, COLLECTION_NAME_MEMBER);
    }

}
