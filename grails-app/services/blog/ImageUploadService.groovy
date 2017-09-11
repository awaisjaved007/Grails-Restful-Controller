package blog

import amazonS3.AmazonStorageService
import com.jfreaks.auth.User
import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional

@Transactional
class ImageUploadService {

    AmazonStorageService amazonStorageService
    SpringSecurityService springSecurityService

    def uploadBlogImage(String name, String data) {
        User user = springSecurityService.getCurrentUser()
       // Merchant merchant = Merchant.findByUser(user)
        String url = amazonStorageService.uploadFile(name, data)
        user.logoUrl = url
        user.save()
    }

    def uploadProfileImage(String name , String data) {
        User user = springSecurityService.getCurrentUser()
    //  Merchant merchant = Merchant.findByUser(user)
        String url = amazonStorageService.uploadFile(name , data)
        user.profileUrl = url
        user.save()
    }
    def serviceMethod() {

    }
}
