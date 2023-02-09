import ie.setu.models.Employee

import ie.setu.controllers.EmployeeAPI
import mu.KotlinLogging
import kotlin.math.round

val logger = KotlinLogging.logger {}

var employees = EmployeeAPI()
fun main(args: Array<String>) {
    logger.info { "Launching ie.setu.models.Employee App" }
    start()


}
fun menu() : Int {
    print(""" 
         |ie.setu.models.Employee Menu
         |   1. Add ie.setu.models.Employee
         |   2. List All Employees
         |   3. Search Employees 
         |   4. Print Payslip for ie.setu.models.Employee
         |  -1. Exit
         |       
         |Enter Option : """.trimMargin())
    return readLine()!!.toInt()
}


fun start() {
    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> add()
            2 -> list()
            3 -> search()
            4 -> paySlip()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}

fun list(){
    logger.info { "Start List Employees" }
    employees.findAll().forEach{ println(it) }
}

fun search() {
    logger.info { "Start Search ie.setu.models.Employee by ID" }
    val employee = getEmployeeById()
    if (employee == null)
        println("No employee found")
    else
        println(employee)
}
internal fun getEmployeeById(): Employee? {
    print("Enter the employee id to search by: ")
    val employeeID = readLine()!!.toInt()
    return employees.findOne(employeeID)
}

fun paySlip(){
    val employee = getEmployeeById()
    if (employee != null)
        println(employee.getPayslip())
}
fun dummyData() {
    employees.create(Employee("Joe", "Soap", 'm', 0, 35655.43, 31.0, 7.5, 2000.0, 25.6))
    employees.create(Employee("Joan", "Murphy", 'f', 0, 54255.13, 32.5, 7.0, 1500.0, 55.3))
    employees.create(Employee("Mary", "Quinn", 'f', 0, 75685.41, 40.0, 8.5, 4500.0, 0.0))
}


fun add(){
    logger.info { "Start Adding ie.setu.models.Employee" }
    println("Enter First Name:")
    val firstName = readLine().toString()
    println("Enter Surname:")
    val surName = readLine().toString()
    println("Enter Gender:")
    val gender = readLine()!!.toCharArray()[0]
    println("Enter ie.setu.models.Employee ID:")
    val employeeId = readLine()!!.toInt()
    println("Enter Gross Salary:")
    val grossSalary = readLine()!!.toDouble()
    println("Enter PAYE %:")
    val PAYE = readLine()!!.toDouble()
    println("Enter PRSI %:")
    val PRSI = readLine()!!.toDouble()
    println("Enter Annual Bonus:")
    val annualBonus = readLine()!!.toDouble()
    println("Enter Cycle to Work Deduction:")
    val cycleToWork = readLine()!!.toDouble()

employees.create(Employee(firstName, surName, gender, employeeId, grossSalary, PAYE, PRSI, annualBonus, cycleToWork))
}

fun roundTwoDecimals(number: Double) = round(number * 100) / 100


