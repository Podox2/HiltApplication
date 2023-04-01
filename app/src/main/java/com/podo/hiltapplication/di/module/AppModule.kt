package com.podo.hiltapplication.di.module

import android.content.Context
import android.content.res.Resources
import com.podo.hiltapplication.data.CoolClassWithBuilder
import com.podo.hiltapplication.data.Hero
import com.podo.hiltapplication.data.Person
import com.podo.hiltapplication.di.qualifier.Luna
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// можна мати один головний модуль, в якому прописані всі модулі аплікухи
// можна ж прописати всі ці модулі в AppComponent (так зроблено в Kiosk)
@InstallIn(SingletonComponent::class)
@Module
class AppModule {

  @Provides
  fun provideHero() = Hero("Sven", 1000, 100)

  // власна анотація-кваліфікатор @Luna
  @Provides
  @Luna
  //@Named("Luna")
  fun provideHeroLuna() = Hero("Luna", 800, 200)

  // провайд, щоб десь використати контекст, як депенденсі
  @Provides
  fun provideResources(context: Context): Resources = context.resources

  // провайд класа з білдером. використовується в Актівіті для ін'єкції в поле
  @Provides
  fun provideCoolClass(@Luna hero: Hero, person: Person): CoolClassWithBuilder {
    return CoolClassWithBuilder.build(hero, person)
  }
}