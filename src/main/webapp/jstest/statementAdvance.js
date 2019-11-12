
function statementAdvance(o){
	var i = 0;
	if(typeof o == 'object'){
		var j = 0;
		for(var k =0; k<11 ; k ++){
			if(k == 10) var m = k;
		}
		console.log(k);
	}
	//由于声明提前，此时j已经声明，但是j此时还未赋值，其值是在if内部赋值的，故应输出undefined
	console.log(j);
	console.log(i);
}