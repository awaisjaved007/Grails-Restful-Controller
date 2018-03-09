package blog

import com.jfreaks.auth.User
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.*
import org.springframework.http.HttpStatus

@Secured(['ROLE_USER'])
class BlogController extends RestfulController<Blog> {
    static responseFormats = ['json', 'xml']
    SpringSecurityService springSecurityService
    BlogService blogService
    BlogController() {
        super(Blog)
    }

    def postBlog() {
        Blog blog = blogService.postJob(request.JSON)
        if(blog.hasErrors()){
            respond status: HttpStatus.BAD_REQUEST
        }else {
            respond status: HttpStatus.OK
        }
    }

    def getBlogResult() {
        def results = Blog.findAll()
        respond results
    }

    def getAuthorBlog() {
        User user = (User) springSecurityService.getCurrentUser()
        def results = Blog.findAllByAuthor(Author.findAllByUser(user))
        respond results
    }

    def searchCategories() {
        def query = Blog.findAllByCategory(params.get('categoryId'))
        respond query
    }

    def texutalSearch() {
        def textQuery = params.get('textQuery')
        def results = Blog.findAllByTitleIlike("%$textQuery%")
        respond results

    }
}
