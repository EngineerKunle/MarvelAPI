package com.ekotech.marvelapi.splash

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.ekotech.marvelapi.helper.RxImmediateSchedulerRule
import com.ekotech.marvelapi.splash.SplashViewModel.SplashViewState
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyOrder
import io.reactivex.Completable
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SplashViewModelTest {
    @Rule
    @JvmField
    var testSchedule = RxImmediateSchedulerRule()

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private val splashTimer: ITimerSplash = mockk(relaxed = true)
    private lateinit var viewModel: SplashViewModel
    private val observer: Observer<SplashViewState> = mockk(relaxed = true)

    @Before
    fun setUp() {
        viewModel = SplashViewModel(splashTimer)
    }

    @Test
    fun `timer completed success`() {
        every {
            splashTimer.timerForSplashScreen()
        } returns Completable.complete()

        viewModel.viewState.observeForever(observer)

        viewModel.launchMainScreen()

        verifyOrder {
            observer.onChanged(SplashViewState(isFinished = false))
            observer.onChanged(SplashViewState(isFinished = true))
        }
    }
}
