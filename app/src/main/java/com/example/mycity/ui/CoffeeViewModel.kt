package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.DataProvider
import com.example.mycity.model.CoffeeInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * View Model for Sports app
 */
class SportsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        CoffeeUiState(
            sportsList = LocalSportsDataProvider.getSportsData(),
            currentSport = LocalSportsDataProvider.getSportsData().getOrElse(0) {
                LocalSportsDataProvider.defaultSport
            }
        )
    )
    val uiState: StateFlow<CoffeeUiState> = _uiState

    fun updateCurrentCoffee(selectedCoffee: CoffeeInfo) {
        _uiState.update {
            it.copy(currentCoffee = selectedCoffee)
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
    val districtList: List<CoffeeInfo> = emptyList(),
    val coffeeList: List<CoffeeInfo> = emptyList(),
    val currentCoffee: CoffeeInfo = DataProvider.default,
    val isShowingDistrictListPage: Boolean = true,
    val isShowingCoffeeListPage: Boolean = false,
    val isShowingCoffeeDetailPage: Boolean = false
)
