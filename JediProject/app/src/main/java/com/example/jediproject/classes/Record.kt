package com.example.jediproject.classes


import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Record(
    var name: String = "",
    var score: String = "",
    @PrimaryKey
    var date: String = ""
): RealmObject()