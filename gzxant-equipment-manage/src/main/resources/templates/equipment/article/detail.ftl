<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">

                    <form class="form-horizontal form-bordered" id="gzxantForm">
                        <input type="hidden" name="id" value="${sysUser.id}"/>
                        <input type="hidden" name="photo" value="${sysUser.photo}" id="photo"/>



                        <div class="form-group">
                            <label class="col-sm-3 control-label">登录名<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="loginName" placeholder="请输入登录名"
                                       value="${sysUser.loginName}" required aria-required="true"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">用户名<span class="required">*</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="name" placeholder="请输入用户名"
                                       value="${sysUser.name}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">电子邮件<span class="required">*</span></label>

                            <div class="col-sm-8">
                                <input name="email" type="email" class="form-control" value="${sysUser.email}"
                                       placeholder="电子邮件地址">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">密码<#if action !='update'><span
                                    class="required">*</span></#if></label>

                            <div class="col-sm-8">
                                <div class="input-icon right">
                                    <input name="password" type="password" class="form-control"
                                           placeholder="请输入登录密码">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">工号<span class="required">*</span></label>

                            <div class="col-sm-8">
                                <input name="no" type="text" class="form-control" value="${sysUser.no}"
                                       placeholder="工号">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label">电话</label>

                            <div class="col-sm-3">
                                <div class="input-group">
                                    <input name="phone" type="text" class="form-control" value="${sysUser.phone}"
                                           placeholder="电话">
                                </div>
                            </div>

                            <label class="col-sm-2 control-label">手机</label>

                            <div class="col-sm-3">
                                <input name="mobile" type="text" class="form-control" value="${sysUser.mobile}"
                                       placeholder="手机">
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-3 control-label">备注</label>

                            <div class="col-sm-8">
                                <input name="remark" type="text" class="form-control" value="${sysUser.remark}"
                                       placeholder="备注">
                            </div>
                        </div>

                    <#if action !='detail'>
                        <div class="form-actions fluid">
                            <div class="col-md-offset-3 col-md-9">
                                <button type="submit" class="btn btn-info">保存</button>
                            </div>
                        </div>
                    </#if>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">








</script>
