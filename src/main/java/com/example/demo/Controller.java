package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/test")
    public ResponseEntity<?> index() {
        List<DemoEntity> all = Arrays.asList(new DemoEntity(1L, "first"),
                                            new DemoEntity(2L, "second"),
                                            new DemoEntity(3L, "third"));
        List<EntityModel<DemoEntity>> list = new ArrayList<>();
        all.forEach(demoEntity -> list.add(new EntityModel<>(demoEntity)));
        CollectionModel<EntityModel<DemoEntity>> collectionModel = new CollectionModel<>(list);
        return ResponseEntity.ok(collectionModel);
    }
}
