package com.podo.hiltapplication.data

class CoolClassWithBuilder private constructor(
  val hero: Hero,
  val person: Person
) {

  fun doSomethingCool() {
    println("cool thing with builder! - ${hero.name} and ${person.counter}")
  }

  companion object {

    fun build(hero: Hero, person: Person): CoolClassWithBuilder {
      return CoolClassWithBuilder(hero, person)
    }
  }
}
