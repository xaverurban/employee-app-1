package ie.setu.controllers

import ie.setu.models.Employee
import java.util.*
import kotlin.collections.ArrayList

var lastId = 0

internal fun getId(): Int {
    return lastId++
}

class EmployeeAPI {

    private val employees = ArrayList<Employee>()

    fun findAll(): List<Employee> {
        return employees
    }

    fun findOne(id: Int): Employee? {
        return employees.find { p -> p.employeeId == id }
    }

    fun create(employee: Employee) {
        employee.employeeId = getId()
        employees.add(employee)
    }
    fun findByFirstName(firstName: String): List<Employee> {
        return employees.filter { p -> p.firstName.lowercase(Locale.getDefault()) == firstName.lowercase(Locale.getDefault()) }
    }

    fun delete(employeeId: Int): Boolean { return employees.removeIf { it.employeeId == employeeId }
    }
}
