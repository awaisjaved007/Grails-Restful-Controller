package blog

import com.jfreaks.auth.User
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.*
import grails.converters.*

@Secured(['ROLE_USER'])
class AuthorController extends RestfulController {
    static responseFormats = ['json', 'xml']
SpringSecurityService springSecurityService
    AuthorController() {
        super(Author)
        render("hi blogger")
    }

    def getAuthorProfile(){
        User user = (User) springSecurityService.getCurrentUser()
        def query = Author.findAllByUser(user)
        respond query
    }
    def getProfile(){
        def query = Author.findAllBy
    }

}
