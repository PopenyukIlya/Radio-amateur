<#import "parts/common.ftlh" as c>
<@c.page>

    <h2>List of users</h2>
    <table class="table-responsive-sm table-hover table-striped table-bordered ">
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>

<#list users as user>
    <tr>
        <td>${user.username}</td>
        <td><#list user.roles as role>${role}<#sep>, </#list></td>
        <td><a class="btn btn-primary" href="/adminusereditormenu/${user.id}">Edit</a></td>
    </tr>
</#list>
        </tbody>
    </table>
</@c.page>