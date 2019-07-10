package com.riki.ta.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.riki.ta.BuildConfig
import com.riki.ta.R
import com.riki.ta.model.ModelDataItem
import com.riki.ta.rest.ApiClient
import com.riki.ta.rest.ApiService
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.profile_fragment.view.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

@Suppress("UNCHECKED_CAST")
class ProfileFragment : Fragment() {
    private var items: ArrayList<ModelDataItem> = arrayListOf()
    private lateinit var npmTexView: TextView
    private lateinit var nik: TextView
    private lateinit var nisn: TextView
    private lateinit var tlhr: TextView
    private lateinit var ivImageProfile: CircleImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.profile_fragment, container, false)
        ivImageProfile = view.ivImageProfile
        npmTexView = view.tvNpm
        nik = view.tvNik
        nisn = view.tvNISN
        tlhr = view.tvTlhr
        npmTexView.text = "16670041"

        getDatas()

        return view;
    }

    private fun getDatas() {
        val apiService: ApiService = ApiClient.provideApi()
        apiService.getProfil()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                items.clear()
                items = it.data as ArrayList<ModelDataItem>
                for (i: Int in items.indices) {
                    nik.text = items.get(i).nik
                    nisn.text = items.get(i).nisn
                    tlhr.text = items.get(i).tlhr
                    activity?.let { it1 ->
                        Glide.with(it1).load("http://informatika.upgris.ac.id/mobile/image/" + items.get(i).foto)
                            .override(512, 512).error(R.drawable.riki).into(ivImageProfile)
                    }
                    if (BuildConfig.NPM.equals("16670041")) {
                        nik.text = items.get(i).nik
                        nisn.text = items.get(i).nisn
                        tlhr.text = items.get(i).tlhr
                        activity?.let { it1 ->
                            Glide.with(it1).load("https://lh3.googleusercontent.com/-ILBZ5r7eQeM/XIOpL6lyJMI/AAAAAAAAAXM/SWiIuuaACu8wrGyjsk5tEA6oRk0MymL0gCEwYBhgL/w139-h140-p/IMG20190101164655.jpg")
                                .override(512, 512).error(R.drawable.riki).into(ivImageProfile)
                        }
                    }
                }


            }, {
                error("Error" + it.message)
            })

    }


}
