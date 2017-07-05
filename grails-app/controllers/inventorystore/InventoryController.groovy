package inventorystore

import com.jfreaks.store.Inventory
import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.*

@Secured(['ROLE_ADMIN'])
class InventoryController extends RestfulController {
    static responseFormats = ['json', 'xml']

    InventoryController() {
        super(Inventory)
    }
}
