package blog

import com.jfreaks.auth.User


class Blog {

    String headingMain
    String tagLine
    String blogContent
    String category
    static belongsTo = [author: Author]
    static constraints = {
        author nullable: true
    }

}
