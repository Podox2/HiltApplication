package com.podo.hiltapplication.repo

import com.podo.hiltapplication.data.Person
import javax.inject.Inject

class RepoImpl @Inject constructor(
  val person: Person
) : Repo {

  override fun repoName() = "ConcreteRepo"
}