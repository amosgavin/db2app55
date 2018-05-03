var commitType="A";

function commit(type){
	alert("D");
  commitType = type;
  gBceFrame_saveSinglePage();
}

function checkRegionId(value){
	alert("value:"+value);
  if(value != "571"){
    alert("«¯”Ú±ÿ–Î «571");
    return false;
  }
  return true;
}

function testEvent1(p){
  alert("event1:"+p);
  return false;
}

function testEvent2(p){
  alert("event2:"+p);
}

function testEvent3(p){
	  alert("event3:"+p);
	  return new Array(p=="true",p);
	}