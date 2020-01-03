package com.modally.library.base

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tbruyelle.rxpermissions2.RxPermissions

/**
 * 基础Activity
 * @Date:2020-01-03
 * @Author LiuBo
 */
abstract class BaseActivity : AppCompatActivity() {
    protected var rxPermissions: RxPermissions? = null
    protected var mContext: Activity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rxPermissions = RxPermissions(this)
        mContext = this
        //设置布局
        setContentView(intiLayout())
        initView()
        initClick()
        initData()
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
}