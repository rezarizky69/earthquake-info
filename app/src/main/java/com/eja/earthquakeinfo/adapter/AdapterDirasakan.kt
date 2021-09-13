package com.eja.earthquakeinfo.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.eja.earthquakeinfo.R
import com.eja.earthquakeinfo.fragment.FragmentDetailGempa
import com.eja.earthquakeinfo.model.ModelGempaBerpotensi
import com.eja.earthquakeinfo.model.ModelGempaDirasakan
import kotlinx.android.synthetic.main.list_gempa_berpotensi.view.*
import kotlinx.android.synthetic.main.list_gempa_berpotensi.view.tvKedalaman
import kotlinx.android.synthetic.main.list_gempa_berpotensi.view.tvSkala
import kotlinx.android.synthetic.main.list_gempa_berpotensi.view.tvTanggal
import kotlinx.android.synthetic.main.list_gempa_dirasakan.view.*
import java.text.ParseException
import java.text.SimpleDateFormat

class AdapterDirasakan(
    private val modelGempaDirasakan:
    List<ModelGempaDirasakan>
) : RecyclerView.Adapter<AdapterDirasakan.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_gempa_dirasakan, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = modelGempaDirasakan[position]
        var lastUpdate = data.strTanggal
        val formatDefault = SimpleDateFormat("dd/MM/yyyy-HH:mm:ss")
        val formatTime = SimpleDateFormat("EEE, dd MMM yyyy / HH:mm:ss")

        try {
            val timesFormatLast = formatDefault.parse(lastUpdate)
            lastUpdate = formatTime.format(timesFormatLast)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        holder.tvTanggal.text = lastUpdate
        holder.tvDirasakan.text = "Dirasakan : " + data.strDirasakan
        holder.tvKedalaman.text = "Kedalaman : " + data.strKedalaman
        holder.tvSkala.text = data.strMagnitude + "\nSR"
        holder.tvKeterangan.text = data.strKeterangan
    }

    override fun getItemCount(): Int {
        return modelGempaDirasakan.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTanggal: TextView
        var tvDirasakan: TextView
        var tvKedalaman: TextView
        var tvSkala: TextView
        var tvKeterangan: TextView

        init {
            tvTanggal = itemView.tvTanggal
            tvDirasakan = itemView.tvDirasakan
            tvKedalaman = itemView.tvKedalaman
            tvSkala = itemView.tvSkala
            tvKeterangan = itemView.tvKeterangan
        }
    }

}