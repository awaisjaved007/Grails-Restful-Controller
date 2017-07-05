package inventorystore

import com.jfreaks.auth.User
import grails.rest.*
import grails.converters.*
import org.springframework.security.access.annotation.Secured

@Secured('permitAll')
class TestController extends RestfulController {
	static responseFormats = ['json', 'xml']

    TestController()
    {
        super(User)
    }

}
