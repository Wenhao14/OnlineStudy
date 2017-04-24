<%@ page language="java"  import="java.util.*,com.ols.Bean.*"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
 <head>
  <script type="text/javascript" src="js/video.js"></script>
   <script>
   //保存播放进度
   function save(se,id){
		  var myVideo = document.getElementsByTagName('video')[0];
		  var now=myVideo.currentTime;
		  var tol = myVideo.duration;
		  window.location.href="usernewsServlet?now="+now+"&sum="+tol+"&se="+se+"&id="+id+"&select=10";
		}
   //每隔5分钟暂停一次
   var int=self.setInterval("clock()",300000);
   function clock()
  {
 	  var myVideo = document.getElementsByTagName('video')[0];
       if (myVideo.paused){
   
       } else{
    	    myVideo.pause();
       }
  }
   //检测是否播放完毕
 var Tid=self.setInterval("end()",500);
   function end(){
	   var myVideo = document.getElementsByTagName('video')[0];
	   var now=myVideo.currentTime;
	   var tol = myVideo.duration;
	   if(now==tol&&now>1000*60*3){
		  self.clearInterval(Tid);  
		  alert('视频播放完毕 请返回继续学习 ');
	   }
   }
   
//播放  暂停
  function playPause() {
	  var myVideo = document.getElementsByTagName('video')[0];
       if (myVideo.paused){
    	   myVideo.play();
       } else{
    	   myVideo.pause();
       }
          
  }
  // 设置播放点
  function setSeconds(s){
	  var myVideo = document.getElementsByTagName('video')[0];
	  myVideo.currentTime =s;
	  
  }
// 后退
function playBySeconds(num){ 
    var myVideo = document.getElementsByTagName('video')[0];
    myVideo.currentTime =myVideo.currentTime + num;
}
//设置音量
function setVol(num){ 
  var myVideo = document.getElementsByTagName('video')[0];
   myVideo.volume =myVideo.volume + num;
}
//全屏
function fullScreen(){
	var docElm = document.documentElement;
	//W3C
	if(docElm.requestFullscreen){

	docElm.requestFullscreen();

	}
	//FireFox
	else if (docElm.mozRequestFullScreen) {

	docElm.mozRequestFullScreen();

	}
	//Chrome等
	else if (docElm.webkitRequestFullScreen) {

	docElm.webkitRequestFullScreen();

	}
	//IE11
	else if (elem.msRequestFullscreen) {

	elem.msRequestFullscreen();

	}
}
</script> 
 </head>
 <body onload="setSeconds(<%=Double.parseDouble(request.getParameter("s")) %>)">
 
 <%
     String se=(String)request.getAttribute("se"); 
	 if(se!=null){
		 
		 if(se.equals("1")){
			 dataBean data=(dataBean)request.getAttribute("data");
	    	 %>
	    	    <p ><input type=button value=返回上一页  onclick="save(<%=(String)request.getAttribute("se") %>,<%=data.getD_id() %>)"></p>
	    	    <h4>标题:<%=data.getD_key() %></h4>
	    	    <video width="100%" height="100%" id="video"  autoplay>
					<source src="<%=data.getD_address() %> " type="video/ogg" />
					<source src="<%=data.getD_address() %> " type="video/mp4" />        
			   </video> 
	    	 <% 
	     }else{
	    	 nowdataBean nowdata=(nowdataBean)request.getAttribute("nowdata");
	    	%>
	    	    <p ><input type=button value=返回上一页  onclick="save(<%=(String)request.getAttribute("se") %>,<%=nowdata.getD_id() %>)"></p>
	    	      <h4>标题:<%=nowdata.getD_key() %></h4>
		    	 <video width="100%" height="100%" id="video" autoplay>
			 		<source src="<%=nowdata.getD_address() %>" type="video/ogg" />
			 		<source src="<%=nowdata.getD_address() %>" type="video/mp4" />        
			     </video> 
		    <%
	     }
	 }
     
 %>
 <br>
 <table width=90%>
    <tr>
       <td> <input type="button" value="快退" onClick="playBySeconds(-5)"></td>
       <td> <input type="button" value="播放/暂停" onClick="playPause()" ></td>
       <td> 
             <input type="button" value="音量+" onClick="setVol(0.1)">
             <input type="button" value="音量-" onClick="setVol(-0.1)" >
       </td>
       <td> <input type="button" value="全屏" onClick="fullScreen()" ></td>
    </tr>
 </table>
 </body>
</html>