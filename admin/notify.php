<audio id="audioBox">
	<source src="notify.mp3" type="audio/mpeg"/>
	<source src="notify.wav" type="audio/wav"/>
	<source src="notify.ogg" type="audio/ogg"/>
</audio>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
setInterval(function(){
	load();
},3000);
function load(){
	jQuery.ajax({
		url:'get.php',
		success:function(result){
			var data=jQuery.parseJSON(result);
			if(data.sound=="yes"){
				jQuery('#audioBox')[0].play();
			}
		}
	});
}
</script>
