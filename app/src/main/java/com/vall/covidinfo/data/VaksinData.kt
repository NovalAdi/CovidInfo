package com.vall.covidinfo.data

import com.vall.covidinfo.R
import com.vall.covidinfo.model.Vaksin

object VaksinData {
    val Nama = arrayOf(
        "Sinovac",
        "Oxford-AstraZeneca",
        "Sinopharm",
        "Moderna",
        "Pfizer-BioNTech",
        "Novavax"
    )
    val Img = intArrayOf(
        R.drawable.vaksin_sinovac,
        R.drawable.vaksin_oxford_astrazeneca,
        R.drawable.vaksin_sinopharm,
        R.drawable.vaksin_moderna,
        R.drawable.vaksin_pfizer_biontech,
        R.drawable.vaksin_novavax,
    )
    val Asal = arrayOf(
        "China",
        "Inggris",
        "China",
        "Amerika Serikat",
        "Amerika Serikat",
        "Amerika Serikat"
    )
    val BahanDasar = arrayOf(
        "virus Corona (SARS-CoV-2) yang telah dimatikan (inactivated virus)",
        "virus hasil rekayasa genetika (viral vector)",
        "virus Corona yang dimatikan (inactivated virus)",
        "messenger RNA (mRNA)",
        "messenger RNA (mRNA)",
        "protein subunit"
    )
    val UjiKlinis = arrayOf(
        "Lokasi: China, Indonesia, Brazil, Turki, Chile\nUsia peserta: 18–59 tahun\nDosis: 2 dosis (0,5 ml per dosis) dengan jarak 14 hari\nEfikasi vaksin: 65,3% (di Indonesia), 91,25% (di Turki)",
        "Lokasi: Inggris, Amerika, Afrika Selatan, Colombia, Peru, Argentina\nUsia peserta: >18 tahun hingga >55 tahun\nDosis: 2 dosis (0,5 ml per dosis) dengan jarak 4–12 minggu\nEfikasi vaksin: 75%",
        "Lokasi: China, Uni Emirat Arab, Maroko, Mesir, Bahrain, Jordan, Pakistan, Peru, Argentina\nUsia peserta: 18–85 tahun\nDosis: 2 dosis (0,5 ml per dosis) dengan jarak 21 hari\nEfikasi vaksin: 79,34% (di Uni Emirat Arab)",
        "Lokasi: Amerika Serikat\nUsia peserta: >18 tahun hingga >55 tahun\nDosis: 2 dosis (0,5 ml per dosis) dengan jarak 28 hari\nEfikasi vaksin: 94,1%",
        "Lokasi: Amerika Serikat, Jerman, Turki, Afrika Selatan, Brazil, Argentina\nUsia peserta: >16 tahun hingga >55 tahun\nDosis: 2 dosis (0,3 ml per dosis) dengan jarak 3 minggu\nEfikasi vaksin: 95%",
        "Lokasi: Inggris, India, Afrika Selatan, Meksiko\nUsia peserta: 18–59 tahun\nDosis: 2 dosis (0,5 ml per dosis) dengan jarak 21 hari\nEfikasi vaksin: 85–89%"
    )
    val listVaksin : ArrayList<Vaksin>
    get() {
        val list = arrayListOf<Vaksin>()
        for (i in Nama.indices) {
            val vaksin = Vaksin()
            vaksin.nama = Nama[i]
            vaksin.img = Img[i]
            vaksin.asal = Asal[i]
            vaksin.bahan = BahanDasar[i]
            vaksin.ujiklinis = UjiKlinis[i]
            list.add(vaksin)
        }
        return list
    }
}