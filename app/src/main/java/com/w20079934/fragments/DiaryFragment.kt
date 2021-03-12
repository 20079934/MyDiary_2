package com.w20079934.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.w20079934.adapters.EntryAdapter
import com.w20079934.adapters.EntryListener
import com.w20079934.main.DiaryApp
import com.w20079934.models.EntryModel
import com.w20079934.mydiary_2.R
import kotlinx.android.synthetic.main.fragment_diary.view.*

class DiaryFragment : Fragment(), EntryListener {
    lateinit var app: DiaryApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = activity?.application as DiaryApp
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_diary, container, false)
        activity?.title = getString(R.string.hint_diaryName)//TODO get diary name here

        root.recyclerView.setLayoutManager(LinearLayoutManager(activity))
        root.recyclerView.adapter = EntryAdapter(app.entries.findAll(), this)

        return root;
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            DiaryFragment().apply {
                arguments = Bundle().apply {}
            }

    }

    fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        activity?.menuInflater?.inflate(R.menu.menu_diary, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                Toast.makeText(activity, getString(R.string.feature_notImplemented), Toast.LENGTH_LONG).show()
                true
            }
            R.id.diaryRename -> {
                Toast.makeText(activity, getString(R.string.feature_notImplemented), Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onEntryClick(entry: EntryModel) {
        Toast.makeText(activity, getString(R.string.feature_notImplemented), Toast.LENGTH_SHORT).show()
    }
}