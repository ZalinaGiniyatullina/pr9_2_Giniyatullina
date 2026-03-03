package people
import  bank.Card

open class Admin(
    val name:String
) {
    open  fun chekPay(card: Card, paySum: Double, Limit:Double){
        println("\nАдмин $name проверяет карту ${card.number}")
        if(paySum>Limit){
            println("Сумма $paySum больше лимита $Limit.Блокируем!!")
            card.block()
        }
        else{
            println("Все хорошо, сумма $paySum в норме")
        }
    }
}
class MainAdmin(name: String):Admin(name){
    fun blockAnyCard(card: Card){
        println("\nГлавный админ $name блокирует карту ${card.number}")
        card.block()
    }
}