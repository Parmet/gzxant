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
                                    <label for="nameInput" class="control-label">标题</label>
                                    <input type="text" class="form-filter form-control _search" id="title" name="search_like_title"  />
                                </div>

                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                    <label for="nameInput" class="control-label">内容</label>
                                    <input type="text" class="form-filter form-control _search" id="content" name="search_like_content"  />
                                </div>

                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                    <label for="nameInput" class="control-label">类型</label>
                                    <input type="text" class="form-filter form-control _search" id="type" name="search_like_type"  />
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

                <table id="exampleTable" data-mobile-responsive="true">
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
                field: 'title',
                title: '文章标题'
            },
            {
                field: 'content',
                title: '文章内容'
            },
            {
                field: 'type',
                title: '文章类型'
            },
            {
                field: 'tags',
                title: '文章标签'
            },
            {
                field: 'categories',
                title: '文章分类'
            },
            {
                field: 'status',
                title: '文章状态'
            },
            {
                field: 'author',
                title: '文章作者'
            },
            {
                field: 'columnName',
                title: '文章栏目'
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