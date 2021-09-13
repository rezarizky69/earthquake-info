package com.eja.earthquakeinfo.views

interface MainPresenter {
    fun getDataGempaDirasakan()
    fun getDataGempaBerpotensi()
    fun onProses(proses: Boolean)
}