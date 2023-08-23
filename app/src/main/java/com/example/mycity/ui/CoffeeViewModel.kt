package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.DataProvider
import com.example.mycity.model.CoffeeInfo
import com.example.mycity.model.District
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * View Model for Sports app
 */
class CoffeeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        CoffeeUiState(
            districtList = DataProvider.getCoffeeData(),
            currentDistrict =  DataProvider.getCoffeeData().getOrElse(0) {
                DataProvider.defaultDistrict
            },
            coffeeList = DataProvider.getCoffeeData().getOrElse(0) {
                DataProvider.defaultDistrict
            }.coffeeList,
            currentCoffee = DataProvider.getCoffeeData().getOrElse(0) {
                DataProvider.defaultDistrict
            }.coffeeList.getOrElse(0) {
                DataProvider.defaultCoffee
            },
        )
    )
    val uiState: StateFlow<CoffeeUiState> = _uiState

    fun updateCurrentCoffee(selectedDistrict: District, selectedCoffee: CoffeeInfo) {
        _uiState.update {
            it.copy(
                currentDistrict = selectedDistrict,
                currentCoffee = selectedCoffee
            )
        }
    }

    fun navigateToDistrictListPage() {
        _uiState.update {
            it.copy(
                isShowingDistrictListPage = true,
                isShowingCoffeeListPage = false,
                isShowingCoffeeDetailPage = false
            )
        }
    }

    fun navigateToCoffeeListPage() {
        _uiState.update {
            it.copy(
                isShowingDistrictListPage = false,
                isShowingCoffeeListPage = true,
                isShowingCoffeeDetailPage = false
            )
        }
    }

    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(
                isShowingDistrictListPage = false,
                isShowingCoffeeListPage = false,
                isShowingCoffeeDetailPage = true
            )
        }
    }
}

data class CoffeeUiState(
    val districtList: List<District> = emptyList(),
    val coffeeList: List<CoffeeInfo> = emptyList(),
    val currentDistrict: District = DataProvider.defaultDistrict,
    val currentCoffee: CoffeeInfo = DataProvider.defaultCoffee,
    val isShowingDistrictListPage: Boolean = true,
    val isShowingCoffeeListPage: Boolean = false,
    val isShowingCoffeeDetailPage: Boolean = false
)
