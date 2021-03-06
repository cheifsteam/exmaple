package com.example.ossupload.dto;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class OssCallbackParam {
//    @ApiModelProperty("请求的回调地址")
    private String callbackUrl;
//    @ApiModelProperty("回调是传入request中的参数")
    private String callbackBody;
//    @ApiModelProperty("回调时传入参数的格式，比如表单提交形式")
    private String callbackBodyType;

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public String getCallbackBody() {
        return callbackBody;
    }

    public String getCallbackBodyType() {
        return callbackBodyType;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public void setCallbackBody(String callbackBody) {
        this.callbackBody = callbackBody;
    }

    public void setCallbackBodyType(String callbackBodyType) {
        this.callbackBodyType = callbackBodyType;
    }
}
