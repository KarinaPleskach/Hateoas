package com.example.demo;

import java.util.Collections;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class MyHateoasEntityModel<T> extends EntityModel<T> {
    private T entity;

    public MyHateoasEntityModel(T entity, Iterable<Link> links) {
        super(entity, Collections.emptyList());
        this.entity = entity;
    }
    public MyHateoasEntityModel(T entity, Link... links) {
        this(entity, Collections.emptyList());
    }

}
