import kotlin.math.round

val firstName = "Joe"
val surName = "Soap"
val gender = 'm'
val employeeId = 6143
val grossSalary = 67543.21
val PAYE = 38.5
val PRSI = 5.2
val annualBonus = 1450.50
val cycleToWork = 54.33

fun main(args: Array<String>) {
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
fun getFullName() = when (gender){
    'm', 'M' -> "Mr. $firstName $surName"
    'f', 'F' -> "Ms. $firstName $surName"
    else -> "$firstName $surName"
}

    fun getMonthlySalary() = roundTwoDecimals(grossSalary/12)
    fun getMonthlyPrsi() = roundTwoDecimals(getMonthlySalary() * (PRSI / 100))
    fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (PAYE / 100))
    fun getGrossPay() = roundTwoDecimals(getMonthlySalary() + (annualBonus/12))
    fun getTotalDeductions() = roundTwoDecimals(getMonthlyPAYE() + getMonthlyPrsi() + cycleToWork)

fun getNetMonthlyPay() = roundTwoDecimals(roundTwoDecimals(getGrossPay() - getTotalDeductions()))

  fun getPayslip() {
      println(
          """
                                    Monthly Payslip
        ----------------------------------------------------------------------
        Name: ${firstName.uppercase()}  ${surName.uppercase()}  (${gender.uppercase()}),  ID: $employeeId                  
        ----------------------------------------------------------------------  
            PAYMENT DETAILS (Gross Pay: ${getGrossPay()})                                                                    
        ----------------------------------------------------------------------
                   Salary: ${getMonthlySalary()}
                   Bonus:  ${roundTwoDecimals(annualBonus / 12)}            
        ----------------------------------------------------------------------
            DEDUCTION DETAILS (Total Deductions: ${getTotalDeductions()})      
        ----------------------------------------------------------------------
                   PAYE: ${getMonthlyPAYE()}}               
                   PRSI: ${getMonthlyPrsi()}}  
                   Cycle To Work: $cycleToWork         
        ----------------------------------------------------------------------
            NET PAY: ${roundTwoDecimals(getGrossPay() - getTotalDeductions())} 
        ----------------------------------------------------------------------"""
      )

  }

fun roundTwoDecimals(number: Double) = round(number * 100) / 100
