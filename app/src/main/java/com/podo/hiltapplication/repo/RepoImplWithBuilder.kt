package com.podo.hiltapplication.repo

class RepoImplWithBuilder private constructor() : Repo {

  override fun repoName() = "ConcreteRepoWithBuilder"

  companion object {

    fun build(): RepoImplWithBuilder {
      return RepoImplWithBuilder()
    }
  }
}