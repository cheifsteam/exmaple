package com.example.elasticsearchtry.controller;

import com.example.elasticsearchtry.api.CommonPage;
import com.example.elasticsearchtry.api.CommonResult;
import com.example.elasticsearchtry.domain.EsPerson;
import com.example.elasticsearchtry.service.EsPersonService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@RestController
public class EsPersOnController {
    @Autowired
    EsPersonService esPersonService;
    @PostMapping("importAll")
    public CommonResult<Integer> importAll(){
        final int i = esPersonService.importAll();
       return CommonResult.success(i);
    }
    @PostMapping("/search")
    public CommonResult<CommonPage<EsPerson>> search(@RequestParam Integer pageNum,@RequestParam Integer pageSize ,@RequestParam String  keyword){
        final Page<EsPerson> search = esPersonService.search(pageNum, pageSize, keyword);
        return CommonResult.success(CommonPage.restPage(search));
    }
    @PostMapping("/search/mysql")
    public CommonResult<CommonPage<EsPerson>> searchByMysql(@RequestParam Integer pageNum,@RequestParam Integer pageSize ,@RequestParam String  keyword){
        PageHelper.startPage(pageNum,pageSize);
        final List<EsPerson> search = esPersonService.searchByMysql(keyword);
        return CommonResult.success(CommonPage.restPage(search));
    }
}
