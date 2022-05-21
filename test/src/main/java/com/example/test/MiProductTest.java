package com.example.test;

import com.example.test.domain.MiProduct;
import com.example.test.mapper.MiProductMapper;
import com.example.test.service.MiProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */

//spy 和 mock不同，不同点是：
//
//        spy 的参数是对象示例，mock 的参数是 class。
//        被 spy 的对象，调用其方法时默认会走真实方法。mock 对象不会。
public class MiProductTest
{
    @Spy
    MiProductService miProductService;

    @Mock
    MiProductMapper miProductMapper;
    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testQueryMiProduct()
    {
        Long id=1l;
        final MiProduct miProduct = new MiProduct();
        miProduct.setId(id);
        miProduct.setType("小米1");
        miProduct.setSalePrice(1330L);
        Mockito.when(miProductService.selectByPrimaryKey(id)).thenReturn(miProduct);
        MiProduct dto = miProductService.selectByPrimaryKey(id);
        assertNotNull(dto);
        assertEquals(1330L, dto.getSalePrice());
        assertEquals("小米1",dto.getType());
        assertEquals(2L,dto.getId());
    }


    @Test
    public void testQuery(){

    }
}
