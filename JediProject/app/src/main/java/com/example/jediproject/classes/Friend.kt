package com.example.jediproject.classes
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable
import java.util.*

open class Friend (
    var name: String = "",
    var Cognom: String = "",
    var edat : Int = 0,
    var videojoc: String = "",
    @PrimaryKey
    var nom_complet: String = name + Cognom): Serializable, RealmObject()