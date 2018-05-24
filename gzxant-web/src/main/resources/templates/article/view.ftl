
    <link href="http://twitter.github.com/bootstrap/assets/js/google-code-prettify/prettify.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
    <link href="${rc.contextPath}/wysiwyg/index.css" rel="stylesheet">
    
    <script src="${rc.contextPath}/wysiwyg/external/jquery.hotkeys.js"></script>
      <script src="${rc.contextPath}/js/bootstrap.min.js"></script>
      <script src="${rc.contextPath}/wysiwyg/bootstrap-wysiwyg.js"></script>
      <script src="${rc.contextPath}/wysiwyg/external/google-code-prettify/prettify.js"></script>
	<div id="editor" style="margin:30px 30px">
	      	${article.articleContent}
	</div>

<div class="container-fluid">
	<div class="col-sm-5"></div>
    <div class="col-sm-2">
    	<button type="button" onclick="back()" class="btn btn-info" style="margin-top:20px">返回</button>
    </div>
    <div class="col-sm-5"></div>
</div>
<script src="http://cdn.bootcss.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
<script src="${rc.contextPath}/wysiwyg/bootstrap-wysiwyg.js"></script>
<script>
    $(function () {
        //$('#editor').wysiwyg();
    });
    
function back() {
	window.history.back();
}
</script>