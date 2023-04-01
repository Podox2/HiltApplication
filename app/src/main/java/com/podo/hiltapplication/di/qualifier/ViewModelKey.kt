package com.podo.hiltapplication.di.qualifier

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.reflect.KClass

// анотація, щоб вказати, що ми будемо провайдити саме тип ViewModel
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
