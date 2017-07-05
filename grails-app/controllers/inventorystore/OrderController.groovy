package inventorystore

import com.jfreaks.store.Order
import grails.rest.*
import grails.converters.*

class OrderController extends RestfulController {
    static responseFormats = ['json', 'xml']

    OrderController() {
        super(Order)
    }

    def index() {}
}
