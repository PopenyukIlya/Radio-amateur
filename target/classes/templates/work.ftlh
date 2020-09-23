<li class="nav-item">
    <a class="nav-link" >Products</a>
</li>



<li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="/main" role="button" aria-haspopup="true" aria-expanded="false">Products</a>
    <div class="dropdown-menu">
        <#list categories as category>
        <a class="dropdown-item" href="/${category.name}">${category.name}</a>
        </#list>
    </div>
</li>