package com.example.elasticsearchtry.service;

import com.example.elasticsearchtry.domain.EsPerson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public interface EsPersonRepository extends ElasticsearchRepository<EsPerson,Long> {
    Page<EsPerson> findByUsernameOrCityOrCountry(String username, String city, String country, Pageable page);
}
