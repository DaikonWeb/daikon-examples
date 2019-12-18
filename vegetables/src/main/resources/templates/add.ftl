<#import "layout.ftl" as com>
<@com.layout>
<form method="post" action="/add">
    <input type="text" id="name" name="name">Name</input><br/>
    <input type="text" id="description" name="description">Description</input><br/>
    <button type="submit" id="save" class="btn">Add to box</button>
</form>
</@com.layout>