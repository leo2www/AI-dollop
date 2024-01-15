package com.H.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// 数据类 new > package
data class Affirmation(
    // 属性添加注解。
    @StringRes val stringResourcedId: Int,
    @DrawableRes val imageResourceId: Int,
)

data class Dog(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int
)
