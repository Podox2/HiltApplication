package com.podo.hiltapplication.di.module

import com.podo.hiltapplication.repo.RepoImpl
import com.podo.hiltapplication.repo.Repo
import com.podo.hiltapplication.repo.RepoImplWithBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

// якщо є певний інтерфейс і треба провайдити його реалізцію, то треба використовувати @Provides або @Binds
// тому що неможливо заінджектити конструктор інтерфейсу (його не існує)

// краще використовувати @Binds - менше коду і кодогенерації
// при @Binds клас повинен бути абстрактним (тоді і всі методи абстрактні) або інтерфейсом (легший варіант, щоб не забути написати abstract)
@InstallIn(SingletonComponent::class)
@Module
interface ConcreteBindRepoModule {
  // в параметрах вказуємо тип, який будемо повертати
  // а вернути ми його можемо, якщо в класі є ін'єкція через конструктор, тому дагер зможе дістати цей тип
  // по суті ми байндимо тип Repo з RepoImpl. коли граф шукає тип Repo, то буде повертати RepoImpl
  @Binds
  fun bindConcreteModule(repoImpl: RepoImpl): Repo
}


// при @Provides використовуємо просто class, методи повинні мати реалізацію
@InstallIn(SingletonComponent::class)
@Module
class ConcreteProvideRepoModule {

  @Provides
  // метод повертає то й ж тип, що і bindConcreteModule(), тому додана анотація @Named, щоб білдилось і щоб їх розрізняти
  // такі провайди краще переробляти на @Binds, щоб було менше коду і кодогенерації
  @Named("by provide")
  fun provideConcreteModule(repoImpl: RepoImpl): Repo {
    return repoImpl
  }

  // якщо ж немає інджекта конструктора, то потрібно самому створювати об'єкт
  // наприклад, коли об'єкт створюється через білдер. В даному випадку не можливо використати @Binds
  @Provides
  @Named("RepoImplWithBuilder")
  fun provideConcreteModule2(): Repo {
    return RepoImplWithBuilder.build()
  }
}