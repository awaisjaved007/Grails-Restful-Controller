package blog

class Image {
    String name
    String url
    static constraints = {
        name size: 1..28 , nullable: true
        url url: false , blank: true , nullable: true
    }
}
