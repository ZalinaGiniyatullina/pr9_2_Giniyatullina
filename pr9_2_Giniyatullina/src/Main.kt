import bank.Account
import  bank.BonusAccount
import bank.Card
import  bank.CashbackCard
import people.Client
import people.VipClient
import people.Admin
import people.MainAdmin
import  shop.Order
import shop.UrgentOrder
//псевдонимы
typealias MyAccount = Account
typealias MyBonusAccount = BonusAccount
typealias MyCard = Card
typealias MyCashbackCard = CashbackCard
typealias MyClient = Client
typealias MyVipClient = VipClient
typealias MyAdmin = Admin
typealias MyMainAdmin = MainAdmin
typealias MyOrder = Order
typealias MyUrgentOrder = UrgentOrder
fun main() {
    println("===== СИСТЕМА ПЛАТЕЖИ =====\n")
    val acc1: MyAccount = MyAccount("1234", 1000.0)
    val acc2: MyBonusAccount = MyBonusAccount("5678", 500.0)
    val card1: MyCard = MyCard("9101", acc1)
    val card2: MyCashbackCard = MyCashbackCard("1213", acc2)
    val client1: MyClient = MyClient("Залина", acc1, card1)
    val client2: MyVipClient = MyVipClient("Дарья", acc2, card2)
    val admin1: MyAdmin = MyAdmin("Вероника")
    val admin2: MyMainAdmin = MyMainAdmin("Виктория")
    val order1: MyOrder = MyOrder(1, 300.0, "Телефон")
    val order2: MyUrgentOrder = MyUrgentOrder(2, 200.0, "Лекарство")
    order1.show()
    println("\n===== НАЧАЛО РАБОТЫ =====\n")
    client1.payOrder(order1)
    client2.payOrder(order2)
    client1.transfer(acc2, 200.0)
    println("\n--- БАЛАНСЫ ---")
    println("Счет1 (${acc1.number}): ${acc1.money}")
    println("Счет2 (${acc2.number}): ${acc2.money}")
    val order3 = Order(3, 100.0, "Кофе")
    client2.payOrder(order3)
    admin2.blockAnyCard(card1)
    val order4 = Order(4, 150.0, "Пицца")
    client1.payOrder(order4)
    client1.blockCard()
    client2.closeAccount()
    println("\n===== КОНЕЦ ПРОГРАММЫ =====")
}