<div class="wrapper wrapper-content animated fadeInRight">
        <div class="col-sm-12">
            <div class="ibox">
                <div class="ibox-body">
                    <div id="exampleToolbar" role="group">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">查询条件</h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                                        <label for="nameInput" class="control-label">企业名称：</label>
                                        <input type="text" class="form-filter form-control _search"  name="search_like_enterprise_chinese_name"  />
                                    </div>

                                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                                        <label for="type_input" class="control-label">企业主攻行业：&nbsp;</label>
                                        <select id="type_input" name="search_eq_announcement_number" class="form-control _search" >
                                            <option value="">请选择</option>
		  								<#list mainIndustry as type>
		  									<option value="${type.jvalue}">${type.jvalue}</option>
                                        </#list>
                                        </select>
                                    </div>

                                </div>
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                                        <label for="type_input" class="control-label">年产值：&nbsp;</label>
                                        <select id="type_input" name="search_eq_output_value" class="form-control _search" >
                                            <option value="">请选择</option>
                                              <#list yearValues as yearvalue>
		  									<option value="${yearvalue.jvalue}">${yearvalue.jvalue}</option>
                                              </#list>

                                        </select>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 form-group">
                                        <label for="type_input" class="control-label">经营范围：&nbsp;</label>
                                        <select id="type_input" name="search_eq_business_scope" class="form-control _search" >
                                            <option value="">请选择</option>
                                         <#list businessScope as business>
		  									<option value="${business.jvalue}">${business.jvalue}</option>
                                         </#list>
                                        </select>
                                    </div>

                                </div>
                            </div>
                            <div class="panel-footer">
                                <button type="button" class="btn btn-success" onclick="re_load()">
                                    <i class="fa fa-search" aria-hidden="true"></i> 查询
                                </button>
                                <button type="button" class="btn btn-primary" onclick="reset()">
                                    <i class="fa fa-circle-thin" aria-hidden="true"></i> 重置
                                </button>
                                <button type="button" class="btn btn-danger" onclick="batch_remove()">
                                    <i class="fa fa-trash" aria-hidden="true"></i> 删除
                                </button>
                                <button type="button" class="btn btn-info" onclick="dt_insert()">
                                    <i class="fa fa-plus-square" aria-hidden="true"></i> 添加
                                </button>
                            </div>
                        </div>
                    </div>

                    <table class="table" id="exampleTable" data-mobile-responsive="true">
                    </table>
                </div>
            </div>
        </div>
</div>

<script type="text/javascript">

    function getcolumns() {
        var c = [
            {
                checkbox: true
            },
            {
                field: 'enterpriseChineseName',
                title: '企业名称'
            },
            {
                field: 'enterpriseScale',
                title: '企业规模'
            },
            {
                field: 'outputValue',
                title: '年产值'
            },
            {
                field: 'businessScope',
                title: '经营范围'
            },
            {
                field: 'contactName',
                title: '联系人'
            },
            {
                field: 'cellphoneNumber',
                title: '电话'
            },
            {
                field: 'contactAddress',
                title: '地址'
            },
            {
                field : 'enterpriseWhere',
                title : '企业总部是否在国外',
                align : 'center'
            },
            {
                title: '操作',
                field: 'id',
                align: 'center',
                formatter: function (value, row, index) {

                    return dt_edit_button(row)+dt_detail_button(row)+dt_delete_button(row);
                }
            }];

        return c;
    }

    load_data( getcolumns(), {"createDate": "desc"});

    function dt_explort_buttont() {
        location.href=url + "excel";
    }
</script>