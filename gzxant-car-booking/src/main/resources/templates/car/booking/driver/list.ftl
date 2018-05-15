<div class="wrapper animated fadeInRight">
    <div class="col-sm-12">
        <div class="ibox">
            <div class="ibox-body">
                <div id="gzxantToolbar" role="group">
			  		<div class="row">
						<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
						    <label for="number_input" class="control-label">司机编号</label>
						    <input type="text" class="form-filter form-control _search" id="number_input" name="search_like_number"  />
						</div>
						<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
						    <label for="city_input" class="control-label">用车城市</label>
						    <input type="text" class="form-filter form-control _search" id="city_input" name="search_like_city"  />
						</div>
						<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
						    <label for="name_input" class="control-label">司机姓名</label>
						    <input type="text" class="form-filter form-control _search" id="name_input" name="search_like_name"  />
						</div>
						<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
						    <label for="phone_input" class="control-label">手机号码</label>
						    <input type="text" class="form-filter form-control _search" id="phone_input" name="search_like_phone"  />
						</div>
	            	</div>
                </div>
                
                <table class="table" id="gzxantTable" data-mobile-responsive="true">
                </table>
            </div>
        </div>
    </div>
</div>

<script src="${rc.contextPath}/js/plugins/iTable/iTable.js"></script>
<script type="text/javascript">

    function getcolumns() {
        var c = [
            {
                field: 'number', // 列字段名
                align: 'center',
                title: '司机编号' // 列标题
            },
            {
                title: '司机姓名',
                field: 'name',
                align: 'center'
            },
            {
                field: 'phone',
                align: 'center',
                title: '手机号码'
            },
            {
                field: 'city',
                align: 'center',
                title: '服务城市'
            },
            {
                field: 'idCard',
                align: 'center',
                title: '身份证号码'
            },
            {
                field: 'license',
                align: 'center',
                title: '驾驶证号码'
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

    $("#gzxantTable").iTable({
    	toolbar : {
    		id : "gzxantToolbar",
    		auto : true
    	},
    	data : {
    		columns : getcolumns()
    	}
    });
    //load_data( getcolumns(), {});
</script>
