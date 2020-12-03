package com.example.myyoutube.ui.playlists

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import com.example.myyoutube.ui.playlists.adapter.PlaylistsAdapter
import com.example.myyoutube.R
import com.example.myyoutube.data.local.SharedPref
import com.example.myyoutube.data.models.PlaylistItems

import com.example.myyoutube.ui.detailPlaylist.DetailPlaylistActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import java.util.*
import java.util.prefs.Preferences

class MainPlaylistsActivity : AppCompatActivity() {
    private val viewModel by inject<PlaylistViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchPlaylists()
    }

    private fun initRecycler(list: MutableList<PlaylistItems>) {
        val adapter = PlaylistsAdapter(this::onItemClick)
        adapter.addItems(list)
        playlists_rv.adapter = adapter
    }

    private fun onItemClick(item: PlaylistItems) {
        item.apiId?.let { id ->
            DetailPlaylistActivity.instanceActivity(
                this,
                id,
                item.snippet?.title.toString()
            )
        }

    }

    private fun fetchPlaylists() {
        viewModel.playlists.observeForever {
            initRecycler(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.lang_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_lang_change -> {
                changeLanguage()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun Activity.changeLanguage() {
        val listItems = arrayOf("Русский", "English", "Кыргызча")
        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setTitle(getString(R.string.choose_lang))
        mBuilder.setSingleChoiceItems(listItems, -1) { dialog, which ->
            when (which) {
                0 -> {
                    setLocale("ru", this)
                }
                1 -> {
                    setLocale("en", this)
                }
                2 -> {
                    setLocale("ky", this)
                }
            }
            this.recreate()
            dialog.dismiss()
        }
        val mDialog = mBuilder.create()
        mDialog.show()
    }

    private fun setLocale(lang: String, context: Context) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        context.resources.updateConfiguration(
            config,
            context.resources.displayMetrics
        )
        SharedPref.getPrefInstance(context)?.saveLang(lang)
    }
    override fun onResume() {
        loadLocaleLang(this)
        super.onResume()
    }

    fun loadLocaleLang(context: Context) {
        var language: String? = SharedPref.getPrefInstance(context)?.lanquage
        if (language != null) {
            setLocale(language, context)
        }
    }
}