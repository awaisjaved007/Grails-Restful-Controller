import amazonS3.AmazonStorageService
import cors.CorsFilter


// Place your Spring DSL code here
beans = {
    corsFilter(CorsFilter)

    String _accessKeyId = application.config.getProperty('amazon.accessKeyId', String, null)
    String _secretAccessKey = application.config.getProperty('amazon.secretAccessKey', String, null)
    String _bucketName = application.config.getProperty('amazon.bucketName' , String , null)
    String _bucketUrl = application.config.getProperty('amazon.bucketUrl' , String , null)
    String _prefix = application.config.getProperty('amazon.prefix' , String , null)

    amazonStorageService(AmazonStorageService) {
        accessKeyId = _accessKeyId
        secretAccessKey = _secretAccessKey
        bucketName = _bucketName
        bucketUrl = _bucketUrl
        prefix = _prefix
    }
}