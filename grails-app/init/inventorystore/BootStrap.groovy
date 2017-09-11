package inventorystore

import blog.Author
import com.jfreaks.auth.Role
import com.jfreaks.auth.User
import com.jfreaks.auth.UserRole

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def testUser1 = new User(username: 'admin', enabled: true, password: 'admin')
        def testUser2 = new User(username: 'user2', enabled: true, password: 'user2')
        def testUser3 = new User(username: 'user3', enabled: true, password: 'user3')
        def testUser4 = new User(username: 'user4', enabled: true, password: 'user4')
        def testUser5 = new User(username: 'user5', enabled: true, password: 'user5')
        def testUser6 = new User(username: 'user6', enabled: true, password: 'user6')
        def author2 = new Author(authorName: 'Ali', authorType: 'Blogger', authorDescription: 'developing blogger site',user: testUser2)
        def author3 = new Author(authorName: 'Awais', authorType: 'Blogger', authorDescription: 'developing blogger site',user: testUser3)
        def author4 = new Author(authorName: 'irtiza', authorType: 'Blogger', authorDescription: 'developing blogger site',user: testUser4)
        def author5 = new Author(authorName: 'jalal', authorType: 'Blogger', authorDescription: 'developing blogger site',user: testUser5)
        def author6 = new Author(authorName: 'atif', authorType: 'Blogger', authorDescription: 'developing blogger site',user: testUser6)
        testUser1.save(flush: true)
        testUser2.save(flush: true)
        testUser3.save(flush: true)
        testUser4.save(flush: true)
        testUser5.save(flush: true)
        testUser6.save(flush: true)
        author2.save(flush: true)
        author3.save(flush: true)
        author4.save(flush: true)
        author5.save(flush: true)
        author6.save(flush: true)

        UserRole.create(testUser1, adminRole, true)
        UserRole.create(testUser2, userRole, true)
        UserRole.create(testUser3, userRole, true)
        UserRole.create(testUser4, userRole, true)
        UserRole.create(testUser5, userRole, true)
        UserRole.create(testUser6, userRole, true)
    }
    def destroy = {
    }
}
