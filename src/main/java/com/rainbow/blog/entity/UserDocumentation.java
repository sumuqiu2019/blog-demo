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
 * 用户——文档表
 * </p>
 *
 * @author 邢晨旭
 * @since 2020-08-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserDocumentation对象", description="用户——文档表")
public class UserDocumentation implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "自增id")
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	@ApiModelProperty(value = "用户id")
	private String userId;

	@ApiModelProperty(value = "文档id")
	private String docId;

	@ApiModelProperty(value = "赞或踩（默认0无；1赞；2踩）")
	private String praiseOrTread;

	@ApiModelProperty(value = "备注")
	private String remark;

	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createTime;

	@ApiModelProperty(value = "创建人id")
	private Long createId;

	@ApiModelProperty(value = "更新时间")
	private LocalDateTime updateTime;

	@ApiModelProperty(value = "更新人id")
	private Long updateId;


		}
