package shop
open class Order(
    val id:Int,
    val price:Double,
    val name :String ="Товар"
) {
    fun show(){
        println("Заказ №$id: name - $price руб.")
    }
}
class UrgentOrder(id: Int, price: Double,name: String="Срочный товар"):
    Order(id, price*1.2, name){   //наценка 20%
    fun shopUrgent(){
        println("СРОЧНЫЙ ЗАКАЗ №$id: $name - $price руб.(с учетом наценки)")
    }
}