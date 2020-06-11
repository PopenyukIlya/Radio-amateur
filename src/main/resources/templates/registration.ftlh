<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as e>
<@c.page>
Add new user
    ${message?ifExists}

<@e.login "/registration" />
</@c.page>