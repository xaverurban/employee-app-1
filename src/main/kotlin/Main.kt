import kotlin.math.round



fun main(args: Array<String>) {
    add()
    //println("Payslip Printer")
    //printPayslip()
    //printPayslipRounding()
    var input : Int

    do {
        input = menu()
        when(input) {
            1 -> println("Monthly Salary: ${getMonthlySalary()}")
            2 -> println("Monthly PRSI: ${getMonthlyPrsi()}")
            3 ->println("Monthly PAYE: ${getMonthlyPAYE()}")
            4 -> println("Monthly Gross Pay: ${getGrossPay()}")
            5 -> println("Monthly Total Deductions: ${getTotalDeductions()}")
            6 -> println("Monthly Net Pay: ${getNetMonthlyPay()}")
            7 -> println(getPayslip())
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}

fun menu() : Int {
    print("""
         Employee Menu for ${getFullName()}
           1. Monthly Salary
           2. Monthly PRSI
           3. Monthly PAYE
           4. Monthly Gross Pay
           5. Monthly Total Deductions
           6. Monthly Net Pay
           7. Full Payslip
          -1. Exit
         Enter Option : """)
    return readLine()!!.toInt()
}
fun getFullName() = when (employee.gender){
    'm', 'M' -> "Mr. ${employee.firstName} ${employee.surName}"
    'f', 'F' -> "Ms. ${employee.firstName} ${employee.surName}"
    else -> "${employee.firstName} ${employee.surName}"
}

    fun getMonthlySalary() = roundTwoDecimals(employee.grossSalary/12)
    fun getMonthlyPrsi() = roundTwoDecimals(getMonthlySalary() * (employee.PRSI / 100))
    fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (employee.PAYE / 100))
    fun getGrossPay() = roundTwoDecimals(getMonthlySalary() + (employee.annualBonus/12))
    fun getTotalDeductions() = roundTwoDecimals(getMonthlyPAYE() + getMonthlyPrsi() + employee.cycleToWork)

fun getNetMonthlyPay() = roundTwoDecimals(roundTwoDecimals(getGrossPay() - getTotalDeductions()))

  fun getPayslip() {
      println(
          """
                                    Monthly Payslip
        ----------------------------------------------------------------------
        Name: ${employee.firstName.uppercase()}  ${employee.surName.uppercase()}  (${employee.gender.uppercase()}),  ID: ${employee.employeeId}                  
        ----------------------------------------------------------------------  
            PAYMENT DETAILS (Gross Pay: ${getGrossPay()})                                                                    
        ----------------------------------------------------------------------
                   Salary: ${getMonthlySalary()}
                   Bonus:  ${roundTwoDecimals(employee.annualBonus / 12)}            
        ----------------------------------------------------------------------
            DEDUCTION DETAILS (Total Deductions: ${getTotalDeductions()})      
        ----------------------------------------------------------------------
                   PAYE: ${getMonthlyPAYE()}}               
                   PRSI: ${getMonthlyPrsi()}}  
                   Cycle To Work: ${employee.cycleToWork}         
        ----------------------------------------------------------------------
            NET PAY: ${roundTwoDecimals(getGrossPay() - getTotalDeductions())} 
        ----------------------------------------------------------------------"""
      )

  }
fun add(){
    println("Enter First Name:")
    val firstName = readLine().toString()
    println("Enter Surname:")
    val surName = readLine().toString()
    println("Enter Gender:")
    val gender = readLine()!!.toCharArray()[0]
    println("Enter Employee ID:")
    val employeeId = readLine()!!.toInt()
    println("Enter Gross Salary:")
    val grossSalary = readLine()!!.toDouble()
    println("Enter PAYE %:")
    val PAYE = readLine()!!.toDouble()
    println("Enter PRSI %:")
    val PRSI = readLine()!!.toDouble()
    println("Enter Annual Bonus:")
    val annualBonus = readLine()!!.toDouble()
    println("Enter First Name:")
    val cycleToWork = readLine()!!.toDouble()

    employee = Employee(firstName, surName, gender, employeeId,
        grossSalary, PAYE, PRSI, annualBonus, cycleToWork)
}

fun roundTwoDecimals(number: Double) = round(number * 100) / 100
