function isEmail()
{
	var email=document.getElementById("mymail");
	
	var pattern=/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(!pattern.test(email.value))
	{
		alert('提示\n\n请输入有效的E_mail！');
		pattern.foucus();
		return false;
	}
}


function isTruePassword(s)  
{  
	var patrn=/^[a-zA-Z]{1,30}$/;  
	if (!patrn.exec(s)) return false
	return true
} 

function check1()
{
	var name = document.getElementById("name").value;
	var dep = document.getElementById("department").value;
	var phe = document.getElementById("phone").value;
	var mail = document.getElementById("mymail").value;

	if(name == "")
	{
		alert('请输入您的姓名！');
		return false;
	}
	
	if(dep == "")
	{
		alert('请输入您的部门！');
		return false;
	}

	if(phe == ""||phe.length!=11)
	{
		alert('请输入正确的手机号码！');
		return false;
	}


	if(email.value=="")
	{
		alert("请输入邮箱！");
		return false;
	}
	

}
 
function check2()
{
    var password = document.getElementById("password").value;
    var conform = document.getElementById("conform").value;
	
	if(password != conform)
	{
		alert('两次输入的密码不一致！');
		return false;
	}
}