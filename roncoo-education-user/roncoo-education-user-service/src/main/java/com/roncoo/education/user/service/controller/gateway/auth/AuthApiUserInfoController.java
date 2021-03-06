package com.roncoo.education.user.service.controller.gateway.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roncoo.education.user.common.bean.bo.auth.AuthUserUpdateBO;
import com.roncoo.education.user.common.interfaces.gateway.auth.AuthApiUserInfo;
import com.roncoo.education.user.service.biz.gateway.auth.AuthApiUserInfoBiz;
import com.roncoo.education.util.base.BaseController;
import com.roncoo.education.util.base.Result;

/**
 * 用户基本信息
 *
 * @author wuyun
 */
@RestController
public class AuthApiUserInfoController extends BaseController implements AuthApiUserInfo {

	@Autowired
	private AuthApiUserInfoBiz biz;

	@Override
	public Result<Integer> updatePassword(@RequestBody AuthUserUpdateBO authUserUpdateBO) {
		return biz.updatePassword(authUserUpdateBO);
	}

}
