package com.example.elasticsearchtry.service.impl;

import com.example.elasticsearchtry.domain.EsPerson;
import com.example.elasticsearchtry.mapper.EsPersonMapper;
import com.example.elasticsearchtry.service.EsPersonRepository;
import com.example.elasticsearchtry.service.EsPersonService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    @Override
    public Page<EsPerson> search(Integer pageNum, Integer pageSize, String keyword) {
        Pageable pageable =PageRequest.of(pageNum,pageSize);
        return  esPersonRepository.findByUsernameOrCityOrCountry(keyword,keyword,keyword,pageable);
    }

    @Override
    public List<EsPerson> searchByMysql(String keyword) {
        return esPersonMapper.searchByMysql(keyword);
    }


}



