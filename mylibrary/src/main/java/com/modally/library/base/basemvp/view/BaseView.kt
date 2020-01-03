package com.modally.library.base.basemvp.view

import android.content.Context

/**
 * 父mvp的View
 * @Date:2020-01-02
 * @Author LiuBo
 */

interface BaseView {

    /**
     * 显示进度条
     * @param msg   进度条加载内容
     */
    fun showLoading(msg: String?)

    /**
     * 隐藏进度条
     */
    fun hideLoading()

    /**
     * 显示加载错误
     * @param err 错误内容
     */
    fun showErr(err: String)

    /**
     * 显示登录的结果
     * @param result
     */
    fun showResult(result: String)

    /**
     * 判断是否有网络
     * @return 是否有网络
     */
    fun hasNetwork(context: Context?): Boolean
}