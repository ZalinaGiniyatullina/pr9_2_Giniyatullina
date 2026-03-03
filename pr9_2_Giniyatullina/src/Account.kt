package  bank
open class Account(
    val number: String,
    var money: Double
) {
    open fun add(sum: Double) {
        money += sum
        println("Счет $number пополнен на $sum. Теперь $money")
    }
    open fun take(sum: Double): Boolean {

        return if (money >= sum) {
            money -= sum

            println("Со счета $number снять $sum.Осталось: $money")
            true
        } else {

            println("На счете $number нет $sum")
            false
        }

    }
    open fun close() {
        money = 0.0
        println(" Счет $number закрыт")
    }
}
class BonusAccount(number: String, money: Double):Account(number, money){
    override  fun add (sum:Double){
        super.add(sum+5)//+5 бонусов
        println("Бонус 5 начислен")
    }
}