package com.example.test.service.impl;

import com.example.test.domain.MiProduct;
import com.example.test.mapper.MiProductMapper;
import com.example.test.service.MiProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class MiProductServiceImpl implements MiProductService {
    @Autowired
    private MiProductMapper miProductMapper;
    @Override
    public MiProduct selectByPrimaryKey(Long id)
    {
        return miProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public Long checkPrice(Long price)
    {
        if(price == null || price.compareTo(0L) < 0)
        {
                      return 0L;
        }
        return price;
    }

    @Override
    public Long queryPrice(String type) {
       return miProductMapper.queryPrice(type);
    }
}
