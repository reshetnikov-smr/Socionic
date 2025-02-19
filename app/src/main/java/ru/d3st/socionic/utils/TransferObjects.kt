package ru.d3st.socionic.utils

import ru.d3st.socionic.R
import ru.d3st.socionic.models.presentation.Comparison
import ru.d3st.socionic.models.presentation.Compatibility

fun Compatibility.asComparisonData(): List<Comparison> {

    return listOf(
            Comparison(DON,"Дон Кихот", R.drawable.don_kihot, donkihot),
            Comparison(DUMA,"Дюма", R.drawable.duma, duma),
            Comparison(HUGO,"Гюго", R.drawable.hugo, hugo),
            Comparison(ROB,"Робеспьер", R.drawable.robespiere, rob),
            Comparison(GAMLET,"Гамлет", R.drawable.gamlet, gamlet),
            Comparison(GORKIY,"Горький", R.drawable.gorkiy, max),
            Comparison(JUKOV,"Жуков", R.drawable.jukov, jukov),
            Comparison(ESENIN,"Есенин", R.drawable.esenin, esenin),
            Comparison(NAPOLEON,"Наполеон", R.drawable.napoleon, napoleon),
            Comparison(BALZAK,"Бальзак", R.drawable.balzak, balzak),
            Comparison(LONDON,"Джек Лондон", R.drawable.london, jack),
            Comparison(DRAIZER,"Драйзер", R.drawable.draizer, draizer),
            Comparison(SHTIRLITZ,"Штирлиц", R.drawable.shtirliz, shtirlitz),
            Comparison(DOSTOEVSKIY,"Достоевский", R.drawable.dostoevskiy, dostoevskiy),
            Comparison(GEKSLI,"Гексли", R.drawable.geksli, heksli),
            Comparison(DUMA, "Дюма", R.drawable.gaben, gaben)
    )
}
