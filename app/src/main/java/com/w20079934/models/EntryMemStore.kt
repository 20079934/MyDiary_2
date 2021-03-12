package com.w20079934.models

import android.content.Context
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

var currID = 0L
var diaryName = "World"

internal fun getId(): Long {
    return currID++
}

class EntryMemStore : EntryStore {

    val context: Context
    val entries = ArrayList<EntryModel>()

    constructor (context: Context) {
        this.context = context
    }

    override fun findAll(): List<EntryModel> {
        return entries
    }

    fun getTodaysDate(): Map<String, Int> {
        val currDate = LocalDate.now()
        return mapOf<String,Int>("year" to currDate.year, "month" to currDate.monthValue, "day" to currDate.dayOfMonth)
    }

    override fun create(entry: EntryModel) {
        entry.id = getId()
        entry.date = getTodaysDate()
        entries.add(entry)
    }

    fun findOne(id: Long): EntryModel? {
        val foundEntry: EntryModel? = entries.find { p -> p.id == id }
        return foundEntry
    }



    override fun update(entry: EntryModel)
    {
        val foundEntry = findOne(entry.id)
        if (foundEntry != null) {
            foundEntry.topic = entry.topic
            foundEntry.entry = entry.entry
            foundEntry.image = entry.image
        }
    }


    override fun updateName(name: String) {
        diaryName = name
    }

    override fun getName(): String {
        return diaryName
    }

    override fun remove(entry: EntryModel) {
        entries.remove(entry)
    }
}