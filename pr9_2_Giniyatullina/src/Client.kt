package people

import  bank.Account
import bank.Card
import  shop.Order

open class Client (
    val name:String,
    val account:Account,
    val card: Card
) {
    open fun payOrder(order:Order){
        println("\nКлиент $name платит за заказ №${order.id}")
        if (card.pay(order.price)){
            println("Заказ №${order.id} оплачен")
        }
    }
    open  fun transfer(toAccount: Account,sum:Double){
        println("\nКлиент $name переводит $sum на счет ${toAccount.number}")
        if(account.take(sum)){
            toAccount.add(sum)
            println("Перевод выполнен")
        }
    }
    open fun blockCard(){
        println("\nКлиент $name блокирует карту")
        card.block()
    }
    open fun closeAccount(){
        println("\nКлиет $name закрывает счет")
        account.close()
    }
}
class VipClient(name: String,account: Account,card: Card):Client(name, account, card){
    override fun payOrder(order:Order){
        val priceWithSale = order.price *0.9 // скидка 10%
        println("\nVIP клиент $name платит со скидкой 10%")
        println("Было ${order.price},стало $priceWithSale")
        if(card.pay(priceWithSale)){
            println("Заказ №${order.id} оплачен")
        }
    }
}