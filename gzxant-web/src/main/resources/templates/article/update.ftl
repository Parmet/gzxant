      <link href="http://twitter.github.com/bootstrap/assets/js/google-code-prettify/prettify.css" rel="stylesheet">
      <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
      <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-responsive.min.css" rel="stylesheet">
      <link href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
      <link href="${rc.contextPath}/wysiwyg/index.css" rel="stylesheet">
      <link href="${rc.contextPath}/wysiwyg/external/google-code-prettify/prettify.css" rel="stylesheet">

      <#--<script src="${rc.contextPath}/js/jquery.js"></script>-->
      <!--键盘事件-->
      <script src="${rc.contextPath}/wysiwyg/external/jquery.hotkeys.js"></script>
      <script src="${rc.contextPath}/js/bootstrap.min.js"></script>
      <script src="${rc.contextPath}/wysiwyg/bootstrap-wysiwyg.js"></script>
      <script src="${rc.contextPath}/wysiwyg/external/google-code-prettify/prettify.js"></script>



      <form class="form-horizontal form-bordered" id="gzxantForm">
      <div class="btn-toolbar" data-role="editor-toolbar" data-target="#editor" style="margin:0 50px">
          <div class="btn-group">
              <a class="btn dropdown-toggle" data-toggle="dropdown" title="Font"><i class="icon-font"></i><b class="caret"></b></a>
              <ul class="dropdown-menu">
              </ul>
          </div>
          <div class="btn-group">
              <a class="btn dropdown-toggle" data-toggle="dropdown" title="Font Size"><i class="icon-text-height"></i>&nbsp;<b class="caret"></b></a>
              <ul class="dropdown-menu">
                  <li><a data-edit="fontSize 5"><font size="5">一级标题</font></a></li>
                  <li><a data-edit="fontSize 3"><font size="3">二级标题</font></a></li>
                  <li><a data-edit="fontSize 1"><font size="1">正文</font></a></li>
              </ul>
          </div>
          <div class="btn-group">
              <a class="btn" data-edit="bold" title="Bold (Ctrl/Cmd+B)"><i class="icon-bold"></i></a>
              <a class="btn" data-edit="italic" title="Italic (Ctrl/Cmd+I)"><i class="icon-italic"></i></a>
              <a class="btn" data-edit="strikethrough" title="Strikethrough"><i class="icon-strikethrough"></i></a>
              <a class="btn" data-edit="underline" title="Underline (Ctrl/Cmd+U)"><i class="icon-underline"></i></a>
          </div>
          <div class="btn-group">
              <a class="btn" data-edit="insertunorderedlist" title="Bullet list"><i class="icon-list-ul"></i></a>
              <a class="btn" data-edit="insertorderedlist" title="Number list"><i class="icon-list-ol"></i></a>
              <a class="btn" data-edit="outdent" title="Reduce indent (Shift+Tab)"><i class="icon-indent-left"></i></a>
              <a class="btn" data-edit="indent" title="Indent (Tab)"><i class="icon-indent-right"></i></a>
          </div>
          <div class="btn-group">
              <a class="btn" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)"><i class="icon-align-left"></i></a>
              <a class="btn" data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"><i class="icon-align-center"></i></a>
              <a class="btn" data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"><i class="icon-align-right"></i></a>
              <a class="btn" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"><i class="icon-align-justify"></i></a>
          </div>
          <div class="btn-group">
              <a class="btn dropdown-toggle" data-toggle="dropdown" title="Hyperlink"><i class="icon-link"></i></a>
              <div class="dropdown-menu input-append">
                  <input class="span2" placeholder="URL" type="text" data-edit="createLink" />
                  <button class="btn" type="button">添加</button>
              </div>
              <a class="btn" data-edit="unlink" title="Remove Hyperlink"><i class="icon-cut"></i></a>
          </div>

          <div class="btn-group">
              <a class="btn" title="Insert picture (or just drag & drop)" id="pictureBtn"><i class="icon-picture"></i></a>
              <input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />
          </div>
          <div class="btn-group">
              <a class="btn" data-edit="undo" title="Undo (Ctrl/Cmd+Z)"><i class="icon-undo"></i></a>
              <a class="btn" data-edit="redo" title="Redo (Ctrl/Cmd+Y)"><i class="icon-repeat"></i></a>
          </div>
          <input type="text" data-edit="inserttext" id="voiceBtn" x-webkit-speech="">
      </div>
      <div id="editor" style="margin:0 50px" >
          ${article.articleContent}
      </div>

      <div class="form-actions fluid">
          <div class="col-sm-5">
              <button type="button" onclick="saveForm()" class="btn btn-success btn-block m-t-25">提交</button>
          </div>
      </div>

      </form>

      <script type="text/javascript" >
          action = "${action}";
          function  cusFunction() {
              //console.info("提交之前，最后执行自定义的函数");
          }

