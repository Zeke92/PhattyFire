package com.phattyfire.presentation.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class StandardScaffoldViewModel  @Inject constructor() : ViewModel() {

    private val _selectedBottomNavItem = mutableStateOf(0)
    val selectedBottomNavItem: State<Int> = _selectedBottomNavItem

    fun setSelectedBottomNavItem(item: Int){
        _selectedBottomNavItem.value = item
    }
}