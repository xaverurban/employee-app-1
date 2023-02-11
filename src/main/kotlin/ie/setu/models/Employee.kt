package ie.setu.models

import roundTwoDecimals

class Employee(
    var firstName : String,
    var surName : String,
    var gender : Char,
    var employeeId: Int,
    var grossSalary: Double,
    var PAYE : Double,
    var PRSI: Double,
    var annualBonus: Double,
    var cycleToWork: Double,
) {
    fun getFullName() = when (gender) {
        'm', 'M' -> "Mr. $firstName $surName"
        'f', 'F' -> "Ms. $firstName $surName"
        else -> "$firstName $surName"
    }

    fun getMonthlySalary() = roundTwoDecimals(grossSalary / 12)
    fun getMonthlyPrsi() = roundTwoDecimals(getMonthlySalary() * (PRSI / 100))
    fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (PAYE / 100))
    fun getGrossPay() = roundTwoDecimals(getMonthlySalary() + (annualBonus / 12))
    fun getTotalDeductions() = roundTwoDecimals(getMonthlyPAYE() + getMonthlyPrsi() + cycleToWork)

    fun getNetMonthlyPay() = roundTwoDecimals(roundTwoDecimals(getGrossPay() - getTotalDeductions()))

    fun getPayslip() {
        println("""
        =======================================================================
                            💰💰💰  Monthly Payslip  💰💰💰
        =======================================================================
                 💼 Name: ${firstName.uppercase()}  ${surName.uppercase()}  (${gender.uppercase()}),  ID: ${employeeId}     💼
        =======================================================================  
                 💰 PAYMENT DETAILS (Gross Pay: ${getGrossPay()}) 💰                                                                    
        =======================================================================
                   💵 Salary: ${getMonthlySalary()}
                   🎁 Bonus:  ${roundTwoDecimals(annualBonus / 12)}            
        =======================================================================
           💸 DEDUCTION DETAILS (Total Deductions: ${getTotalDeductions()}) 💸     
        =======================================================================
                   💰 PAYE: ${getMonthlyPAYE()}               
                   💰 PRSI: ${getMonthlyPrsi()}  
                   🚴 Cycle To Work: ${cycleToWork}         
        =======================================================================
           💸 NET PAY: ${roundTwoDecimals(getGrossPay() - getTotalDeductions())} 💸
        =======================================================================
    """.trimIndent())
    }

    override fun toString(): String {
        return """
        +--------------------------+
        |   Employee Information   |
        +--------------------------+
         First Name: $firstName 
         Surname: $surName 
         Gender: $gender 
         Employee ID: $employeeId 
         ------------------------
         Gross Salary: $grossSalary 
         ------------------------
         PAYE: $PAYE
         PRSI: $PRSI
         Annual Bonus: $annualBonus
         Cycle To Work: $cycleToWork
        +--------------------------+
    """.trimIndent()
    }
}