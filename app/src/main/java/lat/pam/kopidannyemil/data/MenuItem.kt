package lat.pam.kopidannyemil.data

import androidx.annotation.DrawableRes
import lat.pam.kopidannyemil.R

data class MenuItem(
    val name: String,
    val description: String,
    val price: Int,
    @DrawableRes val imageRes: Int
)

val dummyMenu = listOf(
    MenuItem("Kopi Susu Gula Aren", "Espresso, susu, gula aren", 22000, R.drawable.kopi_susu),
    MenuItem("Donat Cokelat", "Donat empuk, glaze cokelat", 12000, R.drawable.donat_cokelat),
    MenuItem("Sourdough Loaf", "Roti fermentasi alami", 35000, R.drawable.sourdough),
    MenuItem("Cappuccino", "Espresso, foam susu lembut", 25000, R.drawable.cappuccino),
    MenuItem("Matcha Latte", "Matcha Jepang, susu segar", 27000, R.drawable.matcha_latte)
)