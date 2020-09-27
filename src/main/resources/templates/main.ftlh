<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<@c.page>
<#--    поиск-->
<#--    <div class="form-row">-->
<#--        <div class="form-group col-md-6">-->
<#--            <form method="get" action="/main" class="form-inline">-->
<#--                <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by tag">-->
<#--                <button type="submit" class="btn btn-primary ml-2">Search</button>-->
<#--            </form>-->
<#--        </div>-->
<#--    </div>-->



    <div class="card-columns ">
        <#list products as product>
            <div class="card p-3">
                <form action="/cartadd" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <input type="hidden" name="userId" value="${id}" />
                    <input type="hidden" name="productId" value="${product.id}" />
               <a href="/product/${product.id}">
                <#if product.filename??>
                    <img src="/img/${product.filename}"  class="card-img-top">
                </#if>
                <div class="m-1">
                    <span>${product.name}</span>
                </div></a>
                    <div class="m-1">
                    <i>${product.category}</i>
                </div>
                <div class="card-footer pl-4">
                    ${product.price} <b><i>BYN</i></b>
                    <button type="submit" class="btn btn-primary mx-5">Add to cart</button>
                </div>
                </form>
            </div>
        <#else>
            No products
        </#list>
    </div>
</@c.page>