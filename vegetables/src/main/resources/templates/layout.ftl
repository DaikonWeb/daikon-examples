<#macro layout>
<html>
    <head>
        <link href="/public/css/style.css" rel="stylesheet">
        <title>${title}</title>
    </head>
    <body>
        <h1>${title}</h1>
        <#nested>
    </body>
</html>
</#macro>