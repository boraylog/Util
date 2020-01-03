package com.modally.library.base.basemvp.presenter

import com.modally.library.base.basemvp.view.BaseView
import java.lang.ref.WeakReference


/**
 * 控制器基类：
 * Presenter生命周期包装、View的绑定和解除，P层实现的基类
 * @Date:2020-01-02
 * @Author LiuBo
 */
abstract class BasePresenter<V : BaseView>(view: V) :
    IPresenter {

    protected var viewRef: WeakReference<V>? = null

    protected fun getView(): V? {
        return viewRef!!.get()
    }

    protected open fun isViewAttach(): Boolean {
        return viewRef != null && viewRef!!.get() != null
    }

    private fun attachView(view: V) {
        viewRef = WeakReference(view)
    }

    override fun detachView() {
        if (viewRef != null) {
            viewRef!!.clear()
            viewRef = null
        }
    }

    init {
        attachView(view)
    }
}