package com.fakten.checker.ui.dashboard

import androidx.lifecycle.ViewModel
import com.fakten.checker.domain.usecase.CheckFactUseCase
import com.fakten.checker.domain.usecase.GetLearningModulesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val checkFactUseCase: CheckFactUseCase,
    private val getLearningModulesUseCase: GetLearningModulesUseCase
) : ViewModel() {

    // TODO: Implement state for the dashboard screen

}
