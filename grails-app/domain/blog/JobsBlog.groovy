package blog

class JobsBlog {
    Date dateCreated
    Date lastUpdated
    String headingMain
    String tagLine
    String blogContent
    String category
    BigDecimal salary
    Integer totalPositions
    Date lastDateToApply
    Date jobPublishedDate
    String newsPaperName
    static belongsTo = [author: Author]
    static constraints = {
        salary nullable: true
        totalPositions nullable: true
        lastDateToApply nullable: true
        jobPublishedDate nullable: true
        newsPaperName nullable: true
    }
}
