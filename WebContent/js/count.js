
function pCountFn(i,x, number) {
	const pCount = document.getElementById(`js_pCount${i}`);
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

