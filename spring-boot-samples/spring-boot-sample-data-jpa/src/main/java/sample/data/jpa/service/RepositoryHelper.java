package sample.data.jpa.service;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RepositoryHelper {

    public static TypedQuery createPredicate(EntityManager entityManager, Class clazz, Specification specification){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery query = criteriaBuilder.createQuery(clazz);
        final Root root = query.from(clazz);

        Predicate predicate = specification.toPredicate(root, query, criteriaBuilder);

        query.where(predicate);

        return entityManager.createQuery(query);
    }

}
