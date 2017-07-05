package inventorystore

import com.jfreaks.store.Customer
import grails.rest.*
import grails.converters.*

class CustomerController extends RestfulController {
    static responseFormats = ['json', 'xml']

    CustomerController() {
        super(Customer)
    }

    def index() {}
}
