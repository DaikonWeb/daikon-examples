class Html(private val title: String, private val body: String) {
    fun text(): String {
        return """
<html>
    <head>
        <link href="/public/css/style.css" rel="stylesheet">
        <title>$title</title>
    </head>
    <body>
        <h1>$title</h1>
        $body    
    </body>
</html>
"""
    }

}
