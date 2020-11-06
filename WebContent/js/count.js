const pCount = document.getElementById('js_pCount');

function pCountFn(x, number) {
	let pCountValue = Number(pCount.value);
//	+버튼 클릭시
	if(pCount.value < number){
		pCountValue += x;
	}
//	-버튼 클릭시
	if(pCount.value > number) {
		pCountValue += x;
	}
	
	pCount.value = pCountValue;
};

