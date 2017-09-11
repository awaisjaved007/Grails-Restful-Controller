package blog

import com.jfreaks.auth.User
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.*

@Secured(['ROLE_USER'])
class BlogController extends RestfulController {
    static responseFormats = ['json', 'xml']
    SpringSecurityService springSecurityService

    BlogController() {
        super(Blog)
        render("hi blogger")
    }

    def postBlogData() {
        String a = request.JSON.headingMain
        String b = request.JSON.tagLine
        String c = request.JSON.blogContent
        String d = request.JSON.category

        def user = (User) springSecurityService.getCurrentUser()
        Author author = Author.findByUser(user)
        new Blog(headingMain: a, tagLine: b, blogContent: c, category: d, author: author).save(failOnError: true, flush: true);
        //author.save(flush:true);

    }

    def getBlogResult() {
        def results = Blog.findAll()
        respond results
    }
    def getAuthorBlog(){
    User user = (User) springSecurityService.getCurrentUser()
    def results = Blog.findAllByAuthor(Author.findAllByUser(user))
    respond results
    }
//
//def postBlogData(){
//    String a = request.JSON.headingMain
//   String b = request.JSON.tagLine
//   String c = request.JSON.blogContent
//  def  d = request.JSON.category
//    println(a)
//    Author author =  springSecurityService.getCurrentUser()
//    println(author.id)
//   // def blog = new Blog(headingMain: a, tagLine: b, blogContent:c,category:d)
//   // blog.save(flash:true,failOnError:true)
//
//}
//    def search() {
//       User user = springSecurityService.getCurrentUser()
//        println(user)
//
////
////        def query = Blog.findAll()
////        respond query
//    }

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
