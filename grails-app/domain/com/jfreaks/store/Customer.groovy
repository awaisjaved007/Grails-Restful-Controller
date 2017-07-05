package com.jfreaks.store

import com.jfreaks.auth.User

class Customer {

    User user

    static hasMany = [orders: Order]

    static constraints = {
    }
}
