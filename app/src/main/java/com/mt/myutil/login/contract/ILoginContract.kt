package com.mt.myutil.login.contract

import com.modally.library.mvp.BaseModel
import com.modally.library.mvp.BaseView
import com.modally.library.mvp.IPresenter


/**
 * @describe
 * @author  LiuBo
 * @date 2020-01-03  09:54
 * 								 - generate by MvpAutoCodePlus plugin.
 */

interface ILoginContract {
    interface View : BaseView {
        fun showTips(isSuccess: Boolean)
    }
    interface Presenter : IPresenter {
        fun login(username: String?)
    }
    interface Model : BaseModel {
        fun login(username: String?): Boolean
    }
}
