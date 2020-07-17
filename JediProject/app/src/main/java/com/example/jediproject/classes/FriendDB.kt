package com.example.jediproject.classes

import io.realm.Realm
import okhttp3.internal.notify
import okhttp3.internal.notifyAll

object friendDB {
    val realm: Realm = Realm.getDefaultInstance()


    fun addFriend(friend: Friend) {
        realm.executeTransaction {
            it.copyToRealm(friend)
        }
    }

    fun getAll(): List<Friend> {
        return realm.where(
            Friend::class.java
        ).findAll()

    }

    fun deleteFriend(name: String , cognom:String):Boolean {
        val list = getAll()
        for(item in list) {
            if(item.name == name && item.Cognom == cognom) {
                realm.executeTransaction {
                    item.deleteFromRealm()
                }
                return true
            }

        }
        return false
    }


}