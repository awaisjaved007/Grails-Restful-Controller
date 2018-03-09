package blog

import amazonS3.AmazonStorageService
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.*


import java.awt.Image

class ImageController extends RestfulController {
    static responseFormats = ['json']

    AmazonStorageService amazonStorageService
    ImageUploadService imageUploadService

    ImageController(){
        super(Image)
    }

    @Secured(['ROLE_USER'])
    def save(){

        String url = amazonStorageService.uploadFile(request.JSON.fileName , request.JSON.data)
        println(url)
        Image image = (Image)createResource(name:request.JSON.fileName , url:url)
    }

    @Secured(['ROLE_USER'])
    def uploadImage(){

        if(request.JSON.type == "blogImage"){
            imageUploadService.uploadBlogImage(request.JSON.fileName , request.JSON.data)
        }
        else{
            imageUploadService.uploadProfileImage(request.JSON.fileName , request.JSON.data)
        }

        String url = amazonStorageService.url
        Image image = (Image)createResource(name:request.JSON.fileName , url:url)
        //image.validate()
        //image.save()
    }
}
