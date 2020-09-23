<#import "parts/common.ftlh" as c>
<@c.page>

<h2>Cart</h2>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Category</th>
        <th>Photo</th>
    </tr>
    </thead>
    <tbody>
    <#list products as product>
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.category}</td>
            <td><#if product.filename??>
                    <img src="/img/${product.filename}" class="w-25 p-2 mb-3" style="background-color: #eee;">
                </#if></td>
            <td><a href="/cart/deleteproduct/${product.id}">Delete</a></td>
        </tr>
          <#else>
            No products
    </#list>
    </tbody>

</table>
</@c.page>