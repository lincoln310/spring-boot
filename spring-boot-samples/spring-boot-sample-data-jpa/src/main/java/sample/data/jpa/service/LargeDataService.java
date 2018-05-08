package sample.data.jpa.service;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface LargeDataService {
    List get(Class clazz, Specification spec);
}
