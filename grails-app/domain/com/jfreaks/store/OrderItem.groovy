package com.jfreaks.store

class OrderItem {

    Integer quantity
    Inventory inventory

    //static belongsTo= [order: Order]

    Float getPricePerItem() {
        inventory.unitPrice * quantity
    }

    static constraints = {
    }
}
