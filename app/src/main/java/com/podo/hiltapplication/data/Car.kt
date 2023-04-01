package com.podo.hiltapplication.data

import android.util.Log
import javax.inject.Inject

class Car @Inject constructor() {

  fun doSomething() {
    println("car did something")
    Log.d("DAGGER_TAG", "car did something")
  }
}