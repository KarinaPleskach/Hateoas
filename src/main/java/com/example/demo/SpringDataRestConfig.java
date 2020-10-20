package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;

@Configuration
@Slf4j
public class SpringDataRestConfig {

    public static int entityModelDemoEntityCounter = 0;
    public static int collectionModelDemoEntityCounter = 0;
    public static int entityModelSecondEntityCounter = 0;
    public static int collectionModelSecondEntityCounter = 0;

    @Bean
    public RepresentationModelProcessor<EntityModel<DemoEntity>> demoEntityProcessor() {
        return new RepresentationModelProcessor<EntityModel<DemoEntity>>() {
            @Override
            public EntityModel<DemoEntity> process(EntityModel<DemoEntity> entity) {
                log.info(++entityModelDemoEntityCounter + "process(EntityModel<DemoEntity> entity)");
                return new MyHateoasEntityModel<>(entity.getContent(), entity.getLink("self").orElse(new Link("self")));
            }
        };
    }

    @Bean
    public RepresentationModelProcessor<CollectionModel<EntityModel<DemoEntity>>> demoEntitiesProcessor() {

        return new RepresentationModelProcessor<CollectionModel<EntityModel<DemoEntity>>>() {

            @Override
            public CollectionModel<EntityModel<DemoEntity>> process(CollectionModel<EntityModel<DemoEntity>> collection) {
                log.info(++collectionModelDemoEntityCounter + "process(CollectionModel<EntityModel<DemoEntity>> collection)");
                return new MyHateoasCollectionModel<>(collection.getContent());
            }
        };
    }

    @Bean
    public RepresentationModelProcessor<EntityModel<SecondEntity>> secondEntityProcessor() {
        return new RepresentationModelProcessor<EntityModel<SecondEntity>>() {
            @Override
            public EntityModel<SecondEntity> process(EntityModel<SecondEntity> entity) {
                log.info(++entityModelSecondEntityCounter + "process(EntityModel<SecondEntity> entity)");
                return new MyHateoasEntityModel<>(entity.getContent(), entity.getLink("self").orElse(new Link("self")));
            }
        };
    }

    @Bean
    public RepresentationModelProcessor<CollectionModel<EntityModel<SecondEntity>>> secondEntitiesProcessor() {

        return new RepresentationModelProcessor<CollectionModel<EntityModel<SecondEntity>>>() {

            @Override
            public CollectionModel<EntityModel<SecondEntity>> process(CollectionModel<EntityModel<SecondEntity>> collection) {
                log.info(++collectionModelSecondEntityCounter + "process(CollectionModel<EntityModel<SecondEntity>> collection)");
                return new MyHateoasCollectionModel<>(collection.getContent());
            }
        };
    }

}
