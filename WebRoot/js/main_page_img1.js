
  setInterval(test,1000);
  var array = new Array();
  var index = 0;
  var array = new Array("img/adv1.jpg","img/adv2.jpg","img/adv3.jpg","img/adv4.jpg");
  function test() {
   var myimg=document.getElementById("imgs");
   if(index==array.length-1)
   { index=0; }else{ index++; }
   myimg.src=array[index];
  }



 