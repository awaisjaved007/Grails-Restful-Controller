package amazonS3

import com.amazonaws.AmazonServiceException
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import groovy.util.logging.Slf4j
import org.apache.commons.lang.RandomStringUtils

import javax.annotation.PostConstruct

@Slf4j
class AmazonStorageService {

    String accessKeyId
    String secretAccessKey
    String bucketName
    String bucketUrl
    String prefix

    String url
    AmazonS3Client s3client
    CannedAccessControlList acl = CannedAccessControlList.PublicRead

    @PostConstruct
    private void init() {
        if (accessKeyId && secretAccessKey) {
            s3client = new AmazonS3Client(new BasicAWSCredentials(accessKeyId, secretAccessKey))
        } else {
            log.warn("No AWS access key or secret key found in config. Attempts to use storage service will fail")
        }
    }

    String uploadFile(String name, String data) {

        if (name.isEmpty() || data.isEmpty()) {

            throw new IllegalArgumentException("Invalid arguments for uploading file to S3")
        }

        String fileName = null
        String charSet = (String) (('A'..'Z') + ('0'..'9')).join()
        String random = RandomStringUtils.random(9, charSet.toCharArray())
        fileName = random + '_' + name

        try {
            url = bucketUrl + '/' + bucketName + '/' + prefix + '/' + fileName

            if (!(data.contains("http"))) {
                File file = convertToFile(name, data)
                s3client.putObject(new PutObjectRequest(bucketName, prefix + '/' + fileName, file).withCannedAcl(acl))
            }
            return url.toString()
        }
        catch (IOException e) {
            println("IOException")
        }
        catch (Exception e) {
            e.printStackTrace()
        }
    }

    String upload(String name, InputStream inputStream, long contentLength) {
        if (contentLength > 0) {
            ObjectMetadata metadata = new ObjectMetadata()
            metadata.setContentLength(contentLength)
            s3client.putObject(new PutObjectRequest(bucketName, name, inputStream, metadata).withCannedAcl(acl))
            getUrl(name)
        } else {
            upload(name, inputStream)
        }
    }

    String upload(String name, byte[] data) {
        upload(name, new ByteArrayInputStream(data), data.length)
    }

    String getUrl(String name) {
        s3client.getUrl(bucketName, name)
    }

    Boolean exists(String name) {
        try {
            s3client.getObjectMetadata(bucketName, name)
            true
        } catch (AmazonServiceException e) {
            false
        }
    }

    File convertToFile(String name, String data) {

        if (name.contains('.jpg') || name.contains('.png')) {

            data = data.substring(data.indexOf(',') + 1)
        }
        byte[] decoded = Base64.getMimeDecoder().decode(data)
        File file = new File(name)
        FileOutputStream fop = new FileOutputStream(file)
        if (!(file.exists())) {
            file.createNewFile()
        }
        fop.write(decoded)
        fop.close()
        return file
    }

}
