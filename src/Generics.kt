class LootBox<T : Loot>(vararg item: T) {
    private var loot: Array<out T> = item
    var open = false

    operator fun get(index: Int): T? {
        return loot[index].takeIf { open }
    }

    fun fetch(item: Int): T? {
        return loot[item].takeIf { open }
    }

    fun <R> fetch(item: Int, lootModFunction: (T) -> R): R? {
        return lootModFunction(loot[item]).takeIf { open }
    }
}

class Fedora(val name: String, value: Int) : Loot(value)

class Coin(value: Int) : Loot(value)

open class Loot(val value: Int)

fun main(args: Array<String>) {
    var lootBoxOne = LootBox(
        Fedora("Beyonce's Fedora", 15),
        Fedora("Zoro's Fedora", 36)
    )
    var lootBoxTwo = LootBox(Coin(15))

    lootBoxOne.open = true
    lootBoxOne.fetch(1)?.run {
        println("You retrieved $name from the box.")
    }

    val coin = lootBoxOne.fetch(1) {
        Coin(it.value * 3)
    }
    coin?.let {
        println(it.value)
    }

    val fedora = lootBoxOne[0]
    fedora?.let { println(it.name) }


}

