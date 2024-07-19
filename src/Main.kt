fun main() {
    //Main
    val employees = mutableListOf<Employee>()

    while (true) {
        println("\nEmployee Management System")
        println("1. Add Manager")
        println("2. Add Developer")
        println("3. List Employees")
        println("4. Edit Employee")
        println("5. Remove Employee")
        println("6. View Total Payroll Cost")
        println("7. View Total Bonuses")
        println("8. Exit")
        print("Choose an option: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Enter Manager ID: ")
                val id = readLine()?.toIntOrNull() ?: continue
                print("Enter Manager Name: ")
                val name = readLine() ?: continue
                print("Enter Manager Salary: ")
                val salary = readLine()?.toDoubleOrNull() ?: continue

                Manager(id, name, salary).also {
                    employees.add(it)
                    println("Manager added successfully!")
                }
            }
            2 -> {
                print("Enter Developer ID: ")
                val id = readLine()?.toIntOrNull() ?: continue
                print("Enter Developer Name: ")
                val name = readLine() ?: continue
                print("Enter Developer Salary: ")
                val salary = readLine()?.toDoubleOrNull() ?: continue

                Developer(id, name, salary).also {
                    employees.add(it)
                    println("Developer added successfully!")
                }
            }
            3 -> {
                if (employees.isEmpty()) {
                    println("No employees found.")
                } else {
                    employees.forEach { employee ->
                        println("Employee: ${employee.name}, ID: ${employee.id}, Salary: ${employee.salary}")
                        println("Bonus: ${employee.calculateBonus()}")
                        employee.announce()
                    }
                }
            }
            4 -> {
                print("Enter Employee ID to edit: ")
                val id = readLine()?.toIntOrNull() ?: continue
                val employee = employees.find { it.id == id }
                if (employee != null) {
                    print("Enter new name: ")
                    val newName = readLine() ?: continue
                    print("Enter new salary: ")
                    val newSalary = readLine()?.toDoubleOrNull() ?: continue

                    val updatedEmployee = employee.apply {
                        when (this) {
                            is Manager -> {
                                Manager(id, newName, newSalary).also {
                                    employees[employees.indexOf(this)] = it
                                }
                            }
                            is Developer -> {
                                Developer(id, newName, newSalary).also {
                                    employees[employees.indexOf(this)] = it
                                }
                            }
                        }
                    }
                    println("Employee updated successfully!")
                } else {
                    println("Employee not found!")
                }
            }
            5 -> {
                print("Enter Employee ID to remove: ")
                val id = readLine()?.toIntOrNull() ?: continue
                employees.find { it.id == id }?.let { employeeToRemove ->
                    employees.remove(employeeToRemove)
                    println("Employee removed successfully!")
                } ?: println("Employee not found!")
            }
            6 -> {
                val totalPayroll = calculateTotalPayroll(employees)
                println("Total Payroll Cost: $totalPayroll")
            }
            7 -> {
                val totalBonuses = calculateTotalBonuses(employees)
                println("Total Bonuses to be Distributed: $totalBonuses")
            }
            8 -> {
                println("Exiting...")
                break
            }
            else -> println("Invalid option, please try again.")
        }
    }
}