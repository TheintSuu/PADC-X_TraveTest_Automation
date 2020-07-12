package com.example.travelapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travelapp.R
import androidx.lifecycle.ViewModelProviders
import com.example.travelapp.activities.adapter.MainAdapter
import com.example.travelapp.activities.mvp.presenters.HomePresenter
import com.example.travelapp.activities.mvp.presenters.HomePresenterImpl
import com.example.travelapp.activities.mvp.view.HomeView
import com.example.travelapp.data.vos.DataVO
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.main_item_view.swipeRefreshLayout


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : BaseFragment(), HomeView{


    private var param1: String? = null
    private var param2: String? = null
    // private val mCountryModel: CountryModel = CountryModelImpl
    private val compositeDisposable = CompositeDisposable()
    private lateinit var mPresenter: HomePresenter

    lateinit var mMainAdapter: MainAdapter
    val mdataVOList: ArrayList<DataVO> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_home, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpSwipeRefresh()
        setUpRecyclerView()
        mPresenter.onUiReadyState(this)
        //  setUpViewPod()
        //  hideEmptyView()

    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }


    private fun setUpRecyclerView() {
        mMainAdapter = MainAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mainRecyler.layoutManager = linearLayoutManager
        mainRecyler.adapter = mMainAdapter
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun displayTourList(tourList: DataVO) {
        mdataVOList.clear()
        mdataVOList.add(tourList)
        mMainAdapter.setData(mdataVOList)
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun showEmptyView() {

    }

    override fun hideEmptyView() {

    }

    override fun navigateToTourDetail(name: String,value:Int) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.container, DetailFragment.newInstance(name,value))?.addToBackStack(null)
            ?.commit()
    }

    override fun showErrorMessage(message: String) {
       // showSnackbar(message)
    }

    private fun setUpSwipeRefresh(){
        swipeRefreshLayout.setOnRefreshListener{
            mPresenter.onSwipeRefresh(this)
        }
    }
}