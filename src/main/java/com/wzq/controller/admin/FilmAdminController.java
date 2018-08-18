package com.wzq.controller.admin;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wzq.entity.Film;
import com.wzq.service.FilmService;
import com.wzq.util.DateUtil;



@RestController
@RequestMapping("/admin/film")
public class FilmAdminController {

	@Value("${imageFilePath}")
	private String imageFilePath;
	@Resource
	private  FilmService  filmService  ;

	@RequestMapping("/ckeditorUpload")
	public String ckeditorUpload(@RequestParam("upload") MultipartFile file, String CKEditorFuncNum) throws Exception {
		String fileName = file.getOriginalFilename(); // 获取文件名
		String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 获取文件的后缀																			// eg:.jpg
		String newFileName = DateUtil.getCurrentDateStr() + suffixName;
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imageFilePath + newFileName));//文件上传到本地指定文件夹(即filmimage)

		StringBuffer sb = new StringBuffer();
		sb.append("<script type=\"text/javascript\">");
		sb.append("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" + "/static/filmImage/"
				+ newFileName + "','')");
		sb.append("</script>");

		return sb.toString();

	}
	/**
	 * 添加或修改电影信息
	 * @param film
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public Map<String, Object> save(Film film, @RequestParam("imageFile") MultipartFile file) throws Exception {
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename(); // 获取文件名
			String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 获取文件的后缀																			// eg:.jpg
			String newFileName = DateUtil.getCurrentDateStr() + suffixName;
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(imageFilePath + newFileName));
			film.setImageName(newFileName);
		}
		film.setPublishDate(new Date());
		Map<String, Object> resultMap=new HashMap<String, Object>() ;
		filmService.save(film);
		resultMap.put("success", true);
		return resultMap;

	}
}
