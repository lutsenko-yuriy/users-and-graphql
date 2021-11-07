package com.yurich.mapsapp.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yurich.mapsapp.domain.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel() {

    private val privateSelectedVehicleViewState = MutableLiveData<Post>()
    val selectedPostViewState: LiveData<Post> = privateSelectedVehicleViewState

}