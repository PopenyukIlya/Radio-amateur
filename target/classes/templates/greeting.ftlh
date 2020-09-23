<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<@c.page>
    <h2>Hello, <#if user??>${name}<#else>guest</#if></h2>
    <h6>What about this project</h6>
    <ul>
        <li>bla</li>
        <li>blablabal</li>
        <li>ada</li>
        <li>sda</li>
    </ul>
</@c.page>