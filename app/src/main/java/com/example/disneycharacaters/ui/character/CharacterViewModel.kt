package com.example.disneycharacaters.ui.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneycharacaters.data.model.disney_package.DataModel
import com.example.disneycharacaters.data.model.disney_package.DisneyItemModel
import com.example.disneycharacaters.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    val repository: Repository
) : ViewModel() {

    private val _characterList = MutableLiveData<DisneyItemModel>()
    val characterList: LiveData<DisneyItemModel> = _characterList

    init {
        getCharacterList()
    }

    private fun getCharacterList() {
        viewModelScope.launch {
            val result = repository.getCharacters()
            if(result != null) {
                _characterList.postValue(result)
            }
        }
    }
}