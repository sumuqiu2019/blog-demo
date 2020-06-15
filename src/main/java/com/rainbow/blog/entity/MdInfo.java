package com.rainbow.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

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
@ApiModel(value = "MdInfo对象", description = "")
public class MdInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文章id")
    @TableId(value = "md_id", type = IdType.AUTO)
    private Integer mdId;

    private String mdTitle;

    @ApiModelProperty(value = "文章描述")
    private String mdDescribe;

    @ApiModelProperty(value = "md文档地址")
    private String mdUrl;

    @ApiModelProperty(value = "点击数（默认0）")
    private Integer mdClicks;

    @ApiModelProperty(value = "文档标签（,|,分割-|表示分割表示多个主分类；，表示所属小分类）")
    private String mdTags;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatedTime;


}
