package com.modally.library.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tbruyelle.rxpermissions2.RxPermissions

/**
 * 基础Fragment
 * @Date:2020-01-03
 * @Author LiuBo
 */
abstract class BaseFragment : Fragment() {
    protected var rxPermissions: RxPermissions? = null
    protected var mContext: Activity? = null
    /**
     * 视图是否加载完毕
     */
    private var isViewPrepare = false
    /**
     * 数据是否加载过了
     */
    private var hasLoadData = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = LayoutInflater.from(activity).inflate(intiLayout(), null)
        isViewPrepare = true
        mContext = activity
        return view!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initData()
        lazyLoadDataIfPrepared()
        initClick()
        rxPermissions = RxPermissions(this)
    }

    /**
     * 设置布局
     *
     * @return
     */
    protected abstract fun intiLayout(): Int

    protected abstract fun initView()

    protected abstract fun initClick()

    protected abstract fun initData()

    open fun isViewPrepare(): Boolean {
        return isViewPrepare
    }

    open fun setViewPrepare(viewPrepare: Boolean) {
        isViewPrepare = viewPrepare
    }

    open fun isHasLoadData(): Boolean {
        return hasLoadData
    }

    open fun setHasLoadData(hasLoadData: Boolean) {
        this.hasLoadData = hasLoadData
    }

    /**
     * 懒加载
     */
    protected abstract fun lazyLoad()

    private fun lazyLoadDataIfPrepared() {
        if (userVisibleHint && isViewPrepare && !hasLoadData) {
            lazyLoad()
            hasLoadData = true
        }
    }

    open fun startActivity(cls: Class<out Activity?>?) {
        startActivity(Intent(mContext, cls))
    }

    open fun startActivityForResult(cls: Class<out Activity?>?, requestCode: Int) {
        startActivityForResult(Intent(mContext, cls), requestCode)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyLoadDataIfPrepared()
        }
    }
}