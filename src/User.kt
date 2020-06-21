class User(
    override var healthPoints: Int = 100,
    var name: String,
    var isBlessed: Boolean = false,
    private var isImmortal: Boolean,
    override var damageRoll: Int
) : Fightable {
    var currentPosition = Coordinate(0, 0)
    var username = name
        get() = field.reversed()
        set(name) {
            field = name.decapitalize()
        }

    fun reverseName(): String {
        return name.reversed()
    }

    fun castFireball() = "Welcome to death race! Username: $username"

    override var diceCount: Int = 8
    override var diceSides: Int = 12

    override fun attack(opponent: Fightable): Int {
        var damageDealt = if(isBlessed) {
            damageRoll * 2
        } else {
            damageRoll
        }
        opponent.healthPoints -= damageDealt
        return damageDealt
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

}