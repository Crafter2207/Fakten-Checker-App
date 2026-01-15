package com.fakten.checker.ui.factcheck

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fakten.checker.domain.model.Fact
import com.fakten.checker.domain.usecase.CheckFactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class FactCheckState(
    val fact: Fact? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class FactCheckViewModel @Inject constructor(
    private val checkFactUseCase: CheckFactUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(FactCheckState())
    val state: StateFlow<FactCheckState> = _state.asStateFlow()

    fun checkFact(input: String, isUrl: Boolean) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            try {
                val fact = if (isUrl) {
                    checkFactUseCase.execute(input) // Assuming execute(url: String) exists
                } else {
                    checkFactUseCase.execute(input) // Assuming execute(text: String) exists
                }
                _state.value = _state.value.copy(fact = fact, isLoading = false)
            } catch (e: Exception) {
                _state.value = _state.value.copy(error = e.message, isLoading = false)
            }
        }
    }
}
