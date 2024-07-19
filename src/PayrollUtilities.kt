fun calculateTotalPayroll(employees: List<Employee>): Double {
    return employees.sumOf { it.salary }
}

fun calculateTotalBonuses(employees: List<Employee>): Double {
    return employees.sumOf { it.calculateBonus() }
}