package com.example.ossupload.service;

import com.example.ossupload.dto.OssCallbackResult;
import com.example.ossupload.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public interface OssService  {

    /**
     * oss上传管理Service
     * Created by macro on 2018/5/17.
     */
        /**
         * oss上传策略生成
         */
        OssPolicyResult policy();

        /**
         * oss上传成功回调
         */
        OssCallbackResult callback(HttpServletRequest request);

}
