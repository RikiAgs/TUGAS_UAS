package com.riki.ta.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.riki.ta.R
import com.riki.ta.adapter.JadwalAdapter
import com.riki.ta.model.ModelDataItem
import com.riki.ta.rest.ApiClient
import com.riki.ta.rest.ApiService
import kotlinx.android.synthetic.main.jadwal_kuliah_fragment.view.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

@Suppress("UNCHECKED_CAST")
class JadwalKuliahFragment : Fragment() {
    private var items: ArrayList<ModelDataItem> = arrayListOf()
    private lateinit var rv: RecyclerView
    private lateinit var mAdapter: JadwalAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.jadwal_kuliah_fragment, container, false)
        rv = view.rv
        val apiService: ApiService = ApiClient.provideApi()
        apiService.getJadwalKuliah()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                items.clear()
                items = it.data as ArrayList<ModelDataItem>
                mAdapter = JadwalAdapter(items, activity)
                rv.visibility = View.VISIBLE
                rv.layoutManager = LinearLayoutManager(activity)
                rv.adapter = mAdapter

            }, {
                error("Error" + it.message)
            })

        return view
    }

    private fun getDatas() {

    }


}
