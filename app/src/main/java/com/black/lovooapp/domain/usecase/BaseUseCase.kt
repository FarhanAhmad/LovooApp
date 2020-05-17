package com.black.lovooapp.domain.usecase

/**
 * Created by farhanahmad on 15/5/20.
 */
abstract class BaseUseCase {

    abstract suspend fun execute():List<Any>
}