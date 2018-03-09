package blog

class UrlMappings {

    static mappings = {
        delete "/api/$controller/$id(.$format)?"(action:"delete")
        get "/api/$controller(.$format)?"(action:"index")
        get "/api/$controller/$id(.$format)?"(action:"show")
        post "/api/$controller(.$format)?"(action:"save")
        put "/api/$controller/$id(.$format)?"(action:"update")
        patch "/api/$controller/$id(.$format)?"(action:"patch")

       // "/api/blogPost"(controller: 'blog', action: 'savePost', method: 'POST')
        "/api/post-blog"(controller: 'blog', action: 'postBlog', method: 'POST')
        "/api/getBlogData"(controller: 'blog', action: 'getBlogResult', method: 'GET')
        "/api/getAuthorProfile"(controller: 'author', action: 'getAuthorProfile', method: 'GET')
        "/api/authorBlogs"(controller: 'blog', action: 'getAuthorBlog', method: 'GET')
        "/api/search"(controller: 'blog', action: 'searchCategories', method: 'GET')
        "/api/search"(controller: 'blog', action: 'texutalSearch', method: 'GET')
        "/api/uploadImage"(controller: 'image', action: 'uploadImage', method: 'GET')
        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
