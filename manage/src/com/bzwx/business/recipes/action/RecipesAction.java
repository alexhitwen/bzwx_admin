package com.bzwx.business.recipes.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.bzwx.base.Struts2BaseAction;
import com.bzwx.business.recipes.pojo.Recipes;
import com.bzwx.business.recipes.service.RecipesService;
import com.opensymphony.xwork2.ActionContext;

/**
 * com.bzwx.business.recipes.web.RecipesAction
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-27
 */
@ParentPackage("json-default")
@Namespace("/recipes")
@Scope("prototype")
@Results({ @Result(type = "json") })
public class RecipesAction extends Struts2BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private RecipesService recipesService;
	
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	// HttpSession session = ServletActionContext.getRequest().getSession();

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private List<Recipes> list = null;
	private List<Recipes> pageList = null;
	private Recipes recipes = null;

	/**
	 * 后台分页查询
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@Action(value = "pageQuery", results = { @Result(name = "recipesList", location = "/admin/recipes/recipesList.jsp") })
	@JSON(serialize = false)
	public String pageQuery() throws UnsupportedEncodingException {
		String beginNum = request.getParameter("beginNum") == null ? "1"
				: request.getParameter("beginNum");
		String endNum = request.getParameter("endNum") == null ? "10" : request
				.getParameter("endNum");
		String searchKey = request.getParameter("searchKey") == null ? ""
				: request.getParameter("searchKey");
		request.setAttribute("searchKey", searchKey);

		searchKey = URLDecoder.decode(URLDecoder.decode(searchKey, "UTF-8"),
				"UTF-8");

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("beginNum", beginNum);
		map.put("endNum", endNum);
		if (!"".equals(searchKey)) {
			map.put("searchKey", searchKey);
		}

		pageList = recipesService.pageQuery(map);
		return "recipesList";
	}

	/**
	 * 所有菜品信息 接口
	 * 
	 * @return
	 */
	@JSON(serialize = false)
	public String getAllList() {
		list = recipesService.getAllList();
		for (int i = 0; i < list.size(); i++) {
			Recipes recipes_1 = (Recipes) list.get(i);
			System.out.println("name" + recipes_1.getRecName() + "code"
					+ recipes_1.getRecCode() + "id" + recipes_1.getRecId());
		}
		return SUCCESS;
	}

	/**
	 * 条件查询 菜品信息 （更新 recStatus=0）
	 * @return
	 * @throws Exception
	 */
	@JSON(serialize = false)
	public String getListByMap() throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// map.put(key, value)
		// map.put(key, value)
		list = recipesService.getListByMap(map);
		for (int i = 0; i < list.size(); i++) {
			Recipes recipes = (Recipes) list.get(i);
			System.out.println(recipes.getRecCode());
		}
		return SUCCESS;
	}

	/**
	 * 条件查询 菜品 对象信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@JSON(serialize = false)
	public String getInfoByMap() throws Exception {
		String recId = request.getParameter("recId");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("recId", recId);
		recipes = (Recipes) recipesService.getInfoByMap(map);
		return SUCCESS;
	}

	/**
	 * 后台根据主键查询 菜品 对象信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@JSON(serialize = false)
	public String getInfoById() throws Exception {
		String recId = request.getParameter("recId");
		recipes = (Recipes) recipesService.getInfoById(Long.valueOf(recId));
		System.out.println(recipes);
		return SUCCESS;
	}

	/**
	 * 后台菜品删除
	 * 
	 * @throws Exception
	 */
	@JSON(serialize = false)
	public void delete() throws Exception {

	}

	public List<Recipes> getList() {
		return list;
	}

	public List<Recipes> getPageList() {
		return pageList;
	}

	public Recipes getRecipes() {
		return recipes;
	}
	
	// private File image;
	// private String imageFileName;
	//
	// public String getImageFileName() {
	// return imageFileName;
	// }
	//
	// public void setImageFileName(String imageFileName) {
	// this.imageFileName = imageFileName;
	// }
	//
	// public File getImage() {
	// return image;
	// }
	//
	// public void setImage(File image) {
	// this.image = image;
	// }
	//
	// public String addUI(){
	// return "success";
	// }
	//
	// public String upload() throws Exception{
	//
	// String realpath =
	// ServletActionContext.getServletContext().getRealPath("/images");
	// System.out.println(realpath);
	// if(image!=null){
	// File savefile = new File(new File(realpath), imageFileName);
	// if(!savefile.getParentFile().exists()) savefile.getParentFile().mkdirs();
	// FileUtils.copyFile(image, savefile);
	// ActionContext.getContext().put("message", "上传成功");
	// }
	// return "success";
	// }

	// @Action(value = "insertOrUpdate2", results = { @Result(name =
	// "recipesManage", location = "/admin/recipes/recipesManage.jsp") })
	// @JSON(serialize = false)
	// public String insertOrUpdate2() {
	// String IMAGE_PATH = "file/images/";
	// response.setContentType("text/html");
	// PrintWriter out = null;
	// try {
	// out = response.getWriter();
	// } catch (IOException e1) {
	// e1.printStackTrace();
	// }
	// final String host = request.getRemoteHost();
	// final int port = request.getLocalPort();
	// DiskFileItemFactory factory = new DiskFileItemFactory();
	//
	// ServletFileUpload file = new ServletFileUpload(factory);
	// Recipes recipes = new Recipes();
	// try {
	// List list = file.parseRequest(request);
	// Iterator<ServletFileUpload> it = list.iterator();
	// while (it.hasNext()) {
	//
	// FileItem fileItem = (FileItem) it.next();
	// if (fileItem.isFormField()) {
	// if ("recId".equals(fileItem.getFieldName())) {
	// if (null != fileItem.getFieldName()
	// && !"".equals(fileItem.getFieldName())
	// && !"".equals(fileItem.getString("UTF-8"))) {
	// recipes.setRecCateId(Long.valueOf(fileItem
	// .getString("UTF-8")));
	// }
	// } else if ("recCateName".equals(fileItem.getFieldName())) {
	// recipes.setRecCateName(fileItem.getString("UTF-8"));
	// } else if ("recName".equals(fileItem.getFieldName())) {
	// recipes.setRecName(fileItem.getString("UTF-8"));
	// } else if ("recCode".equals(fileItem.getFieldName())) {
	// recipes.setRecCode(fileItem.getString("UTF-8"));
	// } else if ("recPrice".equals(fileItem.getFieldName())) {
	// recipes.setRecPrice(Double.valueOf(fileItem
	// .getString("UTF-8")));
	// } else if ("recDiscountPrice".equals(fileItem
	// .getFieldName())) {
	// recipes.setRecDiscountPrice(Double.valueOf(fileItem
	// .getString("UTF-8")));
	// } else if ("allCateName".equals(fileItem.getFieldName())) {
	// recipes.setAllCateName(fileItem.getString("UTF-8"));
	// } else if ("recNote".equals(fileItem.getFieldName())) {
	// recipes.setRecNote(fileItem.getString("UTF-8"));
	// } else if ("recDesc".equals(fileItem.getFieldName())) {
	// recipes.setRecDesc(fileItem.getString("UTF-8"));
	// } else if ("verStatus".equals(fileItem.getFieldName())) {
	// recipes.setRecStatus(Integer.valueOf(fileItem
	// .getString("UTF-8")));
	// } else if ("recVersion".equals(fileItem.getFieldName())) {
	// recipes.setRecVersion(Integer.valueOf(fileItem
	// .getString("UTF-8")));
	// } else if ("createDate".equals(fileItem.getFieldName())) {
	// recipes.setCreataDate(sdf.parse(fileItem
	// .getString("UTF-8")));
	// } else if ("updateDate".equals(fileItem.getFieldName())) {
	// recipes.setUpdateDate(sdf.parse(fileItem
	// .getString("UTF-8")));
	// }
	// } else {
	// if (fileItem.getName() != null
	// && !fileItem.getName().equals("")) {
	//
	// String filename = fileItem.getName();
	// String ext = filename.substring(filename
	// .lastIndexOf(".") + 1);
	//
	// if (!"jpgpngbmp".contains(ext)) {
	// out.println("图片格式必须为：jpg、png、bmp");
	// return "recipesManage";
	// }
	// if (fileItem.getSize() > 5120 * 5120) {
	// out.println("图片太大");
	// return "recipesManage";
	// }
	//
	// String newname = System.currentTimeMillis() + "." + ext;
	//
	// String str = this.getClass().getResource("/").getPath();
	// str = str.replace("WEB-INF/classes/", "").substring(1);
	//
	// String imagesPath = str + IMAGE_PATH;
	//
	// File dir = new File(imagesPath);
	// if (!dir.exists() && !dir.isDirectory())
	// dir.mkdirs();
	//
	// File realFile = new File(imagesPath, newname);
	// fileItem.write(realFile);
	//
	// // File old = new File(str, recipes.getRecPicUrl());
	// // if (old.exists())
	// // old.delete();
	// recipes.setRecPicUrl(IMAGE_PATH + newname);
	// }
	// }
	// }
	// recipesService.insert(recipes);
	// } catch (FileUploadException e) {
	// out.println("添加失败");
	// e.printStackTrace();
	// } catch (Exception e) {
	// out.println("添加失败");
	// e.printStackTrace();
	// }
	// System.out.println(host + ">>>>>>>>>>>");
	// return "recipesManage";
	//
	// }

	// /**
	// * 后台菜品维护
	// *
	// * @throws Exception
	// */
	// @Action(value = "insertOrUpdate", results = { @Result(name =
	// "recipesList", location = "/admin/recipes/recipesList.jsp") })
	// @JSON(serialize = false)
	// public String insertOrUpdate() throws Exception {
	//
	// String recId = request.getParameter("recId");
	// String recName = request.getParameter("recName");
	// String recCode = request.getParameter("recCode");
	// String recNote = request.getParameter("recNote");
	// String recDesc = request.getParameter("recDesc");
	// String recPrice = request.getParameter("recPrice");
	//
	// DiskFileItemFactory factory1 = new DiskFileItemFactory();
	//
	// ServletFileUpload file1 = new ServletFileUpload(factory1);
	// List list2 = file1.parseRequest(request);
	// Iterator<ServletFileUpload> it = list2.iterator();
	//
	// Map<String, String> meetProp = new HashMap<String, String>(); //
	// 存放品图片各个属性值
	// List<String> filePaths = new ArrayList<String>(); // 存放路径信息
	// File dirFile = null; // 当前菜品图片的存放路径
	//
	// String cateCode = request.getParameter("cateCode") == null ? "noCateCode"
	// : request.getParameter("cateCode");
	// String rootPath = request.getSession().getServletContext()
	// .getRealPath("/");
	//
	// String filePath = "http://" + request.getLocalAddr() + ":"
	// + request.getLocalPort() + request.getContextPath()
	// + "/recipes/" + cateCode;
	//
	// boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	// if (isMultipart) {
	// FileItemFactory factory = new DiskFileItemFactory();
	// ServletFileUpload upload = new ServletFileUpload(factory);
	// upload.setHeaderEncoding("UTF-8");
	// try {
	// List<FileItem> items = upload.parseRequest(request);
	//
	// for (FileItem item : items) {
	// if (item.isFormField()) {// 如果是文本类型参数
	// // 得到meetid,并创建与之对应的文件夹来存放文件 root\meetfiles\meetid\
	// System.out.println(item.getFieldName() + "="
	// + item.getString("UTF-8"));
	//
	// meetProp.put(item.getFieldName(),
	// item.getString("utf-8"));
	//
	// if ("meetid".equals(item.getFieldName())) {
	// dirFile = new File(rootPath + File.separator
	// + "meet_files" + File.separator
	// + item.getString());
	// if (!dirFile.exists()) {
	// dirFile.mkdirs();
	// }
	// System.out.println(dirFile.getAbsolutePath());
	// filePath = filePath + item.getString() + "/";
	// }
	// } else {// 文件类型参数
	// if (!item.getName().equals("")) {
	// File file = new File(dirFile, item.getName());
	// try {
	// item.write(file);
	// System.out.println(file.getAbsolutePath());
	//
	// filePaths.add(item.getName());
	// System.out.println(filePath + item.getName());
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// }
	// }
	// try {
	// recipes = new Recipes();
	// BeanUtils.copyProperties(recipes, items.get(0));
	// } catch (Exception e) {
	// System.out.println("items数据拷贝异常......");
	// e.printStackTrace();
	// }
	// } catch (FileUploadException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// if (recipes.getRecId() == 0) {
	// recipesService.insert(recipes);
	// } else {
	// recipesService.update(recipes);
	// }
	// return "recipesList";
	// }

}
