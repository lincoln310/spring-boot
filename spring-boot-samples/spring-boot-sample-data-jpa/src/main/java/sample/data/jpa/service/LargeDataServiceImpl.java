package sample.data.jpa.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component("largeDataService")
public class LargeDataServiceImpl implements LargeDataService{

    private final EntityManagerFactory entityManagerFactory;

    public LargeDataServiceImpl(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List get(Class clazz, Specification spec) {
        EntityManager tmp = entityManagerFactory.createEntityManager();
        return RepositoryHelper.createPredicate(tmp, clazz, spec).getResultList();
    }
}
