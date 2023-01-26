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
    println("Payslip Printer")
    //printPayslip()
    printPayslipRounding()
}
/*
fun printPayslip(){
val monthlySalary = (grossSalary/12)
    val monthlyPrsi = monthlySalary * (PRSI / 100)
    val monthlyPAYE = monthlySalary * (PAYE / 100)
    val grossPay = (monthlySalary + (annualBonus/12))
    val totalDeductions = (monthlyPAYE + monthlyPrsi + cycleToWork)


    println("--------------------Monthly Payslip With Rounding-----------------")
    println("----------------------------------------------------")
    println("----------------------------------------------------")
    println("---Employee Name: ${firstName.uppercase()} ${surName.uppercase()}($gender)-----Employee ID:$employeeId--")
    println("----------------------------------------------------")
    println("----------------------------------------------------")
    println("---PAYMENT DETAILS-----------------------DEDUCTION DETAILS-----------------------------------------------")
    println("--------------------------------------------------------------------------------")
    println("---Salary:$monthlySalary------------------PAYE:$monthlyPAYE------------------------------------------")
    println("---Bonus:$annualBonus------------------------PRSI:$monthlyPrsi-----------------------------------------")
    println("--------------------------------------------------------------------------------")
    println("--------------------------------------------------------------------------------")
    println("--------------------------------------------------------------------------------")
    println("---Gross:$grossPay---------------------------Total Deductions: $totalDeductions-------------------------")
    println("--------------------------------------------------------------------------------")
    println("--------------------------------------------------------------------------------")
    println("------------------------------------------Net Pay: ${grossPay - totalDeductions}-----------------------------")
    println("--------------------------------------------------------------------------------")


}
*/
fun printPayslipRounding(){
    val monthlySalary = (grossSalary/12)
    val monthlyPrsi = monthlySalary * (PRSI / 100)
    val monthlyPAYE = monthlySalary * (PAYE / 100)
    val grossPay = (monthlySalary + (annualBonus/12))
    val totalDeductions = (monthlyPAYE + monthlyPrsi + cycleToWork)

    println("")
    println("")
    println("")

    println("--------------------Monthly Payslip---------------------------------------------")
    println("--------------------------------------------------------------------------------")
    println("--------------------------------------------------------------------------------")
    println("---Employee Name: ${firstName.uppercase()} ${surName.uppercase()}($gender)-----Employee ID:$employeeId------------------------------")
    println("--------------------------------------------------------------------------------")
    println("--------------------------------------------------------------------------------")
    println("---PAYMENT DETAILS-----------------DEDUCTION DETAILS----------------------------")
    println("--------------------------------------------------------------------------------")
    println("---Salary:${"%.2f".format(monthlySalary)}------------------PAYE:${"%.2f".format(monthlyPAYE)}---------------------------------")
    println("---Bonus:${"%.2f".format((annualBonus / 12))}--------------------PRSI:${"%.2f".format(monthlyPrsi)}----------------------------------")
    println("--------------------------------------------------------------------------------")
    println("--------------------------------------------------------------------------------")
    println("--------------------------------------------------------------------------------")
    println("---Gross:${"%.2f".format(grossPay)}---------------------------Total Deductions: ${"%.2f".format(totalDeductions)}------------")
    println("--------------------------------------------------------------------------------")
    println("--------------------------------------------------------------------------------")
    println("------------------------------------------Net Pay: ${"%.2f".format((grossPay - totalDeductions))}----------------------")
    println("--------------------------------------------------------------------------------")


}