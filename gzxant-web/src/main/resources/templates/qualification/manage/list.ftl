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
								<input type="hidden" class="form-filter form-control _search" name="search_eq_del_flag" value="Y" />
                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 form-group">
                                    <label for="nameInput" class="control-label">认证人姓名</label>
                                    <input type="text" class="form-filter form-control _search" id="nameInput" name="search_like_name"  />
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
                field: 'name',
                title: '姓名'
            },
            {
                field: 'phone',
                title: '电话'
            },
            {
                field: 'enterprise',
                title: '企业'
            },
            {
                field: 'createDate',
                title: '申请时间',
                formatter: function (value, row, index) {
                    return datetimeFormat(value);
                }
            },
            {
                field: 'verifyDate',
                title: '审核时间',
                formatter: function (value, row, index) {
                	if (!value) {
                		return "-";
                	}
                    return datetimeFormat(value);
                }
            },
            {
                field: 'state',
                title: '审核状态',
                formatter: function (value, row, index) {
                	if (!value) {
	                    return "<span style='color:#f8ac59'>未审核</span>"; 
                	}
                	
                	if (value == "Y") {
                		return "<span style='color:green'>已通过</span>"; 
                	}
					
                	if (value == "N") {
                		return "<span style='color:red'>未通过</span>"; 
                	}
				}
            },
            {
                field: 'code',
                title: '授权编号'
            },
            {
                title: '操作',
                field: 'id',
                align: 'center',
                formatter: function (value, row, index) {
                    return dt_edit_button(row)+dt_delete_button(row);
                }
            }];

        return c;
    }

    load_data( getcolumns(), {"createDate": "desc"});
    //$(".bars").css("width", "100%");
    
    function datetimeFormat(longTypeDate){  
	    var datetimeType = "";  
	    var date = new Date();  
	    date.setTime(longTypeDate);  
	    datetimeType+= date.getFullYear();   //年  
	    datetimeType+= "-" + getMonth(date); //月   
	    datetimeType += "-" + getDay(date);   //日  
	    datetimeType+= "&nbsp;&nbsp;" + getHours(date);   //时  
	    datetimeType+= ":" + getMinutes(date);      //分
	    datetimeType+= ":" + getSeconds(date);      //分
	    return datetimeType;
	} 
	//返回 01-12 的月份值   
	function getMonth(date){  
	    var month = "";  
	    month = date.getMonth() + 1; //getMonth()得到的月份是0-11  
	    if(month<10){  
	        month = "0" + month;  
	    }  
	    return month;  
	}  
	//返回01-30的日期  
	function getDay(date){  
	    var day = "";  
	    day = date.getDate();  
	    if(day<10){  
	        day = "0" + day;  
	    }  
	    return day;  
	}
	//返回小时
	function getHours(date){
	    var hours = "";
	    hours = date.getHours();
	    if(hours<10){  
	        hours = "0" + hours;  
	    }  
	    return hours;  
	}
	//返回分
	function getMinutes(date){
	    var minute = "";
	    minute = date.getMinutes();
	    if(minute<10){  
	        minute = "0" + minute;  
	    }  
	    return minute;  
	}
	//返回秒
	function getSeconds(date){
	    var second = "";
	    second = date.getSeconds();
	    if(second<10){  
	        second = "0" + second;  
	    }  
	    return second;  
	}
</script>