package com.roncoo.education.course.common.interfaces.gateway.auth;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roncoo.education.course.common.bean.bo.auth.AuthCourseVideoDeleteBO;
import com.roncoo.education.course.common.bean.bo.auth.AuthCourseVideoSaveBO;
import com.roncoo.education.course.common.bean.bo.auth.AuthCourseVideoUpdateBO;
import com.roncoo.education.course.common.bean.dto.auth.AuthCourseVideoListDTO;
import com.roncoo.education.util.base.Result;

import io.swagger.annotations.ApiOperation;

/**
 * 课程视频信息
 *
 * @author wuyun
 */
public interface AuthApiCourseVideo {

	/**
	 * 章节视频库，课时视频库添加接口
	 * 
	 * @param authCourseVideoSaveBo
	 * @author wuyun
	 */
	@ApiOperation(value = "讲师视频库保存接口", notes = "讲师视频库保存接口")
	@RequestMapping(value = "/auth/course/api/course/video/save", method = RequestMethod.POST)
	Result<Integer> save(@RequestBody AuthCourseVideoSaveBO authCourseVideoSaveBo);

	/**
	 * 章节视频库列出（右边的展示）
	 * 
	 * @param chapterId
	 * @author wuyun
	 */
	@ApiOperation(value = "章节视频库列出接口", notes = "根据章节ID列出讲师章节视频库信息")
	@RequestMapping(value = "/auth/course/api/course/video/list/chapter/{chapterId}", method = RequestMethod.POST)
	Result<AuthCourseVideoListDTO> listByChapterId(@PathVariable(name = "chapterId") Long chapterId);

	/**
	 * 课时视频列出（左边的展示）
	 * 
	 * @param periodId
	 * @author wuyun
	 */
	@ApiOperation(value = "课时视频列出接口", notes = "根据课时ID列出讲师课时视频信息")
	@RequestMapping(value = "/auth/course/api/course/video/list/period/{periodId}", method = RequestMethod.POST)
	Result<AuthCourseVideoListDTO> listByPeriodId(@PathVariable(name = "periodId") Long periodId);

	/**
	 * 课时视频更新接口
	 * 
	 * @param authCourseVideoUpdateBo
	 * @author wuyun
	 */
	@ApiOperation(value = "课时视频更新接口", notes = "讲师课时视频更新信息")
	@RequestMapping(value = "/auth/course/api/course/video/update", method = RequestMethod.POST)
	Result<Integer> update(@RequestBody AuthCourseVideoUpdateBO authCourseVideoUpdateBo);

	/**
	 * 视频删除
	 * 
	 * @param authCourseVideoDeleteBO
	 * @author wuyun
	 */
	@ApiOperation(value = "删除接口", notes = "讲师视频信息删除")
	@RequestMapping(value = "/auth/course/api/course/video/delete", method = RequestMethod.POST)
	Result<Integer> udpateById(@RequestBody AuthCourseVideoDeleteBO authCourseVideoDeleteBO);

}
