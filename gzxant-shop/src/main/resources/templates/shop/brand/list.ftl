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
                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                    <label for="parentSelect" class="control-label">品牌分类</label>
                                    <select class="form-filter form-control _search" id="parentSelect" name="">
                                        <option value="0">-- 请选择 --</option>
                                     <#list brands as brand>
                                        <option value="${brand.id}">${brand.chineseName}</option>
                                    </#list>
                                    </select>
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                    <label for="nameInput" class="control-label">品牌中文名称</label>
                                    <input type="text" class="form-filter form-control _search" id="nameInput" name="search_like_chineseName"  />
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                    <label for="nameInput" class="control-label">品牌英文名称</label>
                                    <input type="text" class="form-filter form-control _search" id="nameInput" name="search_like_englishName"  />
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
                field: 'id', // 列字段名
                title: '序号' // 列标题
            },
            {
                field: 'chineseName',
                title: '品牌中文名称'
            },
            {
                field: 'englishName',
                title: '品牌英文名称'
            },
            {
                field: 'logo',
                title: '商标'
            },
            {
                field: 'url',
                title: '品牌连接'
            },
            {
                field: 'remark',
                title: '备注'
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

    load_data( getcolumns(), {});
    //$(".bars").css("width", "100%");
</script>