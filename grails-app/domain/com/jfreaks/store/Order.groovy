package com.jfreaks.store

class Order {

    Float totalPrice
    static belongsTo=Customer
    static hasMany=[orderItem:OrderItem]


    static constraints = {
    }
    static mapping = {
        table 'CustomerOrder'
    }
}
