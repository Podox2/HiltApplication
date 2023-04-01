package com.podo.hiltapplication.repo

import javax.inject.Inject

class Store @Inject constructor() {

  fun getName() = "Store"
}