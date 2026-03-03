package bank

open class Card (
    val number:String,
    val account: Account,
    var blocked: Boolean=false
) {
    open fun pay(sum:Double):Boolean{
        if (blocked){
            println("Карта $number заблокирована")
            return false
        }
        println("Платим картой $number сумму $sum")
        return account.take(sum)
    }
    open fun block(){
        blocked=true
        println("Карта $number заблокирована")
    }
}
class CashbackCard(number: String,account: Account):Card(number, account){
    override  fun pay(sum: Double):Boolean{
        if(blocked){
            println("Карта $number заблокирована")
            return false
        }
        println("Платим картой $number (с кэшбэком ")
        val result=account.take(sum)
        if(result){
            account.add(10.0) // кэшбэк 10 рублей
            println("Кэшбэк 10 рублей")
        }
        return  result
    }
}