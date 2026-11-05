package lat.pam.kopidannyemil.data

data class MenuItem(
    val name: String,
    val description: String,
    val price: Int
)

val dummyMenu = listOf(
    MenuItem("Kopi Susu Gula Aren", "Espresso, susu, gula aren", 22000),
    MenuItem("Donat Cokelat", "Donat empuk, glaze cokelat", 12000),
    MenuItem("Sourdough Loaf", "Roti fermentasi alami", 35000),
    MenuItem("Cappuccino", "Espresso, foam susu lembut", 25000),
    MenuItem("Matcha Latte", "Matcha Jepang, susu segar", 27000)
)