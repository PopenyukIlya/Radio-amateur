<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/main" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by tag">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>



    <div class="card-columns">
        <#list products as product>
            <div class="card my-3">
                <#if product.filename??>
                    <img src="/img/${product.filename}" class="card-img-top">
                </#if>
                <div class="m-2">
                    <span>${product.name}</span>
                    <i>${product.category}</i>
                </div>
                <div class="card-footer text-muted">
                    ${product.price} <b><i>BYN</i></b>
                </div>
            </div>
        <#else>
            No products
        </#list>
    </div>
</@c.page>