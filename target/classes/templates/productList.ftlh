<#import "parts/common.ftlh" as c>
<@c.page>
    <h2>List of products</h2>
    <table class="table-responsive-sm table-hover table-striped table-bordered ">
    <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Category</th>
            <th>Photo</th>
            <th></th>
            <th></th>
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
                <td><a class="btn btn-primary" href="/adminproducteditormenu/${product.id}">Edit</a></td>
                <td><a class="btn btn-danger" href="/adminproducteditormenu/deleteproduct/${product.id}">Delete</a></td>
            </tr>
        </#list>
        </tbody>
    </table>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new Product
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data" class="form-inline">
                <div class="form-group">
                    <input type="text" class="form-control"
                           value="<#if product??>${product.name}</#if>" name="name" placeholder="Name">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control"
                           value="<#if product??>${product.price}</#if>" name="price" placeholder="Price">
                </div>
                <div class="form-group">
<#--                    <input type="text" class="form-control"-->
<#--                           value="<#if product??>${product.category}</#if>" name="category" placeholder="Category">-->
                    <select id="category" name="category" class="form-control">
                        <option selected>Choose category</option>
                        <#list categories as category>
                        <option value=${category.name}>${category.name}</option>
                     </#list>
                    </select>
                </div>

                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile">Choose file</label>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Add Product</button>
                </div>
            </form>
        </div>
    </div>
</br>
    <h2>List of categories</h2>
    <table class="table-responsive-sm table-hover table-striped table-bordered ">
    <thead>
        <tr>
            <th>Name</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list categories as category>
            <tr>
                <td>${category.name}</td>
                <td><a class="btn btn-primary" href="/adminproducteditormenu/category/${category.id}">Edit</a></td>
                <td><a class="btn btn-danger" href="/adminproducteditormenu/deletecategory/${category.id}">Delete</a></td>
            </tr>
        </#list>
        </tbody>
    </table>



        <div class="form-group mt-3">
            <form action="/adminproducteditormenu/addcategory" method="post" class="form-inline">
                <div class="form-group">
                    <input type="text" class="form-control" name="name" placeholder="Name">
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Add category</button>
                </div>
            </form>
        </div>


</@c.page>