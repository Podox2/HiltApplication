package com.podo.hiltapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.podo.hiltapplication.data.CoolClass
import com.podo.hiltapplication.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

  @Inject
  lateinit var coolClass: CoolClass

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_second)

    coolClass.doSomethingCool()

    findViewById<TextView>(R.id.tv).text = "Second Activity with ${coolClass.returnString()} by Dagger2"

    supportFragmentManager
      .beginTransaction()
      .add(R.id.fragment_container, SomeFragment())
      .commit()
  }
}