package com.example.myyoutube.di

import com.example.myyoutube.data.local.DataBaseClient
import com.example.myyoutube.data.repository.YoutubeRepository
import com.example.myyoutube.data.network.provideYoutubeApi
import com.example.myyoutube.ui.detailPlaylist.DetailPlaylistViewModel
import com.example.myyoutube.ui.playlists.PlaylistViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dbModule = module {
    single { DataBaseClient().providePlaylistDao(get()) }
    single { DataBaseClient().provideDatabase(androidContext()) }
}
val viewModelModule = module {
    viewModel { PlaylistViewModel(get()) }
    viewModel { DetailPlaylistViewModel(get()) }
}
var repositoryModule = module {
    factory { YoutubeRepository(get(), get()) }
}
var networkModule = module {
    single { provideYoutubeApi() }
}

