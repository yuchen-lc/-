$(function(){
	$("#slideBox").slide({
		mainCell: ".bd ul",
		autoPlay: true,
		effect: 'leftLoop'
	});
	$("#supplier").slide({
		interTime:6000,
		titCell: ".hd ul",
		mainCell: ".bd .ulWrap",
		autoPage: true,
		effect: "leftLoop",
		autoPlay: true
	});
	$("#product-list").slide({
		interTime:2500,
		titCell: ".hd ul",
		mainCell: ".bd .ulWrap",
		autoPage: true,
		effect: "leftLoop",
		autoPlay: true
	});
})
