package com.vaishnav.flobiz.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vaishnav.flobiz.data.repository.MainRepository
import com.vaishnav.flobiz.model.RecyclerViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.simplifiedcoding.multiviewlist.data.network.Resource
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _mainListItemsLiveData = MutableLiveData<Resource<List<RecyclerViewData>>>()
    val mainListItemsLiveData: LiveData<Resource<List<RecyclerViewData>>>
        get() = _mainListItemsLiveData

    fun getHomeListItems() = viewModelScope.launch {
        _mainListItemsLiveData.postValue(Resource.Loading)
        val data = repository.getQuestions()
        val mainItemsList = mutableListOf<RecyclerViewData>()
        if (data is Resource.Success) {
            data.value.items?.let { mainItemsList.addAll(it) }
            _mainListItemsLiveData.postValue(Resource.Success(mainItemsList))
        } else Resource.Failure(false, null, null)
    }
}