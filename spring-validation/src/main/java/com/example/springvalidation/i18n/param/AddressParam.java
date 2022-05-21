package com.example.springvalidation.i18n.param;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Data
@Builder
@AllArgsConstructor
@ApiModel("Address")
public class AddressParam
{
    private String city;

    private String zipcode;
}
