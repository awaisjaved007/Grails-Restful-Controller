package inventorystore

import com.jfreaks.auth.Role
import com.jfreaks.auth.User
import com.jfreaks.auth.UserRole

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def testUser1 = new User(username: 'admin', enabled: true, password: 'admin')
        def testUser2 = new User(username: 'user', enabled: true, password: 'user')
        testUser1.save(flush: true)
        testUser2.save(flush: true)

        UserRole.create(testUser1, adminRole, true)
        UserRole.create(testUser2, userRole, true)
    }
    def destroy = {
    }
}
