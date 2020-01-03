package com.modally.library.base.basemvp

import android.os.Bundle
import com.modally.library.base.BaseFragment
import com.modally.library.base.basemvp.presenter.IPresenter
import com.modally.library.base.basemvp.view.BaseView

/**
 * 绑定生命周期的BaseMvpActivity包装类
 * @Date:2020-01-03
 * @Author LiuBo
 */
abstract class BaseMvpFragment<P : IPresenter>: BaseFragment(),
    BaseView {
    protected var mPresenter: P? = null

    protected abstract fun createPresenter(): P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
        if (mPresenter == null) {
            throw NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }
        //绑定生命周期
        lifecycle.addObserver(mPresenter!!)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mPresenter != null) {
            //解绑P层 避免内存泄漏
            lifecycle.removeObserver(mPresenter!!)
            mPresenter = null
            //通知系统进行一次回收
            System.gc()
        }
    }
}