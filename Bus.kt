import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
//Фамилия и инициалы водителя, Номер автобуса, Номер маршрута,
//    Марка, Год начала эксплуатации, Пробег
class Bus(
    var brand: String,
    var num: Int,
    var StartYear: Int,
    var probeg: Int,
    var name: String
) {
    private val id = newId++
    override fun toString(): String {
        val sb = StringBuilder("{")
        sb.append("Номер автобуса'").append(id).append('\'')
        sb.append(", марка=").append(brand)
        sb.append(", Номер маршрута=").append(num)
        sb.append(", Срок эксплуатации с=").append(StartYear)
        sb.append(", Имя и инициалы водителя =").append(name)
        sb.append(", Пробег в тыс.км.=").append(probeg)
        sb.append('}')
        return sb.toString()
    }
    companion object {
        private var newId = 1
    }

}

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val bus1 = Bus(brand="BMW", num = 1,StartYear = 2017,probeg =  1488, name = " Дрон А.А.")
        val bus2 = Bus(brand="BMW",num =  2,StartYear =  2007,probeg =  1300,name =  " Дубровин В.В.")
        val bus3 = Bus(brand="VW", num = 2,StartYear =  2008, probeg = 8888, name =  " Вавилов Б.А.")
        val bus4 = Bus(brand="MERCEDES", num = 4,StartYear = 2009,probeg = 9999,name =  " Дёмкин И.И")
        val bus5 = Bus(brand="OPEL", num = 3,StartYear = 2010,probeg = 1212, name = " Осборн О.М.")
        val bus6 = Bus(brand="MERCEDES", num = 4,StartYear = 2012,probeg =  2222,name =  " Вадим Г.Н.")
        val bus7 = Bus(brand="BMW", num = 1,StartYear =  2012,probeg =  1414,name =  " Борисов П.И.")
        val bus8 = Bus(brand="BMW", num = 3,StartYear =  2014,probeg =  10000,name =  " Фролов И.А.")
        val buss = listOf(bus1,bus2,bus3,bus4,bus5,bus6,bus7,bus8)
        val query = Query()
        var numchoice:String
        val resultList1 = query.getBussByNum1(buss, one = 1)
        val resultList11 = query.getBussByNum2(buss, two = 2)
        val resultList111 = query.getBussByNum3(buss, three = 3)
        val resultList1111 = query.getBussByNum4(buss, four = 4)

        val resultList2 = query.getBussByYear(buss, year = 2010)
        val resultList3 = query.getBussByProbeg(buss, probeg10k = 10000)
        val reader = BufferedReader(InputStreamReader(System.`in`))
        var choice: String
        loop@ while (true) {
            println("1.Список автобусов для заданного маршрута.")
            println("2.Список автобусов, которые эксплуатируются больше 10 лет.")
            println("3.Список автобусов, пробег у которых больше 10 000 км.")
            println("4.Закрыть программу.")
            choice = reader.readLine()
            when (choice) {
                "1" -> {
                    println("Введите номер маршрута: ")
                    numchoice = reader.readLine()
                     when(numchoice)
                     {
                         "1"->{
                             for (bus in resultList1) println(bus.toString())
                         }
                         "2"->{
                             for (bus in resultList11) println(bus.toString())
                         }
                         "3"->{
                             for (bus in resultList111) println(bus.toString())
                         }
                         "4"->{
                             for (bus in resultList1111) println(bus.toString())
                         }

                     }

                }
                "2" -> {
                    for (bus in resultList2) println(bus.toString())
                }
                "3" -> {
                    for (bus in resultList3) println(bus.toString())
                }
                "4" -> {
                    break@loop
                }

            }
        }

    }
}
class Query {
    fun getBussByNum1(
        buss: List<Bus>,
        one:Int
    ): List<Bus> {
        val result: MutableList<Bus> = ArrayList()
        for (bus in buss) {
            if (bus.num == one) result.add(bus)
        }
        return result
    }
    fun getBussByNum2(
        buss: List<Bus>,
        two:Int
    ): List<Bus> {
        val result: MutableList<Bus> = ArrayList()
        for (bus in buss) {
            if (bus.num == two) result.add(bus)
        }
        return result
    }
    fun getBussByNum3(
        buss: List<Bus>,
        three:Int
    ): List<Bus> {
        val result: MutableList<Bus> = ArrayList()
        for (bus in buss) {
            if (bus.num == three) result.add(bus)
        }
        return result
    }
    fun getBussByNum4(
        buss: List<Bus>,
        four:Int
    ): List<Bus> {
        val result: MutableList<Bus> = ArrayList()
        for (bus in buss) {
            if (bus.num == four) result.add(bus)
        }
        return result
    }

    fun getBussByYear(
        buss: List<Bus>,
        year: Int
    ): List<Bus> {
        val result: MutableList<Bus> = ArrayList()
        for (bus in buss) {
            if (bus.StartYear<=year)  result.add(bus)

        }
        return result
    }


    fun getBussByProbeg(
        buss: List<Bus>,
        probeg10k: Int
    ): List<Bus> {
        val result: MutableList<Bus> = ArrayList()
        for (bus in buss) {
            if (bus.probeg >= probeg10k) {
                result.add(bus)
            }
        }
        return result
    }
}