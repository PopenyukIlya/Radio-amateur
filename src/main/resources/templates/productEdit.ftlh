<#import "parts/common.ftlh" as c>
<@c.page>
    <div class="form-group mt-3">

        <form method="post" action="/adminproducteditormenu/${product.id}" enctype="multipart/form-data">
            <div class="form-group">
                <i>Name</i>
                <input type="text" class="form-control"
                        name="name" placeholder="Name"
                       value="${product.name}">

            </div>
            <div class="form-group">
                <i>Price</i>
                <input type="text" class="form-control"
                        name="price" placeholder="Price"
                       value="${product.price}">
            </div>
            <div class="form-group" >
                <i>Category</i>
                <input type="text" class="form-control"
                        name="category" placeholder="Category"
                       value="${product.category}">
            </div>
            <div class="form-group">
                <i>Description</i>
                <input type="text" class="form-control"
                        name="description" placeholder="Description"
                       value="${product.description!''}"/>
            </div>
            <div class="form-group">
                <i>Choose file</i>
                <#if product.filename??>
                    <img src="/img/${product.filename}" class="w-25 p-3" style="background-color: #eee;">
                </#if>
                <div class="custom-file">
                    <input type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Update Product</button>
            </div>
        </form>
    </div>

</@c.page>