

function getSession() {
	var data;
	$.ajax({
        url: "/cust/getSession",
        async: false,
        type: "POST",
        success: function(retData) {
        	data =  retData;
        },
        error: function (xhr, rtmsg, e) { 
        }
    });
	return data;
}

/**
 * 登陆状态下的页面跳转
 * 	如果已登录则跳转至目标页面，未登陆跳转至登陆页面
 * @param url
 */
function goPageOnlogin(url) {
//	var loginInfo = getSession();
//	if (loginInfo.rtsts && loginInfo.rtsts.code == "000000") {
//		window.location.href = url;
//	} else {
//		window.location.href = '/view/cust/cust_login.html';
//	}
	//window.location.href = '/view/cust/cust_login.html';
	window.location.href = url;
}