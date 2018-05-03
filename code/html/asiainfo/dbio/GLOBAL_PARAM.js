var bw = function(){
	return {
		//网页可见区域宽：
		 CLIENT_WIDTH : document.body.clientWidth,
		//网页可见区域高：
		CLIENT_HEIGHT : document.body.clientHeight,
		//网页可见区域宽：(包括边线的宽)
		 OFFSET_WIDTH : document.body.offsetWidth,
		//网页可见区域高：(包括边线的高)
		 OFFSET_HEIGHT : document.body.offsetHeight,
		//网页正文全文宽： 
		 SCROLL_WIDTH : document.body.scrollWidth,
		//网页正文全文高： 
		 SCROLL_HEIGHT : document.body.scrollHeight,
		//网页被卷去的高： 
		 SCROLL_TOP : document.body.scrollTop,
		//网页被卷去的左： 
		 SCROLL_LEFT : document.body.scrollLeft,
		//网页正文部分上： 
		 SCREEN_TOP : window.screenTop,
		//网页正文部分左： 
		 SCREEN_LEFT : window.screenLeft,
		//屏幕分辨率的高： 
		 SCREEN_HEIGHT : window.screen.height,
		//屏幕分辨率的宽： 
		 SCREEN_WIDTH : window.screen.width,
		//屏幕可用工作区高度： 
		 SCREEN_AVAIL_HEIGHT : window.screen.availHeight,
		//屏幕可用工作区宽度： 
		 SCREEN_AVAIL_WIDTH : window.screen.availWidth
	 }
}

var contextPath = window.location['pathname'].split('/')[1];
var _url = '/'+contextPath+'/fileMgr';