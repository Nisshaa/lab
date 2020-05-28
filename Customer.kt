
/*Customer: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки,
Номер банковского счета.
Создать массив объектов. Вывести:
a) список покупателей в алфавитном порядке;
b) список покупателей, у которых номер кредитной карточки находится
в заданном интервале.*/
object Customers {
    @kotlin.jvm.JvmStatic
    fun main(args: Array<String>) {
        val market = Shop("Keshenya")
        market.addCustomerToShopList(Customer("Дмитрий", "Имануилов", "Алексеевич", 604548, 4589))
        market.addCustomerToShopList(Customer("Василий", "Тарасенко", "Петрович", 254548, 1668))
        market.addCustomerToShopList(Customer("Алесей", "Колесник", "Андреевич", 304589, 1598))
        market.addCustomerToShopList(Customer("Борис", "Македон", "Станиславович", 904748, 4785))
        market.addCustomerToShopList(Customer("Дмитрий", "Турецкий", "Федорович", 404545, 2569))
        println("\nsort by name:")
        val listSortByName = market.listName
        for (c in listSortByName) {
            println(c)
        }
        println("\nsort by surname:")
        val listSortBySurname = market.listSurname
        for (c in listSortBySurname) {
            println(c)
        }
        println("\ndiapason card number:")
        val diapasonCardumber = market.getListDiapasonCardNumber(254548, 554556)
        for (c in diapasonCardumber) {
            println(c)
        }
    }
}

internal class Shop(private val ShopName: String) {
    private val customerList: java.util.ArrayList<Customer> = java.util.ArrayList()
    fun addCustomerToShopList(customer: Customer?) {
        customerList.add(customer)
    }

    val listName: List<Customer>
        get() {
            val list: List<Customer> = java.util.ArrayList(customerList)
            Collections.sort(list, object : java.util.Comparator<Customer?> {
                override fun compare(o1: Customer, o2: Customer): Int {
                    return o1.name.compareTo(o2.name, ignoreCase = true)
                }
            })
            return list
        }

    val listSurname: List<Customer>
        get() {
            val list: List<Customer> = java.util.ArrayList(customerList)
            Collections.sort(list, object : java.util.Comparator<Customer?> {
                override fun compare(o1: Customer, o2: Customer): Int {
                    return o1.surname.compareTo(o2.surname, ignoreCase = true)
                }
            })
            return list
        }

    fun getListDiapasonCardNumber(diapasonStart: Int, diapasonEnd: Int): List<Customer> {
        val list: MutableList<Customer> = java.util.ArrayList()
        for (c in customerList) {
            if (c.cardNumber >= diapasonStart && c.cardNumber <= diapasonEnd) {
                list.add(c)
            }
        }
        return list
    }

}

internal class Customer(surname: String, name: String, patronymic: String, CardNumber: Int, BankNumber: Int) {
    private val id = idGenertor
    val surname: String
    val name: String
    val patronymic: String
    val cardNumber: Int
    val bankNumber: Int

    override fun toString(): String {
        return String.format("ID: %d\t name: %s\t surname: %s\t patronymic %s \t CardNumber %d\t BankNumber %d",
                id, surname, name, patronymic, cardNumber, bankNumber)
    }

    companion object {
       private var idGenertor = 0
    }

    Init {
        idGenertor++
    }

    Init {
        This.name = name
        This.surname = surname
        This.patronymic = patronymic
        cardNumber = CardNumber
        bankNumber = BankNumber
    }
}