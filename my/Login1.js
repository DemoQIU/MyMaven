//判断用户正确登陆 
function login(e) {
	  //获得input中的username、password字段
    var username = $("#username").val()
      , password = $("#password").val();

//
    var postData = {};
    postData.userId = username;
    postData.password = password;
    //中断键
    e.preventDefault();
    $theButton = $(this);
 
    console.log('userId='+username+'&password='+password);
    
    $.ajax({
    	//发出请求的地址
        url: '/my/my/myLR/auth.json',
        //请求方式
        type: 'POST',
        //返回数据的类型
        dataType: 'json',
        //发送内容编码类型
        contentType:'application/json;charset=UTF-8',
        //不会读取服务器缓存
        cache: false,
        //将postData中的数据转换成数据串格式发送到服务器端
        data: JSON.stringify(postData) ,
        //请求成功时执行
        success: function( data, textStatus, XMLHttpRequest ) {
        	if(data){
        		window.location = "welcome.jsp";
        	}else{
        		alert("用户名或密码不正确，请重新输入。");
        	}
        },
        error: function( XMLHttpRequest, textStatus, errorThrown ) {
        	alert(666);
            console.log("AJAX ERROR: \n" + XMLHttpRequest.responseText);
        }
    });
  }