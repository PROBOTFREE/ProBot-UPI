<!DOCTYPE html>
<html>
<head>
	<title>{{ $pageTitle }}</title>
	<style>
		.info{
			margin-top: 40px;
		    margin-left: 40px;
		    margin-bottom: 25px;
		}
		p{
			margin: 0;
			margin-bottom: 10px;
		}
		h4{
			margin: 0;
			margin-bottom: 10px;
		}
	</style>
</head>
<body>
	@php echo $email->message @endphp
</body>
</html>
