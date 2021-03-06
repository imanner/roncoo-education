package com.roncoo.education.course.service.biz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.roncoo.education.util.tools.DateUtil;
import com.roncoo.education.course.common.bean.qo.CourseUserStudyLogQO;
import com.roncoo.education.course.common.bean.vo.CourseUserStudyLogVO;
import com.roncoo.education.course.service.dao.CourseChapterDao;
import com.roncoo.education.course.service.dao.CourseChapterPeriodDao;
import com.roncoo.education.course.service.dao.CourseDao;
import com.roncoo.education.course.service.dao.CourseUserStudyLogDao;
import com.roncoo.education.course.service.dao.impl.mapper.entity.Course;
import com.roncoo.education.course.service.dao.impl.mapper.entity.CourseChapter;
import com.roncoo.education.course.service.dao.impl.mapper.entity.CourseChapterPeriod;
import com.roncoo.education.course.service.dao.impl.mapper.entity.CourseUserStudyLog;
import com.roncoo.education.course.service.dao.impl.mapper.entity.CourseUserStudyLogExample;
import com.roncoo.education.course.service.dao.impl.mapper.entity.CourseUserStudyLogExample.Criteria;
import com.roncoo.education.util.base.Page;
import com.roncoo.education.util.base.PageUtil;
import com.roncoo.education.util.tools.BeanUtil;

/**
 * 课程用户学习日志
 *
 * @author wujing
 */
@Component
public class BossCourseUserStudyLogBiz {

	@Autowired
	private CourseUserStudyLogDao dao;
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private CourseChapterDao chapterDao;
	@Autowired
	private CourseChapterPeriodDao periodDao;

	public Page<CourseUserStudyLogVO> listForPage(CourseUserStudyLogQO qo) {
		CourseUserStudyLogExample example = new CourseUserStudyLogExample();
		Criteria c = example.createCriteria();
		c.andUserNoEqualTo(qo.getUserNo());
		if (StringUtils.hasText(qo.getBeginGmtCreate())) {
			c.andGmtCreateGreaterThanOrEqualTo(DateUtil.parseDate(qo.getBeginGmtCreate(), "yyyy-MM-dd"));
		}
		if (StringUtils.hasText(qo.getEndGmtCreate())) {
			c.andGmtCreateLessThanOrEqualTo(DateUtil.addDate(DateUtil.parseDate(qo.getEndGmtCreate(), "yyyy-MM-dd"), 1));
		}
		example.setOrderByClause(" id desc ");
		Page<CourseUserStudyLog> page = dao.listForPage(qo.getPageCurrent(), qo.getPageSize(), example);
		Page<CourseUserStudyLogVO> voList = PageUtil.transform(page, CourseUserStudyLogVO.class);
		for (CourseUserStudyLogVO courseUserStudyLogVO : voList.getList()) {
			if (courseUserStudyLogVO.getCourseId() != null || courseUserStudyLogVO.getCourseId() != 0) {
				Course course = courseDao.getById(courseUserStudyLogVO.getCourseId());
				courseUserStudyLogVO.setCourseName(course.getCourseName());
			}
			if (courseUserStudyLogVO.getChapterId() != null || courseUserStudyLogVO.getChapterId() != 0) {
				CourseChapter chapter = chapterDao.getById(courseUserStudyLogVO.getChapterId());
				courseUserStudyLogVO.setChapterName(chapter.getChapterName());
			}
			if (courseUserStudyLogVO.getPeriodId() != null || courseUserStudyLogVO.getPeriodId() != 0) {
				CourseChapterPeriod period = periodDao.getById(courseUserStudyLogVO.getPeriodId());
				courseUserStudyLogVO.setPeriodName(period.getPeriodName());
			}
		}
		return voList;
	}

	public int save(CourseUserStudyLogQO qo) {
		CourseUserStudyLog record = BeanUtil.copyProperties(qo, CourseUserStudyLog.class);
		return dao.save(record);
	}

	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	public CourseUserStudyLogVO getById(Long id) {
		CourseUserStudyLog record = dao.getById(id);
		return BeanUtil.copyProperties(record, CourseUserStudyLogVO.class);
	}

	public int updateById(CourseUserStudyLogQO qo) {
		CourseUserStudyLog record = BeanUtil.copyProperties(qo, CourseUserStudyLog.class);
		return dao.updateById(record);
	}

}
