package com.w20079934.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.w20079934.activities.Home
import com.w20079934.helpers.readImageFromPath
import com.w20079934.helpers.showImagePicker
import com.w20079934.main.DiaryApp
import com.w20079934.models.EntryModel
import com.w20079934.mydiary_2.R
import kotlinx.android.synthetic.main.content_home.*
import kotlinx.android.synthetic.main.content_home.view.*
import kotlinx.android.synthetic.main.fragment_entry.*
import kotlinx.android.synthetic.main.fragment_entry.view.*

class EntryFragment : Fragment() {

    lateinit var app : DiaryApp
    var entry = EntryModel()
    var edit = false
    val IMAGE_REQUEST=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = activity?.application as DiaryApp

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_entry, container, false)
        activity?.title = getString(R.string.menu_new_entry)

        if(activity?.intent?.hasExtra("entry_edit") == true) {
            edit = true
            entry = activity?.intent?.extras?.getParcelable<EntryModel>("entry_edit")!!
            root.entryTopic.setText(entry.topic)
            root.entryEntry.setText(entry.entry)
            if (entry.image != "")
            {
                root.entryImage.setImageBitmap(readImageFromPath(activity!!, entry.image))
                root.chooseImage.text = getString(R.string.button_changeImage)
            }
        }


        root.chooseImage.setOnClickListener {
            showImagePicker(activity!!, IMAGE_REQUEST)
        }
        root.btnAdd.setOnClickListener()
        {
            if (entryEntry.text.isNotEmpty()) {
                if(edit) {
                    entry.topic = entryTopic.text.toString()
                    entry.entry = entryEntry.text.toString()
                    app.entries.update(entry)

                } else {
                    entry.topic = entryTopic.text.toString()
                    entry.entry = entryEntry.text.toString()
                    app.entries.create(entry.copy())
                }

                (activity as Home).openFragment(R.id.nav_Diary) // return user back to the diary after submitting it


            } else {
                Toast.makeText(activity!!, getString(R.string.menu_invalidEntry), Toast.LENGTH_LONG).show()
            }
        }


        return root;
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                EntryFragment().apply {
                    arguments = Bundle().apply {}
                }
    }


}