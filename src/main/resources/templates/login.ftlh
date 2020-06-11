<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as e>
    <@c.page>
Login page

<@e.login "/login"/>
<a href="/registration">Add new user</a>
</@c.page>