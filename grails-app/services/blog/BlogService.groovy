package blog

import com.jfreaks.auth.User
import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional
import grails.util.TypeConvertingMap

@Transactional
class BlogService {
    SpringSecurityService springSecurityService

    User getLoggedInUser(){
        return  springSecurityService.loadCurrentUser()
    }

    Blog postJob(Map data) {
        Author author = Author.findByUser(this.getLoggedInUser())
        data['author'] = author
        data['jobPublishedDate'] = Date.parse("yyyy-MM-dd", data['jobPublishedDate'])
        data['lastDateToApply'] = Date.parse("yyyy-MM-dd", data['lastDateToApply'])
        Blog blog = new Blog(new TypeConvertingMap(data))
        blog.save()
        return blog
    }

}
