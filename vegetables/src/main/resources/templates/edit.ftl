<#import "layout.ftl" as com>
<@com.layout>
<form method="post" action="/${vegetable.name}/edit">
    <input type="text" id="description" name="description" value="${vegetable.description}">Description</input><br/>
    <button type="submit" id="save" class="btn">Change</button>
</form>
</@com.layout>