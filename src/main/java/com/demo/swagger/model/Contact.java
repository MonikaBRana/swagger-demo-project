package com.demo.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Details about the contact")
public class Contact {

    @ApiModelProperty("The unique id of the contact")
    private String id;

    @ApiModelProperty("The name of the contact")
    private String name;

    @ApiModelProperty("The number of the contact")
    private String number;
}
