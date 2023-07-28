package com.example.samplecompose.presention

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class newViewModel @Inject constructor (
    repository: Repository
) : ViewModel(){
}