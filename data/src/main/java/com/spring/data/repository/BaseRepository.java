package com.spring.data.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created by mint on 8/19/18.
 */

@Repository
public class BaseRepository {

    private final Logger logger = LoggerFactory.getLogger(BaseRepository.class);

    public static final Integer DEFAULT_PAGE_INDEX = 0;
    public static final Integer DEFAULT_PAGE_SIZE = 10;

    @PersistenceContext
    protected EntityManager entityManager;

    public <T> List<T> find(String queryString, Map<String, Object> params, Integer offset, Integer fetchSize) {
        StopWatch watch = new StopWatch();
        watch.start("Query start:");
        try {
            Query query = entityManager.createQuery(queryString);
            if (null != params) {
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
            }

            if (null != offset) {
                query.setFirstResult(offset);
            }

            if (null != fetchSize) {
                query.setMaxResults(fetchSize);
            }

            return query.getResultList();
        } finally {
            watch.stop();
            logger.debug("find, query={}, params={},offset={},fetchSize={}, elapsedTime={}", queryString, params, offset, fetchSize, watch.getTotalTimeMillis());
        }
    }

    public <T> T findUniqueResult(String queryString, Map<String, Object> params) {
        List<T> results = find(queryString, params, null, null);
        if (results.isEmpty()) {
            return null;
        }

        if (results.size() > 1) {
            throw new NonUniqueResultException("result returned more than one element, returnedSize=" + results.size());
        }

        return results.get(0);
    }


}
