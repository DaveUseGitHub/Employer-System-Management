abstract class Employee {
    abstract val id: Int
    abstract val name: String
    abstract val salary: Double

    abstract fun calculateBonus(): Double
    abstract fun announce()
}

class EmployeeNotFoundException(message: String) : Exception(message)