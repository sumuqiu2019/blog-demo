package com.rainbow.blog.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "QunestionInfo对象", description = "")
public class QunestionInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer questionId;

    private String questionInfo;

    @ApiModelProperty(value = "问题提交时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "问题更新时间（回答时间）")
    private LocalDateTime updatedTime;

    @ApiModelProperty(value = "问题回答链接")
    private String mdUrl;


}
