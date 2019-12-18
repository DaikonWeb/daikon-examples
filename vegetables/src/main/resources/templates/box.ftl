<#import "layout.ftl" as com>
<@com.layout>
<a href="/add" id="add" class="btn">Put in the box</a>
<div class="divTable">
    <div class="divTableBody">
    <#list vegetables as it>
        <div class="divTableRow">
            <div class="divTableCell"><a href="/${it.name}" id="${it.name}">${it.name}</a></div>
            <div class="divTableCell">
                <a href="/${it.name}/edit" id="Edit${it.name}">change</a>
                <form action="/${it.name}/delete" method="post" class="action">
                    <button type="submit" id="Eat${it.name}">eat</button>
                </form>
            </div>
        </div>
    </#list>
    </div>
</div>
</@com.layout>