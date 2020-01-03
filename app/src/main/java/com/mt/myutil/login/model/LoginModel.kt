package com.mt.myutil.login.model

import android.text.TextUtils
import com.mt.myutil.login.contract.ILoginContract


/**
 * @describe
 * @author  LiuBo
 * @date 2020-01-03  09:54
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class LoginModel : ILoginContract.Model {
    override fun login(username: String?): Boolean {
        return !TextUtils.isEmpty(username)
    }
}

