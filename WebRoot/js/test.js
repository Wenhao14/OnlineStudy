	function isTitleEmpty()
	{
		var t=document.getElementById("title");
		if(t.value=="")
		{
			alert("不能为空！请输入内容！");
			document.getElementById("title").foucus();
			return false;
		}
	}


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
	
	if(GetRadioValue("test1")==null)
	{
		alert('请选择试题的答案！')
		return false;
	}
	
}

function isempty(f)
{
	var s=f.value
	if (s=="")
	{
		alert("不能为空！请输入内容！");
		document.getElementById("f").foucus();
		return false;
	}
}
