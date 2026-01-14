package com.fakten.checker.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fakten.checker.domain.model.LearningModule
import com.fakten.checker.domain.usecase.GetLearningModulesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DashboardState(
    val learningModules: List<LearningModule> = emptyList(),
    val isLoading: Boolean = false
)

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getLearningModulesUseCase: GetLearningModulesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(DashboardState())
    val state: StateFlow<DashboardState> = _state.asStateFlow()

    init {
        loadLearningModules()
    }

    private fun loadLearningModules() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            // In a real app, handle potential errors
            val modules = getLearningModulesUseCase.execute()
            _state.value = _state.value.copy(learningModules = modules, isLoading = false)
        }
    }
}
