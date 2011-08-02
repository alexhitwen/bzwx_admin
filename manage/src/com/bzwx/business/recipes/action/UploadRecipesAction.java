package com.bzwx.business.recipes.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.bzwx.base.Struts2BaseAction;
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

	// @Autowired
	// private RecipesService recipesService;

	// private Recipes recipes;

	// private String recCateName;
	// private String allCateName;
	//
	// private long recId;
	// private String recName;
	// private String recCode;
	// private double recPrice;
	// private double recDiscountPrice;
	// private String recPicUrl;
	// private String recNote;
	// private String recDesc;
	// private int sortFlag;
	//
	// private int recVersion;
	// private int recStatus;
	// private Date creataDate;
	// private Date updateDate;

	private File image;
	private String imageFileName;
	private String imageContentType;

	private String text1;

	public String getText1() {
		return text1;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	private String caption;
	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public String addUI() {
		return "success";
	}


	public String execute() throws Exception {

		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/images");

		System.out.println("text1》》》" + text1);
		System.out.println("caption>>>" + caption);

		System.out.println(realpath);
		if (image != null) {
			File savefile = new File(new File(realpath), imageFileName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(image, savefile);
			ActionContext.getContext().put("message", "上传成功");
		}
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
