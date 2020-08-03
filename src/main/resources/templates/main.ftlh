<#--<#import "parts/common.ftlh" as c>-->
<#--<@c.page>-->
<#--    <div class="form-row">-->
<#--        <div class="form-group col-md-6">-->
<#--            <form method="get" action="/main" class="form-inline">-->
<#--                <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by tag">-->
<#--                <button type="submit" class="btn btn-primary ml-2">Search</button>-->
<#--            </form>-->
<#--        </div>-->
<#--    </div>-->

<#--    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">-->
<#--        Add new Message-->
<#--    </a>-->
<#--    <div class="collapse <#if message??>show</#if>" id="collapseExample">-->
<#--        <div class="form-group mt-3">-->
<#--            <form method="post" enctype="multipart/form-data">-->
<#--                <div class="form-group">-->
<#--                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"-->
<#--                           value="<#if message??>${message.text}</#if>" name="text" placeholder="Введите сообщение" />-->
<#--                    <#if textError??>-->
<#--                        <div class="invalid-feedback">-->
<#--                            ${textError}-->
<#--                        </div>-->
<#--                    </#if>-->
<#--                </div>-->
<#--                <div class="form-group">-->
<#--                    <input type="text" class="form-control"-->
<#--                           value="<#if message??>${message.tag}</#if>" name="tag" placeholder="Тэг">-->
<#--                    <#if tagError??>-->
<#--                        <div class="invalid-feedback">-->
<#--                            ${tagError}-->
<#--                        </div>-->
<#--                    </#if>-->
<#--                </div>-->
<#--                <div class="form-group">-->
<#--                    <div class="custom-file">-->
<#--                        <input type="file" name="file" id="customFile">-->
<#--                        <label class="custom-file-label" for="customFile">Choose file</label>-->
<#--                    </div>-->
<#--                </div>-->
<#--                <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
<#--                <div class="form-group">-->
<#--                    <button type="submit" class="btn btn-primary">Добавить</button>-->
<#--                </div>-->
<#--            </form>-->
<#--        </div>-->
<#--    </div>-->

<#--    <div class="card-columns">-->
<#--        <#list products as product>-->
<#--            <div class="card my-3">-->
<#--                <#if product.filename??>-->
<#--                    <img src="/img/${product.filename}" class="card-img-top">-->
<#--                </#if>-->
<#--                <div class="m-2">-->
<#--                    <span>${product.text}</span>-->
<#--                    <i>${product.tag}</i>-->
<#--                </div>-->
<#--            </div>-->
<#--        <#else>-->
<#--            No products-->
<#--        </#list>-->
<#--    </div>-->
<#--</@c.page>-->