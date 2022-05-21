package com.example.elasticsearchtry.service.impl;

import com.example.elasticsearchtry.domain.EsPerson;
import com.example.elasticsearchtry.mapper.EsPersonMapper;
import com.example.elasticsearchtry.service.EsPersonRepository;
import com.example.elasticsearchtry.service.EsPersonService;
import com.github.pagehelper.PageHelper;
import org.elasticsearch.common.lucene.search.function.FunctionScoreQuery;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Service
public class EsPersonServiceImpl implements EsPersonService {

    @Autowired
    private EsPersonMapper esPersonMapper;
    @Autowired
    private EsPersonRepository esPersonRepository;
    @Override
    public int importAll() {
         List<EsPerson> esPeople = esPersonMapper.selectEsPersonList(null);
        final Iterable<EsPerson> esPeople1 = esPersonRepository.saveAll(esPeople);
        final Iterator<EsPerson> iterator = esPeople1.iterator();
        int result=0;
        while (iterator.hasNext()){
            iterator.next();
            result++;
        }
        return result;
    }

//    @Override
//    public Page<EsPerson> search(Integer pageNum, Integer pageSize, String keyword) {
//        Pageable pageable =PageRequest.of(pageNum,pageSize);
//        return  esPersonRepository.findByUsernameOrCityOrCountry(keyword,keyword,keyword,pageable);
//    }

    @Override
    public List<EsPerson> searchByMysql(String keyword) {
        return esPersonMapper.searchByMysql(keyword);
    }

    @Override
    public Page<EsPerson> search(Integer pageNum, Integer pageSize,String keyword ) {
        Pageable pageable=PageRequest.of(pageNum,pageSize);
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withPageable(pageable);
     List<FunctionScoreQueryBuilder.FilterFunctionBuilder> filterFunctionBuilders=new ArrayList<>();
     filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("name",keyword),ScoreFunctionBuilders.weightFactorFunction(10)));
     filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("city",keyword),ScoreFunctionBuilders.weightFactorFunction(5)));
     filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("country",keyword),ScoreFunctionBuilders.weightFactorFunction(2)));
     FunctionScoreQueryBuilder.FilterFunctionBuilder[] builders=new FunctionScoreQueryBuilder.FilterFunctionBuilder[filterFunctionBuilders.size()];
     filterFunctionBuilders.toArray(builders);
     FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(builders).scoreMode(FunctionScoreQuery.ScoreMode.SUM).setMinScore(2);
     nativeSearchQueryBuilder.withQuery(functionScoreQueryBuilder);
     NativeSearchQuery searchQuery =nativeSearchQueryBuilder.build();
     return  esPersonRepository.search(searchQuery);
    }


}



