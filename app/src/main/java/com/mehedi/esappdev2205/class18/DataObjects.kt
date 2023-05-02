package com.mehedi.esappdev2205.class18

import com.mehedi.esappdev2205.class18.models.User

object DataObjects {


    private lateinit var user: User

    fun sendUser(user: User) {
        this.user = user

    }

    fun receiveUser(): User {
        return user
    }


}