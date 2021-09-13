package com.eja.earthquakeinfo.networking

object ApiEndpoint {

    var URL_GEMPA_DIRASAKAN = "http://bmkg-geojson.herokuapp.com/gempa/?data=dirasakan"
    var URL_GEMPA_BERPOTENSI = "http://bmkg-geojson.herokuapp.com/gempa/?data=m-5"
    var URL_GEMPA_M5 = "http://bmkg-geojson.herokuapp.com/gempa/?data=m-5-terkini"
    var URL_CUACA = "http://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&units=metric&appid=6822010de82deadadbed65e4b0f0cd8d"
}