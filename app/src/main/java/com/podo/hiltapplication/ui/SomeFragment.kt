package com.podo.hiltapplication.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.podo.hiltapplication.data.CoolClass
import com.podo.hiltapplication.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SomeFragment : Fragment(R.layout.fragment_some) {

  @Inject
  lateinit var coolClass: CoolClass

  private val viewModel by viewModels<MainViewModel>()

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    view.findViewById<TextView>(R.id.tv_fragment).text = "Fragment with ${coolClass.returnString()} by Dagger2"
  }
}