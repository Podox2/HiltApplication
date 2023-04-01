package com.podo.hiltapplication.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.podo.hiltapplication.data.CoolClassWithBuilder
import com.podo.hiltapplication.data.Hero
import com.podo.hiltapplication.repo.Repo
import com.podo.hiltapplication.repo.Store
import com.podo.hiltapplication.di.qualifier.Luna
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  // про ін'єкцію інтерфейсів написано в ConcreteRepoModule
  private val concreteRepo: Repo,
  // тут відбувається ін'єкція конкретного класу через ін'єкцію конструктора, тому Store не потрібно якось надавати через @Provide або @Binds
  private val store: Store,
  // ін'єкція конкретного класу через @Provides в AppModule
  @Luna
  private val hero: Hero,
  // ін'єкція класу через @Provides в AppModule, в якого приватний конструктор, але є builder
  private val coolClassWithBuilder: CoolClassWithBuilder
) : ViewModel() {

  fun test() {
    Log.d("DAGGER_TAG", "ConcreteViewModel with ${concreteRepo.repoName()}, ${store.getName()}, and ${hero.name}, also ${coolClassWithBuilder.hero.name}")
  }
}