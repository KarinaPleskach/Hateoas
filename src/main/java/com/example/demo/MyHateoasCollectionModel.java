package com.example.demo;

import java.util.Collections;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;

public class MyHateoasCollectionModel<T> extends CollectionModel<T> {

    public MyHateoasCollectionModel(Iterable<T> content, Link... links) {
        super(content, Collections.emptyList());
    }

}
