package com.example.disneycharacaters.ui.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneycharacaters.data.model.disney.DisneyCharactersModel
import com.example.disneycharacaters.data.repository.Repoistory
import com.example.disneycharacters.ui.disney.DisneyViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    val repository: Repoistory
) : ViewModel() {

    private val _gameList = MutableLiveData<DisneyCharactersModel>()
    val gameList: LiveData<DisneyCharactersModel> = _gameList

    init {
        getGamesList()
    }

    private fun getGamesList() {
        viewModelScope.launch {
            val result = repository.getVideoGames()
            if(result != null) {
                _gameList.postValue(result)
            }
        }
    }
}