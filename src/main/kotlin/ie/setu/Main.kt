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
fun menu(): Int {
    println("""
    +---------------------------------------+
                                            
               💼 Employee Menu 💼            
    +---------------------------------------+                             
       📝   1. Add Employee 🧑‍💼           
       ❌   2. Delete Employee ❌           
       ---------------------------------- 
       📊   3. List All Employees 👨‍💼‍👨‍💼‍👨‍💼 
       🔍   4. Search Employees 🔍         
       👨‍💼   5. List Employees using First Name 👨‍💼 
       📊   6. List Employees by Salary in Descending order 💰 
       ---------------------------------                                  
       💰   7. Print Payslip for Employee 💸 
       ---------------------------------                               
       🔥   10. Dummy Data                  
       🚪   0. Exit 🚪                    
    +---------------------------------------+  
                         
       🎬 Enter Option :                
                                           
    """.trimIndent())
    return readLine()!!.toInt()
}


fun start() {
    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> add()
            2 ->delete()
            3 -> list()
            4 -> search()
            5 -> findByFirstName()
            6 ->listEmployeesBySalary()
            7 -> paySlip()
            10 -> dummyData()
            0 -> println("Exiting App")
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

fun findByFirstName() {
    logger.info { "Start Searching Employees by First Name" }
    print("Enter employees first name: ")
    val firstName = readLine().toString()
    val result = employees.findAll().filter { it.firstName == firstName }
    if (result.isEmpty()) {
        println("There is no Employees with first name $firstName !")
    } else {

        result.forEach { println(it)
        }
    }
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
    employees.create(Employee("Bobby", "Notbuilder", 'm', 0, 65324.0, 15.0, 12.0, 43230.0, 50.0))
    employees.create(Employee("Sammy", "Smitty", 'f', 0, 125000.0, 18.0, 21.0, 50000.0, 0.0))
    employees.create(Employee("Will", "Iam", 'm', 0, 24000.0, 12.0, 28.5, 2000.0, 80.0))
    employees.create(Employee("David", "Rock", 'f', 0, 32000.0, 25.0, 18.5, 12000.0, 18.0))
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

fun delete() {
    logger.info { "Start Deleting Employee" }
    val employee = getEmployeeById()
    if (employee != null) {
        employees.delete(employee.employeeId)
        println("Employee with ID ${employee.employeeId} has been removed")
    } else {
        println("No Employees found with that ID!")
    }
}

fun listEmployeesBySalary() {
    logger.info { "Listing Employees by Gross Salary" }
    val minSalary = 50000.0
    val maxSalary = 100000.0
    val result = employees.findAll().filter { it.grossSalary in minSalary .. maxSalary }
    if (result.isEmpty()) {
        println("No Employees with their salary between $minSalary - $maxSalary")
    } else {
        result.forEach { println(it) }
    }
}