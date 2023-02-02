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
)

var employee =  Employee("Joe", "Soap", 'm', 6143, 67543.21, 38.5, 5.2, 1450.50, 54.33)
