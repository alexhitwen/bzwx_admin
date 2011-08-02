/**
 * 去除空格 
 * @param {Object} str
 */
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}
//去除头空格
String.prototype.lTrim = function() {
	return this.replace(/(^\s*)/g, "");
}
//去除尾空格
String.prototype.rTrim = function() {
	return this.replace(/(\s*$)/g, "");
}

String.prototype.endWith = function(str) {
	if (str == null || str == "" || this.length == 0
			|| str.length > this.length) {
		return false;
	}
	if (this.substring(this.length - str.length) == str) {
		return true;
	} else {
		return false;
	}
	return true;
};
String.prototype.startWith = function(str) {
	if (str == null || str == "" || this.length == 0
			|| str.length > this.length) {
		return false;
	}
	if (this.substr(0, str.length) == str) {
		return true;
	} else {
		return false;
	}
	return true;
};