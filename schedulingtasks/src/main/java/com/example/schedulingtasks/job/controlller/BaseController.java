package com.example.schedulingtasks.job.controlller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.security.auth.Subject;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class BaseController {

    protected Map<String, Object> getDataTable(IPage<?> pageInfo) {
        return getDataTable(pageInfo.getRecords(), pageInfo.getTotal());
    }

    protected Map<String, Object> getDataTable(Object rows, Object total) {
        Map<String, Object> data = new HashMap<>(4);
        data.put("rows", rows);
        data.put("total", total);
        return data;
    }

}
