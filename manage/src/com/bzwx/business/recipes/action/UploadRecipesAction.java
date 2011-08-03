package com.bzwx.business.recipes.action;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
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

	@Autowired
	private RecipesService recipesService;

	private Recipes recipes;

	private String firstCateId;
	private String firstCateName;
	private Long secCateId; //
	private Long secCateName; //
	private String allCateName;

	private long recId; //
	private String recName;
	private String recCode;
	private double recPrice; //
	private double recDiscountPrice; //
	private String recPicUrl;
	private String recNote;
	private String recDesc;
	private int sortFlag; //

	private int recVersion; //
	private int recStatus; //
	private Date creataDate; //
	private Date updateDate; //

	// 图片上传用
	private File image;
	private String imageFileName;
	private String imageContentType;

	public String addUI() {
		return "success";
	}

	public String execute() throws Exception {

		recipes = new Recipes();
		recipes.setAllCateName(allCateName);
		recipes.setFirstCateId(firstCateId);
		recipes.setFirstCateName(firstCateName);
		recipes.setSecCateId(secCateId);
		recipes.setSecCateName(secCateName);

		recipes.setRecId(recId);
		recipes.setRecName(recName);
		recipes.setRecCode(recCode);
		recipes.setRecPrice(recPrice);
		recipes.setRecDiscountPrice(recDiscountPrice);

		recipes.setRecNote(recNote);
		recipes.setRecDesc(recDesc);

		recipes.setRecVersion(recVersion);
		recipes.setSortFlag(sortFlag);
		recipes.setRecVersion(recVersion);
		recipes.setRecStatus(recStatus);
		recipes.setCreataDate(creataDate);
		recipes.setUpdateDate(updateDate);

		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/upload");

		System.out.println(realpath);
		if (image != null) {
			File savefile = new File(new File(realpath), imageFileName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(image, savefile);
			ActionContext.getContext().put("message", "上传成功");
		}

		recipes.setRecPicUrl(recPicUrl);
		return "success";
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

	// public Recipes getRecipes() {
	// return recipes;
	// }
	//
	// public void setRecipes(Recipes recipes) {
	// this.recipes = recipes;
	// }
	//
	// public String getRecCateName() {
	// return recCateName;
	// }
	//
	// public void setRecCateName(String recCateName) {
	// this.recCateName = recCateName;
	// }
	//
	// public String getAllCateName() {
	// return allCateName;
	// }
	//
	// public void setAllCateName(String allCateName) {
	// this.allCateName = allCateName;
	// }
	//
	// public long getRecId() {
	// return recId;
	// }
	//
	// public void setRecId(long recId) {
	// this.recId = recId;
	// }
	//
	// public String getRecName() {
	// return recName;
	// }
	//
	// public void setRecName(String recName) {
	// this.recName = recName;
	// }
	//
	// public String getRecCode() {
	// return recCode;
	// }
	//
	// public void setRecCode(String recCode) {
	// this.recCode = recCode;
	// }
	//
	// public double getRecPrice() {
	// return recPrice;
	// }
	//
	// public void setRecPrice(double recPrice) {
	// this.recPrice = recPrice;
	// }
	//
	// public double getRecDiscountPrice() {
	// return recDiscountPrice;
	// }
	//
	// public void setRecDiscountPrice(double recDiscountPrice) {
	// this.recDiscountPrice = recDiscountPrice;
	// }
	//
	// public String getRecPicUrl() {
	// return recPicUrl;
	// }
	//
	// public void setRecPicUrl(String recPicUrl) {
	// this.recPicUrl = recPicUrl;
	// }
	//
	// public String getRecNote() {
	// return recNote;
	// }
	//
	// public void setRecNote(String recNote) {
	// this.recNote = recNote;
	// }
	//
	// public String getRecDesc() {
	// return recDesc;
	// }
	//
	// public void setRecDesc(String recDesc) {
	// this.recDesc = recDesc;
	// }
	//
	// public int getSortFlag() {
	// return sortFlag;
	// }
	//
	// public void setSortFlag(int sortFlag) {
	// this.sortFlag = sortFlag;
	// }
	//
	// public int getRecVersion() {
	// return recVersion;
	// }
	//
	// public void setRecVersion(int recVersion) {
	// this.recVersion = recVersion;
	// }
	//
	// public int getRecStatus() {
	// return recStatus;
	// }
	//
	// public void setRecStatus(int recStatus) {
	// this.recStatus = recStatus;
	// }
	//
	// public Date getCreataDate() {
	// return creataDate;
	// }
	//
	// public void setCreataDate(Date creataDate) {
	// this.creataDate = creataDate;
	// }
	//
	// public Date getUpdateDate() {
	// return updateDate;
	// }
	//
	// public void setUpdateDate(Date updateDate) {
	// this.updateDate = updateDate;
	// }

}
