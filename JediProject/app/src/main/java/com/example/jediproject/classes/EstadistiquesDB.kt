package com.example.jediproject.classes


import io.realm.Realm

object estadistiquesDb {
    val realm: Realm = Realm.getDefaultInstance()



    fun addRecord(record: Record) {
        realm.executeTransaction { it.copyToRealm(record)
        }
    }

    fun getAll():List<Record> {
        return realm.where(
            Record::class.java).findAll()

    }

    fun deleteRecord(record: Record) {
        realm.executeTransaction { record.deleteFromRealm()
        }


    }


}