package com.example.disneycharacters.ui.disney

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneycharacaters.data.model.disney.DataModel
import com.example.disneycharacaters.data.model.disney.DisneyCharactersModel
import com.example.disneycharacaters.data.repository.Repoistory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisneyViewModel @Inject constructor(
    val repository: Repoistory
) : ViewModel() {

    //    private val _peopleList = MutableLiveData<ArrayList<PeopleItemModel>>()
//    val peopleList: LiveData<ArrayList<PeopleItemModel>> = _peopleList
    private val _disneyList = MutableLiveData<DisneyCharactersModel>()

    val disneyList: LiveData<DisneyCharactersModel> = _disneyList

    init {
        getDisneyList()
    }

    fun getDisneyList() {
        viewModelScope.launch {

            val result = repository.getCharacterList()

            if (result!=null) {
                _disneyList.postValue(result)
            }


        }
    }
}

