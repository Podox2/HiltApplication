package com.podo.hiltapplication.data

import com.podo.hiltapplication.di.qualifier.Luna
import javax.inject.Inject

class CoolClass @Inject constructor(
  @Luna
  val hero: Hero,
  val person: Person
) {

  fun doSomethingCool() {
    println("cool thing! - ${hero.name} and ${person.counter}")
  }

  fun returnString() = "string"
}