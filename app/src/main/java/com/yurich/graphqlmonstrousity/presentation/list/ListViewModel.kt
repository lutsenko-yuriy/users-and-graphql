package com.yurich.graphqlmonstrousity.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yurich.graphqlmonstrousity.data.network.service.PostDataSource
import com.yurich.graphqlmonstrousity.domain.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val source: PostDataSource) : ViewModel() {

    private val privateAvailableVehiclesViewState = MutableLiveData(listOf<Post>())
    val availableVehiclesViewState: LiveData<List<Post>> = privateAvailableVehiclesViewState

    init {
        viewModelScope.launch {
            privateAvailableVehiclesViewState.value?.run {
                privateAvailableVehiclesViewState.postValue(
                    source.getPosts()
                )
            }
        }
    }

}