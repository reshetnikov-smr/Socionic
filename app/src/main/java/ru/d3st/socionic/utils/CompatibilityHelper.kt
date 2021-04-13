package ru.d3st.socionic.utils

import android.app.Application
import android.content.res.Resources
import ru.d3st.socionic.R
import ru.d3st.socionic.domain.Compatibility
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CompatibilityHelper @Inject constructor(applicationContext: Application) {

    val res: Resources = applicationContext.resources


    val tojd = res.getString(R.string.tojd)
    val dual = res.getString(R.string.dual)
    val akt = res.getString(R.string.akt)
    val zerk = res.getString(R.string.zerk)
    val zak = res.getString(R.string.zak)
    val rev = res.getString(R.string.rev)
    val del = res.getString(R.string.del)
    val mirj = res.getString(R.string.mirj)
    val sego = res.getString(R.string.sego)
    val ppol = res.getString(R.string.ppol)
    val kvtoj = res.getString(R.string.kvtoj)
    val konf = res.getString(R.string.konf)
    val rods = res.getString(R.string.rods)
    val pdual = res.getString(R.string.pdual)

    val tojdDesc = res.getString(R.string.tojd_desc)
    val dualDesc = res.getString(R.string.dual_desc)
    val aktDesc = res.getString(R.string.akt_desc)
    val zerkDesc = res.getString(R.string.zerk_desc)
    val zakDesc = res.getString(R.string.zak_desc)
    val revDesc = res.getString(R.string.rev_desc)
    val delDesc = res.getString(R.string.del_desc)
    val mirjDesc = res.getString(R.string.mirj_desc)
    val segoDesc = res.getString(R.string.sego_desc)
    val ppolDesc = res.getString(R.string.ppol_desc)
    val kvtojDesc = res.getString(R.string.kvtoj_desc)
    val konfDesc = res.getString(R.string.konf_desc)
    val rodsDesc = res.getString(R.string.rods_desc)
    val pdualDesc = res.getString(R.string.pdual_desc)

    val compatibilities = listOf(
            Compatibility(104, tojd, dual, akt, zerk, zak, rev, del, mirj, sego, ppol, kvtoj, konf, zak, rev, rods, pdual),
            Compatibility(108, dual, tojd, zerk, akt, rev, zak, mirj, del, ppol, sego, konf, kvtoj, rev, zak, pdual, rods),
            Compatibility(109, akt, zerk, tojd, dual, rods, pdual, zak, rev, kvtoj, konf, sego, ppol, del, mirj, zak, rev),
            Compatibility(115, zerk, akt, dual, tojd, pdual, rods, rev, zak, konf, kvtoj, ppol, sego, mirj, del, rev, zak),
            Compatibility(110, zak, rev, rods, pdual, tojd, dual, akt, zerk, zak, rev, del, mirj, sego, ppol, kvtoj, konf),
            Compatibility(116, rev, zak, pdual, rods, dual, tojd, zerk, akt, rev, zak, mirj, del, ppol, sego, konf, kvtoj),
            Compatibility(102, del, mirj, zak, rev, akt, zerk, tojd, dual, rods, pdual, zak, rev, kvtoj, konf, sego, ppol),
            Compatibility(105, mirj, del, rev, zak, zerk, akt, dual, tojd, pdual, rods, rev, zak, konf, kvtoj, ppol, sego),
            Compatibility(101, sego, ppol, kvtoj, konf, zak, rev, rods, pdual, tojd, dual, akt, zerk, zak, rev, del, mirj),
            Compatibility(106, ppol, sego, konf, kvtoj, rev, zak, pdual, rods, dual, tojd, zerk, akt, rev, zak, mirj, del),
            Compatibility(112, kvtoj, konf, sego, ppol, del, mirj, zak, rev, akt, zerk, tojd, dual, rods, pdual, zak, rev),
            Compatibility(113, konf, kvtoj, ppol, sego, mirj, del, rev, zak, zerk, akt, dual, tojd, pdual, rods, rev, zak),
            Compatibility(111, zak, rev, del, mirj, sego, ppol, kvtoj, konf, zak, rev, rods, pdual, tojd, dual, akt, zerk),
            Compatibility(114, rev, zak, mirj, del, ppol, sego, konf, kvtoj, rev, zak, pdual, rods, dual, tojd, zerk, akt),
            Compatibility(103, rods, pdual, zak, rev, kvtoj, konf, sego, ppol, del, mirj, zak, rev, akt, zerk, tojd, dual),
            Compatibility(107, pdual, rods, rev, zak, konf, kvtoj, ppol, sego, mirj, del, rev, zak, zerk, akt, dual, tojd))
}