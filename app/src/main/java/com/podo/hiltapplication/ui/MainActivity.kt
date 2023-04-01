package com.podo.hiltapplication.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.podo.hiltapplication.data.Car
import com.podo.hiltapplication.data.CoolClass
import com.podo.hiltapplication.data.CoolClassWithBuilder
import com.podo.hiltapplication.data.Hero
import com.podo.hiltapplication.data.Person
import com.podo.hiltapplication.di.qualifier.Luna
import com.podo.hiltapplication.R
import dagger.Lazy
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  // в актівіті не можна інджектити в конструктор, тому інджектимо в поля

  // в'ю модельку можна отримати кількома шляхами, але не можна її просто інджектити
  // (бо в'ю модельку треба отримувати через спеціальну фабрику, а не через конструктор)
  private val viewModel: MainViewModel by viewModels()

  // якщо депенденсі потрібне не завжди, то можна вказати, щоб воно було впровайджене в момент виклику (лінива ініціалізація)
  @Inject
  lateinit var car: Lazy<Car>

  // надає щоразу новий інстенс об'єкта. використовується, наприклад, для в ViewModelFactory
  @Inject
  lateinit var person: Provider<Person>

  @Inject
  lateinit var coolClass: CoolClass

  @Inject
  lateinit var coolClassWithBuilder: CoolClassWithBuilder

  // поле використовується в методі, який викликається одного разу при старті. можна замінити ін'єкцією в метод
  /*@Inject
  lateinit var hero: Hero*/

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)


    findViewById<TextView>(R.id.tv_hello).setOnClickListener {
      startActivity(Intent(this, SecondActivity::class.java))
    }
    viewModel.test()

    // замінено ін'єкцією в метод
    //showHero(hero)

    // ініціалізація тільки в якийсь випадок
    val random = (0..2).shuffled().first()
    if (random == 1) {
      // для Lazy<> треба робити get()
      car.get().doSomething()
    }

    coolClass.doSomethingCool()
    coolClassWithBuilder.doSomethingCool()
  }

  // ін'єкція в метод
  // використовується коли треба зробити якусь дію один раз, при наданні залежностей класу
  // тобто в метод інджектиться аргумент hero
  // @Luna чомусь не спрацьовує
  @Inject
  @Luna
  fun showHero(hero: Hero) {
    Log.d("DAGGER_TAG", "showHero: ${hero.name}")
  }
}