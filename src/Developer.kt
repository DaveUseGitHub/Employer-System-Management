class Developer(
    override val id: Int,
    override val name: String,
    override val salary: Double
) : Employee(), Position {
    override fun calculateBonus(): Double {
        return salary * 0.1
    }

    override fun announce() {
        println("$name (ID: $id) as Developer.")
    }
}