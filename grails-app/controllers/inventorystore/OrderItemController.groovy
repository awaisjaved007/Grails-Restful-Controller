package inventorystore

import com.jfreaks.store.OrderItem
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.*
import grails.converters.*

@Secured(['ROLE_ADMIN'])
class OrderItemController extends RestfulController {
    static responseFormats = ['json', 'xml']

    OrderItemController()
    {
        super(OrderItem)
    }

}
