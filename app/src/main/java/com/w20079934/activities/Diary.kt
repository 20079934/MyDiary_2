package com.w20079934.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.w20079934.adapters.EntryAdapter
import com.w20079934.adapters.EntryListener
import com.w20079934.main.DiaryApp
import com.w20079934.models.EntryModel
import com.w20079934.mydiary_2.R
import kotlinx.android.synthetic.main.activity_diary.*

class Diary : AppCompatActivity(), EntryListener {
    lateinit var app: DiaryApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        app = this.application as DiaryApp
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.adapter = EntryAdapter(app.entries.findAll(), this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_diary, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                startActivity(Intent(this,Entry::class.java))
                true
            }
            R.id.diaryRename -> {
                Toast.makeText(this, getString(R.string.feature_notImplemented), Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onEntryClick(entry: EntryModel) {
        Toast.makeText(this, getString(R.string.feature_notImplemented), Toast.LENGTH_SHORT).show()
    }
}