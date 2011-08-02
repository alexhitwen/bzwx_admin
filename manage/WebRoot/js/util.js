/**
 * 去除空格 
 * @param {Object} str
 */
String.prototype.Trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}
