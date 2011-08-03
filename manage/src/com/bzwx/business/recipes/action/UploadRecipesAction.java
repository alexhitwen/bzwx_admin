package com.bzwx.business.recipes.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.bzwx.base.Struts2BaseAction;
import com.bzwx.business.recipes.pojo.Recipes;
import com.bzwx.business.recipes.service.RecipesService;
import com.opensymphony.xwork2.ActionContext;

/**
 * Struts2方式 上传图片 Action com.bzwx.business.recipes.action.UploadRecipesAction
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-8-2
 */
public class UploadRecipesAction extends Struts2BaseAction {

	private static final long serialVersionUID = 1L;

	private Recipes recipes;

	private String firstCateId;
	private String firstCateName;
	private String secCateId; // Long
	private String secCateName; // Long
	private String allCateName;

	private String recId; // Long
	private String recName;
	private String recCode;
	private String recPrice; // double
	private String recDiscountPrice; // double
	private String recPicUrl;
	private String recNote;
	private String recDesc;
	private String sortFlag; // int

	private String recVersion; // int
	private String recStatus; // int
	private String createDate; // Date
	private String updateDate; // Date

	// 图片上传用
	private File image;
	private String imageFileName;
	private String imageContentType;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat longSdf = new SimpleDateFormat("yyyyMMddHHmmss");
	@Autowired
	private RecipesService recipesService;

	HttpServletRequest request = ServletActionContext.getRequest();

	@Action(value = "updateRecipes", results = { @Result(name = "recipesManage", location = "/admin/recipes/recipesManage.jsp") })
	public String getInfo() {
		String recId = request.getParameter("recId");
		if (recId != null) {
			recipes = new Recipes();
			recipes = recipesService.getInfoById(Long.valueOf(recId));
		}
		return "recipesManage";
	}

	public String execute() throws Exception {

		recipes = new Recipes();
		recipes.setRecName(recName);
		recipes.setRecCode(recCode);
		recipes.setRecPrice(Double.valueOf(recPrice));

		if (!"".equals(recDiscountPrice)) {
			recipes.setRecDiscountPrice(Double.valueOf(recDiscountPrice));
		}

		recipes.setRecNote(recNote);
		recipes.setRecDesc(recDesc);

		recipes.setRecVersion(Integer.valueOf(recVersion));
		recipes.setSortFlag(Integer.valueOf(sortFlag));
		recipes.setRecVersion(Integer.valueOf(recVersion));

		if (null != recPicUrl && !"".equals(recPicUrl)) {
			recipes.setRecPicUrl(recPicUrl);
		} else {
			String realpath = ServletActionContext.getServletContext().getRealPath(
					"/upload");
			System.out.println(realpath);
			if (image != null) {
				if (imageFileName != null) {
					String extension = imageFileName.substring(imageFileName
							.indexOf('.'));
					String str = longSdf.format(new Date());
					str += System.currentTimeMillis();
					imageFileName = str + extension;
				}

				File savefile = new File(new File(realpath), imageFileName);
				if (!savefile.getParentFile().exists())
					savefile.getParentFile().mkdirs();
				FileUtils.copyFile(image, savefile);
				ActionContext.getContext().put("message", "上传成功");

				recipes.setRecPicUrl("/upload/" + imageFileName);
			}
		}
		if (!"".equals(allCateName) && null != allCateName)
			recipes.setAllCateName(allCateName);
		if (!"".equals(firstCateId) && null != firstCateId)
			recipes.setFirstCateId(Long.valueOf(firstCateId));
		if (!"".equals(firstCateName) && null != firstCateName)
			recipes.setFirstCateName(firstCateName);
		if (!"".equals(secCateId) && null != secCateId)
			recipes.setSecCateId(Long.valueOf(secCateId));
		if (!"".equals(secCateName) && null != secCateName)
			recipes.setSecCateName(secCateName);

		if ("".equals(recId) || "自动分配".equals(recId)) {
			recipes.setCreateDate(sdf.parse(createDate));
			recipes.setUpdateDate(sdf.parse(updateDate));
			recipesService.insert(recipes);
		} else {
			recipes.setUpdateDate(sdf.parse(updateDate));
			recipes.setRecId(Long.valueOf(recId));
			recipesService.update(recipes);
		}

		return "success";
	}

	public String getSecCateId() {
		return secCateId;
	}

	public void setSecCateId(String secCateId) {
		this.secCateId = secCateId;
	}

	public String getSecCateName() {
		return secCateName;
	}

	public void setSecCateName(String secCateName) {
		this.secCateName = secCateName;
	}

	public String getAllCateName() {
		return allCateName;
	}

	public void setAllCateName(String allCateName) {
		this.allCateName = allCateName;
	}

	public String getRecId() {
		return recId;
	}

	public void setRecId(String recId) {
		this.recId = recId;
	}

	public String getRecName() {
		return recName;
	}

	public void setRecName(String recName) {
		this.recName = recName;
	}

	public String getRecCode() {
		return recCode;
	}

	public void setRecCode(String recCode) {
		this.recCode = recCode;
	}

	public String getRecPrice() {
		return recPrice;
	}

	public void setRecPrice(String recPrice) {
		this.recPrice = recPrice;
	}

	public String getRecDiscountPrice() {
		return recDiscountPrice;
	}

	public void setRecDiscountPrice(String recDiscountPrice) {
		this.recDiscountPrice = recDiscountPrice;
	}

	public String getRecPicUrl() {
		return recPicUrl;
	}

	public void setRecPicUrl(String recPicUrl) {
		this.recPicUrl = recPicUrl;
	}

	public String getRecNote() {
		return recNote;
	}

	public void setRecNote(String recNote) {
		this.recNote = recNote;
	}

	public String getRecDesc() {
		return recDesc;
	}

	public void setRecDesc(String recDesc) {
		this.recDesc = recDesc;
	}

	public String getSortFlag() {
		return sortFlag;
	}

	public void setSortFlag(String sortFlag) {
		this.sortFlag = sortFlag;
	}

	public String getRecVersion() {
		return recVersion;
	}

	public void setRecVersion(String recVersion) {
		this.recVersion = recVersion;
	}

	public String getRecStatus() {
		return recStatus;
	}

	public void setRecStatus(String recStatus) {
		this.recStatus = recStatus;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public RecipesService getRecipesService() {
		return recipesService;
	}

	public void setRecipesService(RecipesService recipesService) {
		this.recipesService = recipesService;
	}

	public Recipes getRecipes() {
		return recipes;
	}

	public void setRecipes(Recipes recipes) {
		this.recipes = recipes;
	}

	public String getFirstCateId() {
		return firstCateId;
	}

	public void setFirstCateId(String firstCateId) {
		this.firstCateId = firstCateId;
	}

	public String getFirstCateName() {
		return firstCateName;
	}

	public void setFirstCateName(String firstCateName) {
		this.firstCateName = firstCateName;
	}

}