//          $(function () {
//             var name = $('#editor').innerHTML();
//          })

          /**
           * 提交表单
           */
          function saveForm(form_id) {
              cusFunction(); // 回调一个自定义方法，比如修改提交参数。每个form表单都必须定义
              var form;
              if (validate.isEmpty(form_id)) {
                  form = $('#' + form_id);
              } else {
                  form = $('#gzxantForm');
              }

              $.ajax({
                  cache: true,
                  type: "POST",
                  url: url+action,
                  data: form.serialize(),// 你的formid
                  async: false,
                  dataType : "json",
                  error: function (XMLHttpRequest, textStatus, errorThrown) {
                      parent.layer.alert(XMLHttpRequest.responseJSON.error);
                  },
                  beforeSend: function () {
                      start_request_load();
                  }, complete: function () {
                      stop_request_load();
                  },
                  success: function (data) {
                      if (data.code == 200) {
                          parent.re_load();
                          var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                          parent.layer.close(index);
                          parent.layer.msg("操作成功");
                      } else {
                          parent.layer.alert(data.error)
                      }

                  }
              });
          }


          //初始化工具栏
          function initToolbarBootstrapBindings() {
              var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier',
                          'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
                          'Times New Roman', 'Verdana'],
                      fontTarget = $('[title=Font]').siblings('.dropdown-menu');
              $.each(fonts, function (idx, fontName) {
                  fontTarget.append($('<li><a data-edit="fontName ' + fontName +'" style="font-family:\''+ fontName +'\'">'+fontName + '</a></li>'));
              });
              $('a[title]').tooltip({container:'body'});
              $('.dropdown-menu input').click(function() {return false;})
                      .change(function () {$(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');})
                      .keydown('esc', function () {this.value='';$(this).change();});

              $('[data-role=magic-overlay]').each(function () {
                  var overlay = $(this), target = $(overlay.data('target'));
                  overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
              });
              if ("onwebkitspeechchange"  in document.createElement("input")) {
                  var editorOffset = $('#editor').offset();
                  $('#voiceBtn').css('position','absolute').offset({top: editorOffset.top, left: editorOffset.left+$('#editor').innerWidth()-35});
              } else {
                  $('#voiceBtn').hide();
              }
          };
          //错误提示
          function showErrorAlert (reason, detail) {
              var msg='';
              if (reason==='unsupported-file-type') { msg = "Unsupported format " +detail; }
              else {
                  console.log("error uploading file", reason, detail);
              }
              $('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'+
                      '<strong>File upload error</strong> '+msg+' </div>').prependTo('#alerts');
          };
          initToolbarBootstrapBindings();
          $('#editor').wysiwyg({ fileUploadError: showErrorAlert} );

          var readFileIntoDataUrl = function (fileInfo) {
              //原有的方法
//      var loader = $.Deferred(),
//          fReader = new FileReader();
//      fReader.onload = function (e) {
//          loader.resolve(e.target.result);
//      };
//      fReader.onerror = loader.reject;
//      fReader.onprogress = loader.notify;
//      fReader.readAsDataURL(fileInfo);
//      return loader.promise();

              //自定义方法
              var form = new FormData();
              form.append("file", fileInfo);
              var xhr = new XMLHttpRequest();
              xhr.open("post", "/imgupload", false);//后台接收的方法，返回图片路径（全路径，不然页面不显示图片）
              xhr.send(form);
              return xhr.responseText;
          };
      </script>


