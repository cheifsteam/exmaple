package com.example.test.service;

import com.example.test.domain.MiProduct;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public interface MiProductService {

    MiProduct selectByPrimaryKey(Long id);

   Long checkPrice(Long price);

   Long queryPrice(String type);


}
