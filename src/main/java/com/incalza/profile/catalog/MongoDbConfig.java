package com.incalza.profile.catalog;

import com.incalza.profile.catalog.domain.MemberRepository;
import com.incalza.profile.catalog.mongodb.MongoMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * Created by sincalza on 04/03/2017.
 */
@Configuration
@EnableReactiveMongoRepositories
public class MongoDbConfig  {

    @Bean
    public MemberRepository memberRepository(ReactiveMongoTemplate reactiveMongoTemplate) {
        return new MongoMemberRepository(reactiveMongoTemplate);
    }

}
