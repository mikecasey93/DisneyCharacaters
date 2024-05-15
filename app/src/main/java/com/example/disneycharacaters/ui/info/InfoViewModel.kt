package com.example.disneycharacaters.ui.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneycharacaters.data.model.disney_package.DisneyItemModel
import com.example.disneycharacaters.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    private val _gameList = MutableLiveData<DisneyItemModel>()
    val gameList: LiveData<DisneyItemModel> = _gameList

    init {
        getGamesList()
    }

    private fun getGamesList() {
        viewModelScope.launch {
            val result = repository.getVideoGame()
            if(result != null) {
                _gameList.postValue(result)
            }
        }
    }
}