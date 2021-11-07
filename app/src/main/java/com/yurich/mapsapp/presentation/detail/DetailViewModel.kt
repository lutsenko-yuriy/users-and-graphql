package com.yurich.mapsapp.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yurich.mapsapp.data.network.service.PostDataSource
import com.yurich.mapsapp.domain.Post
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

class DetailViewModel @AssistedInject constructor(
    private val postDataSource: PostDataSource,
    @Assisted private val postId: String
) : ViewModel() {

    private val privateSelectedVehicleViewState = MutableLiveData<Post>()
    val selectedPostViewState: LiveData<Post> = privateSelectedVehicleViewState

    @AssistedFactory
    interface DetailViewModelFactory {
        fun create(postId: String): DetailViewModel
    }

    companion object {
        fun provideFactory(
            detailViewModelFactory: DetailViewModelFactory,
            postId: String
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return detailViewModelFactory.create(postId) as T
            }
        }
    }
}