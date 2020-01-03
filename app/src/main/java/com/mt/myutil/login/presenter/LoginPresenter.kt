package com.mt.myutil.login.presenter

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import com.modally.library.mvp.BasePresenter
import com.mt.myutil.login.contract.ILoginContract
import com.mt.myutil.login.model.LoginModel

/**
 * @describe
 * @author  LiuBo
 * @date 2020-01-03  09:54
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class LoginPresenter(private val view: ILoginContract.View) :
    BasePresenter<ILoginContract.View>(view), ILoginContract.Presenter {
    private var loginModel: LoginModel = LoginModel()

    override fun login(username: String?) {
        if (isViewAttach()) {
            view.showTips(loginModel.login(username))
        }
    }

    override fun onCreate(owner: LifecycleOwner) {
        Log.e("onCreate--->","onCreate")
    }

    override fun onMvpDestroy(owner: LifecycleOwner) {
        Log.e("onMvpDestroy--->","onMvpDestroy")

    }

    override fun onMvpPause(owner: LifecycleOwner) {
        Log.e("onMvpPause--->","onMvpPause")

    }

    override fun onMvpResume(owner: LifecycleOwner) {
        Log.e("onMvpResume--->","onMvpResume")

    }

    override fun onMvpStart(owner: LifecycleOwner) {
        Log.e("onMvpStart--->","onMvpStart")

    }

    override fun onMvpStop(owner: LifecycleOwner) {
        Log.e("onMvpStop--->","onMvpStop")

    }

    override fun onLifeCycleChanged(owner: LifecycleOwner) {
        Log.e("onLifeCycleChanged--->","onLifeCycleChanged${owner.lifecycle.currentState}")

    }

}

