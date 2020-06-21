open class Room(val name: String) {
    protected open val dangerLevel = 7
    var monster: Monster? = Goblin()
    fun description() = "Room $name\nDanger level $dangerLevel" +
            "Creature: ${monster?.description ?: "none"}"

    open fun load() = "Nothing much to see here..."
}

open class TownSquare : Room("Town Square") {
    private var bellSound = "GWONG"

    override val dangerLevel = super.dangerLevel - 3
    final override fun load() = "The villagers rally and cheer as you enter! ${ringBell()}"

    open fun ringBell() = "The bell tower announces your arrival. $bellSound"
}

class Piazza(name: String) : TownSquare() {
    override fun ringBell(): String {
        return "The wonders of the earth are found here"
    }
}