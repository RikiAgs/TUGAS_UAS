package com.riki.ta.rest

import com.riki.ta.BuildConfig
import com.riki.ta.model.ModelRootData
import retrofit.http.GET
import rx.Observable

interface ApiService {
    @GET("detil_jadwal?key="+ BuildConfig.API_KEY + "&npm=" + BuildConfig.NPM)
    fun getJadwalKuliah(): Observable<ModelRootData>

    @GET("detil_pribadi?key=" + BuildConfig.API_KEY + "&npm=" + BuildConfig.NPM)
    fun getProfil(): Observable<ModelRootData>

}