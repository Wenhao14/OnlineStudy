function GetRadioValue(RadioName)
{
	var obj;  
	obj=document.getElementsByName(RadioName); 
	if(obj!=null)
	{
		var i; 
		for(i=0;i<obj.length;i++)
		{
			if(obj[i].checked)
			{
				return obj[i].value;
			}
		}
	} 
	return null;
}

function check1()
{
	var laterpwd = document.getElementById("laterpwd").value;
	var newpwd = document.getElementById("newpwd1").value;
	var confirm = document.getElementById("newpwd2").value;
	
	if(laterpwd == "")
	{
		alert('请输入原来的密码！');
		return false;
	}

	if(newpwd == "")
	{
		alert('请输入新的密码！');
		return false;
	}

	if(confirm == "")
	{
		alert('请再次输入新的密码！');
		return false;
	}

	if(newpwd != confirm)
	{
		alert('两次输入的密码不一致！');
		return false;
	}
	

}


function check2()
{
	var username = document.getElementById("username").value;

	if(GetRadioValue("type")==null)
	{
		alert('请选择类型！')
		return false;
	}

	if(username == "")
	{
		alert('请输入用户名！');
		return false;
	}

}

function check3()
{
	var laterpwd = document.getElementById("laterpwd").value;
	var newpwd = document.getElementById("newpwd1").value;
	var confirm = document.getElementById("newpwd2").value;
 
	if(laterpwd == "")
	{
		alert('请输入原来的密码！');
		return false;
	}

	if(newpwd == "")
	{
		alert('请输入新的密码！');
		return false;
	}

	if(confirm == "")
	{
		alert('请再次输入新的密码！');
		return false;
	}

	if(newpwd != confirm)
	{
		alert('两次输入的密码不一致！');
		return false;
	}
}

function check4()
{
	var learner = document.getElementById("learner").value;
	if (learner == "")
	{
		alert('请输入学生编号！');
		return false;
	}
}