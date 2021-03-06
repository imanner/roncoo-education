package com.roncoo.education.course.common.bean.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.roncoo.education.user.common.bean.dto.LecturerDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 课程信息
 *
 * @author wujing
 */
@Data
@Accessors(chain = true)
public class CourseViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "课程ID")
	private Long id;
	/**
	 * 讲师用户编码
	 */
	@ApiModelProperty(value = "讲师用户编码")
	private Long lecturerUserNo;
	/**
	 * 课程名称
	 */
	@ApiModelProperty(value = "课程名称")
	private String courseName;
	/**
	 * 课程封面
	 */
	@ApiModelProperty(value = "课程封面")
	private String courseLogo;
	/**
	 * 课程介绍ID
	 */
	@ApiModelProperty(value = "课程介绍ID")
	private Long introduceId;
	/**
	 * 是否免费：1免费，0收费
	 */
	@ApiModelProperty(value = "是否免费：1免费，0收费")
	private Integer isFree;
	/**
	 * 原价
	 */
	@ApiModelProperty(value = "原价")
	private BigDecimal courseOriginal;
	/**
	 * 优惠价
	 */
	@ApiModelProperty(value = "优惠价")
	private BigDecimal courseDiscount;
	/**
	 * 购买人数
	 */
	@ApiModelProperty(value = "购买人数")
	private Integer countBuy;
	/**
	 * 学习人数
	 */
	@ApiModelProperty(value = "学习人数")
	private Integer countStudy;
	/**
	 * 总课时数
	 */
	@ApiModelProperty(value = "总课时数")
	private Integer periodTotal;

	/**
	 * 课程介绍
	 */
	@ApiModelProperty(value = "课程介绍")
	private String introduce;

	/**
	 * 讲师信息
	 */
	@ApiModelProperty(value = "讲师信息")
	private LecturerDTO lecturerDTO;
	/**
	 * 章节信息
	 */
	@ApiModelProperty(value = "章节信息")
	private List<CourseChapterDTO> courseChapterList;

}
