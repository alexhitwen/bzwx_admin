package com.bzwx.common.dictionary.action;

/**
 * 
 * com.bzwx.common.dictionary.web.DictionaryAdminAction
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-30
 */
public class DictionaryAdminAction {
	// private static Logger log =
	// Logger.getLogger(DictionaryAdminAction.class);
	//
	// private DictionaryService dictionaryService;
	//
	// public void setDictionaryService(DictionaryService dictionaryService) {
	// this.dictionaryService = dictionaryService;
	// }
	//
	// /**
	// * 初始化
	// */
	// public ActionForward initialize(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request, HttpServletResponse response) {
	// // 判断是否已经初始化
	// int initialState = dictionaryService.initialState();
	// if (initialState == 0) {
	// request.setAttribute(Constants.ERROR_INFO, "字典表还未进行初始化，请联系管理员！");
	// return mapping.findForward("initialTips"); // 跳转到初始化不正确的提示页面
	// } else if (initialState == -1) {
	// request.setAttribute(Constants.ERROR_INFO,
	// "初始化字典表不正确，最顶级不能有多个字典项，请联系管理员！");
	// return mapping.findForward("initialTips"); // 跳转到初始化不正确的提示页面
	// }
	//
	// return mapping.findForward("index");
	// }
	//
	// /**
	// * 取得菜单树型结构
	// */
	// public void getTree(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// String parentId = request.getParameter("parentId");
	// if (StringUtils.isEmpty(parentId)) {
	// Dictionary dic = dictionaryService.getTopmostDictionary();
	// parentId = String.valueOf(dic.getParentId());
	// }
	//
	// response
	// .setContentType("application/x-www-form-urlencoded; charset=UTF-8");
	// response.setHeader("Cache-Control", "no-cache");
	// PrintWriter out = response.getWriter();
	// out
	// .println(getTreeStr(Long.valueOf(parentId), request
	// .getContextPath()));
	// out.flush();
	// out.close();
	// }
	//
	// /**
	// * 取得菜单树型结构的迭代循环体
	// *
	// * @param parentId
	// * 父节点id
	// * @param contextPath
	// * 应用的上下文路径
	// * @return
	// */
	// private String getTreeStr(Long parentId, String contextPath) {
	// if (parentId == null) {
	// return "";
	// } else {
	// List list = dictionaryService.getChildren(parentId);
	//
	// StringBuffer sb = new StringBuffer();
	// sb.append("[");
	// if (list != null && list.size() > 0) {
	// for (int i = 0; i < list.size(); i++) {
	// Dictionary dic = (Dictionary) list.get(i);
	// List childList = dictionaryService.getChildren(dic
	// .getId());
	// if (childList != null && childList.size() > 0)
	// sb
	// .append("{id:'"
	// + dic.getId()
	// + "',text:'"
	// + dic.getKeyName()
	// + "',href:'"
	// + contextPath
	// + "/admin/dictionary/list.jsp?parentId="
	// + dic.getId()
	// + "',hrefTarget:'rightFrame',children:"
	// + getTreeStr(dic.getId(),
	// contextPath) + "},");
	// else
	// sb.append("{id:'" + dic.getId() + "',text:'"
	// + dic.getKeyName() + "',href:'" + contextPath
	// + "/admin/dictionary/list.jsp?parentId="
	// + dic.getId()
	// + "',hrefTarget:'rightFrame',leaf:true},");
	// }
	// }
	// if (sb.toString().endsWith(","))
	// return sb.substring(0, sb.length() - 1) + "]";
	// else
	// return sb.append("]").toString();
	// }
	// }
	//
	// /**
	// * 获得后台Grid分页展示的数据
	// */
	// public void getList(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// String parentId = request.getParameter("parentId");
	// if (StringUtils.isEmpty(parentId)) {
	// Dictionary dic = dictionaryService.getTopmostDictionary();
	// parentId = String.valueOf(dic.getParentId());
	// }
	//
	// // start,sort,dir,limit
	// String start = StringUtils.isEmpty(request.getParameter("start")) ? "0"
	// : request.getParameter("start");
	// String sort = StringUtils.isEmpty(request.getParameter("sort")) ?
	// "orderNumber"
	// : request.getParameter("sort");
	// String dir = StringUtils.isEmpty(request.getParameter("dir")) ? "asc"
	// : request.getParameter("dir");
	// String limit = StringUtils.isEmpty(request.getParameter("limit")) ? "20"
	// : request.getParameter("limit");
	//
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("begin", Integer.parseInt(start));
	// map.put("end", Integer.parseInt(start) + Integer.parseInt(limit));
	// map.put("sortName", sort);
	// map.put("dir", dir);
	//
	// List list = dictionaryService
	// .getChildren(Long.parseLong(parentId), map);
	// List countList = dictionaryService
	// .getChildren(Long.parseLong(parentId));
	//
	// String str = JsonFormat.PagingGridList2Json(list, countList == null ? 0
	// : countList.size());
	//
	// response
	// .setContentType("application/x-www-form-urlencoded; charset=UTF-8");
	// response.setHeader("Cache-Control", "no-cache");
	// PrintWriter out = response.getWriter();
	// out.println(str);
	// out.flush();
	// out.close();
	// }
	//
	// /**
	// * 新增或者修改字典信息
	// */
	// public void saveOrUpdate(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// String dictionaryId = request.getParameter("id");
	// String parentId = request.getParameter("parentId");
	//
	// String keyName = request.getParameter("keyName");
	// // keyName=filterfaces.validatestring(keyName);
	// // if(ValidatorUtils.isBlankOrNull(keyName)){
	// // return;
	// // }
	// // if(ValidatorUtils.maxLength(keyName, 50)==false){
	// // return;
	// // }
	// //
	// String keyCode = request.getParameter("keyCode");
	// // keyCode=filterfaces.validatestring(keyCode);
	// // if(ValidatorUtils.isBlankOrNull(keyCode)){
	// // return;
	// // }
	// // if(ValidatorUtils.maxLength(keyCode, 50)==false){
	// // return;
	// // }
	// //
	// String keyValue = request.getParameter("keyValue");
	// // keyCode=filterfaces.validatestring(keyValue);
	// // if(ValidatorUtils.isBlankOrNull(keyValue)){
	// // return;
	// // }
	// // if(ValidatorUtils.maxLength(keyValue, 50)==false){
	// // return;
	// // }
	// //
	// String description = request.getParameter("description");
	// // keyShortDesc=filterfaces.validatestring(description);
	// // if(ValidatorUtils.maxLength(description, 50)==false){
	// // return;
	// // }
	//
	// String orderNumber = request.getParameter("orderNumber");
	// if (StringUtils.isEmpty(orderNumber))
	// orderNumber = "1";
	//
	// if (StringUtils.isEmpty(parentId)) {
	// Dictionary dic = dictionaryService.getTopmostDictionary();
	// parentId = String.valueOf(dic.getParentId());
	// }
	//
	// if (!StringUtils.isEmpty(parentId) && !StringUtils.isEmpty(keyName)
	// && !StringUtils.isEmpty(keyCode)) {
	// Dictionary dic2 = dictionaryService.getDictionary(keyCode);
	// if (dic2 == null
	// || (dic2 != null && !StringUtils.isEmpty(dictionaryId) && dic2
	// .getId() == Long.parseLong(dictionaryId))) {
	// if (StringUtils.isEmpty(dictionaryId)) { // add新增
	// // 检测顺序并调整位置
	// String maxNum = request.getParameter("maxNum");
	// if (!StringUtils.isEmpty(maxNum)
	// && StringUtils.isNumeric(maxNum)) {
	// if (!maxNum.equals(orderNumber)) {
	// dictionaryService.updateOrder(Long
	// .parseLong(parentId), Integer
	// .parseInt(orderNumber));
	// }
	// }
	//
	// // 添加
	// Dictionary dic = new Dictionary();
	// long nextId = ObjectIdFactory.getObjectId(Dictionary.class
	// .getName());
	// dic.setId(nextId);
	// dic.setKeyName(keyName);
	// dic.setKeyCode(keyCode);
	// dic.setKeyValue(keyValue);
	// dic.setParentId(Long.parseLong(parentId));
	// dic.setDescription(description);
	// dic.setOrderNumber(Integer.valueOf(orderNumber));
	//
	// dictionaryService.insertDictionary(dic);
	//
	// } else { // update修改
	// Dictionary dic = dictionaryService.getDictionary(Long
	// .parseLong(dictionaryId));
	// // 检测顺序并调整位置
	// if (Integer.parseInt(orderNumber) != dic.getOrderNumber()) {
	// dictionaryService.updateOrder(Long.parseLong(parentId),
	// dic.getOrderNumber(), Integer
	// .parseInt(orderNumber));
	// }
	//
	// // 添加
	// dic.setKeyName(keyName);
	// dic.setKeyCode(keyCode);
	// dic.setKeyValue(keyValue);
	// dic.setDescription(description);
	// dic.setOrderNumber(Integer.parseInt(orderNumber));
	//
	// dictionaryService.updateDictionary(dic);
	// }
	// }
	// }
	// }
	//
	// /**
	// * 检测字典编码是否唯一。
	// */
	// public void isUniqueKeyCode(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// String keyCode = request.getParameter("keyCode");
	// String id=request.getParameter("id");
	//
	// Dictionary dic = null;
	// if(StringUtils.isNotEmpty(keyCode)) {
	// dic = dictionaryService.getDictionary(keyCode);
	// }
	//
	// response.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
	// response.setHeader("Cache-Control", "no-cache");
	// PrintWriter out = response.getWriter();
	//
	// if (dic==null ||(dic!=null && StringUtils.isNotEmpty(id) &&
	// dic.getId()==Long.parseLong(id)))
	// out.println("true");
	// else
	// out.println("false");
	//
	// out.flush();
	// out.close();
	// }
	//
	// /**
	// * 删除后台所选择的字典项
	// */
	// public void deleteByIds(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// String ids = request.getParameter("ids");
	// if (!StringUtils.isEmpty(ids)) {
	// dictionaryService.deleteDictionarysAndChildren(ids);
	// }
	// }
	//
	// /**
	// * 通过字典编码获得所有子字典项
	// */
	// public void getItems(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request, HttpServletResponse response)
	// throws Exception {
	// String keyCode = request.getParameter("keyCode");
	// if (keyCode == null)
	// return;
	//
	// //读取配置文件，获得字典表中对应的keyCode值
	// String dictionaryCode = Configuration.getProperty(keyCode);
	// if(dictionaryCode==null){
	// //log.warn("Dictionary property[keyCode] is incorrect");
	// //return;
	// dictionaryCode = keyCode;
	// }
	//
	// List<Dictionary> list = dictionaryService.getChildren(dictionaryCode);
	//
	// String str = JsonFormat.List2Json(list);
	//
	// response.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
	// response.setHeader("Cache-Control", "no-cache");
	// PrintWriter out = response.getWriter();
	// out.println(str);
	// out.flush();
	// out.close();
	// }
	//
	// /**
	// * 通过硬编码的code获取数据库中对应的真实编码
	// */
	// public void getRealCode(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// String keyCode = request.getParameter("keyCode");
	// if (keyCode == null)
	// return;
	//
	// //读取配置文件，获得字典表中对应的keyCode值
	// String dictionaryCode = Configuration.getProperty(keyCode);
	// if (dictionaryCode == null) {
	// log.warn("Dictionary property[keyCode] is incorrect");
	// return;
	// }
	// response.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
	// response.setHeader("Cache-Control", "no-cache");
	// PrintWriter out = response.getWriter();
	// out.println(dictionaryCode);
	// out.flush();
	// out.close();
	// }
	//
	// /**
	// * 根据字典编码获取字典名称
	// */
	// public void getKeyNameByKeyCode(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// String keyCode = request.getParameter("keyCode");
	// if (keyCode == null){
	// return ;
	// }
	// Dictionary dict = dictionaryService.getDictionary(keyCode);
	// String keyname = null;
	// if(dict == null){
	// keyname = "";
	// } else {
	// keyname = dict.getKeyName();
	// if(StringUtils.isEmpty(keyname)) {
	// keyname = "";
	// }
	// }
	// response.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
	// response.setHeader("Cache-Control", "no-cache");
	// PrintWriter out = response.getWriter();
	// out.println(keyname);
	// out.flush();
	// out.close();
	// }
	//
	// /**
	// * 根据字典编码获取字典名称
	// */
	// public void getKeyValueByKeyCode(ActionMapping mapping, ActionForm form,
	// HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// String keyCode = request.getParameter("keyCode");
	// if (keyCode == null){
	// return ;
	// }
	// Dictionary dict = dictionaryService.getDictionary(keyCode);
	// String keyValue = null;
	// if(dict == null){
	// keyValue = "";
	// } else {
	// keyValue = dict.getKeyValue();
	// if(StringUtils.isEmpty(keyValue)) {
	// keyValue = "";
	// }
	// }
	// response.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
	// response.setHeader("Cache-Control", "no-cache");
	// PrintWriter out = response.getWriter();
	// out.println(keyValue);
	// out.flush();
	// out.close();
	// }
}