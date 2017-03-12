<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	aaaa


	<form role="form" method="POST" action="addPostToDB">
		<div class="col-lg-6">
			<div class="well well-sm">
				<!-- 				<strong><span class="glyphicon glyphicon-asterisk"></span>Required -->
				<!-- 					Field</strong> -->
			</div>


			<div class="form-group">
				<label for="InputEmail">Enter description</label>
				<div class="input-group">
					<textarea type="text" rows="10" class="form-control"
						id="InputDescription" name="descr"
						placeholder="Enter description       " required> </textarea>
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			<select>
<!-- 				<optgroup label="Swedish Cars"> -->
					<option value="idea">idea</option>
					<option value="thought">thought</option>
<!-- 				</optgroup> -->
<!-- 				<optgroup label="German Cars"> -->
					<option value="story">story</option>
					<option value="proverb">proverb</option>
					<option value="joke">joke</option>
					<option value="news">news</option>
<!-- 				</optgroup> -->
			</select>
			 <input type="submit" name="submit" id="submit" value="Submit"
				class="btn btn-info pull-right">
		</div>
	</form>
</body>
</html>