package com.zg.burgerjoint.mvp.presenters.impls

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import com.example.travelapp.activities.data.models.CountryModel
import com.example.travelapp.activities.data.models.CountryModelImpl
import com.example.travelapp.activities.mvp.presenters.HomePresenterImpl
import com.example.travelapp.activities.mvp.view.HomeView
import com.example.travelapp.data.vos.CountryVO
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class TourPresenterImplTest {

    private lateinit var mPresenter: HomePresenterImpl

    @RelaxedMockK
    private lateinit var mView: HomeView

    private lateinit var mTourModel: CountryModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)


        mTourModel = CountryModelImpl

        mPresenter = HomePresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mCountryModel = this.mTourModel
    }

    @Test
    fun onTapCountryItem(){
        mPresenter.onTapCountryItem("Sea Flower Resort",2)

        verify {
            mView?.navigateToTourDetail("Sea Flower Resort",2)
        }
    }


    @Test
    fun onUIReady(){
        val lifecycleOwner = mock(LifecycleOwner::class.java)
        val lifecycleRegistry = LifecycleRegistry(lifecycleOwner)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycleRegistry)

        mPresenter.onUiReadyState(lifecycleOwner)
        verify {
            mView.hideEmptyView()
        }
    }

}