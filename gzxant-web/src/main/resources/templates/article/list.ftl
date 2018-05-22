<script src="${rc.contextPath}/js/plugins/iTable/iTable.js" type="text/javascript"></script>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="col-sm-12">
        <div class="ibox">
            <div class="ibox-body">
                <div id="exampleToolbar" role="group">
                    <div class="row">

                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                            <label for="nameInput" class="control-label">文章名称</label>
                            <input type="text" class="form-filter form-control _search" id="nameInput" name="search_like_name"  />
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
    function getColumns() {
        var c = [
            {
                checkbox: true
            },
            {
                field: 'id', // 列字段名
                title: '序号' // 列标题
            },
            {
                field: 'name',
                title: '文章名称'
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


    var standardTable = $("#exampleTable").iTable({
        toolbar : {
            id : "exampleToolbar",
            auto : true,
            exclude_btn : ["dt_insert"],
            include_btn : [
                {
                    id : "btn_insert",
                    className : "btn-info",
                    icon : "fa fa-plus-square",
                    title : "添加",
                    click: function() {
                        window.location.href = url + "add";
                    }
                }
            ]
        },
        data : {
            columns : getColumns()
        }
    });
    //$(".bars").css("width", "100%");
</script>