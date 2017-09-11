package blog

import com.jfreaks.auth.User

class Author {
    String authorName
    String authorType
    String authorDescription
    static belongsTo = [user:User]
    static hasMany = [blogs: Blog]
    static constraints = {
    }
}
