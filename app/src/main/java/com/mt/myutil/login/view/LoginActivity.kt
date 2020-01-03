package com.mt.myutil.login.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.modally.library.mvp.BaseMvpActivity
import com.mt.myutil.login.contract.ILoginContract
import com.mt.myutil.login.presenter.LoginPresenter
import com.mt.myutil.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @describe
 * @author  LiuBo
 * @date 2020-01-03  09:54
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class LoginActivity :
    BaseMvpActivity<LoginPresenter>(), ILoginContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        clilc.setOnClickListener {
            mPresenter!!.login("aaaa")
        }
    }

    override fun hasNetwork(context: Context?): Boolean = false

    override fun hideLoading() {

    }

    override fun initClick() {

    }

    override fun initView() {
    }

    override fun intiLayout(): Int  = R.layout.activity_main

    override fun showErr(err: String) {

    }

    override fun showTips(isSuccess: Boolean) {
        if (isSuccess) {
            Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "登录失败！", Toast.LENGTH_SHORT).show();
        }
    }

    override fun showLoading(msg: String?) {

    }

    override fun showResult(result: String) {

    }

    override fun createPresenter(): LoginPresenter {
        return LoginPresenter(this)
    }

}

