package com.tiye.IntelligentClass.service;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.common.Const;
import com.tiye.IntelligentClass.dao.ClassPhotoMapper;
import com.tiye.IntelligentClass.dao.ClassPhotoPicMapper;
import com.tiye.IntelligentClass.model.ClassPhoto;
import com.tiye.IntelligentClass.model.ClassPhotoPic;
import com.tiye.IntelligentClass.model.SysAccount;
import com.tiye.IntelligentClass.util.DateUtil;
import com.tiye.IntelligentClass.util.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Project:IntelligentClass
 * @PackageName:com.tiye.IntelligentClass.service
 * @Auther: 张颖
 * @Date: 2018年05月21日 15:52
 * @Description:
 */
@Service
public class ClassPhotoService {
    @Autowired
    private ClassPhotoMapper photoDao;
    @Autowired
    private ClassPhotoPicMapper picDao;

    public APIResult saveOrUpPhoto(String filePath, String filePrefix, MultipartFile[] pics,
                              ClassPhoto photo, HttpSession session)throws Exception{
        SysAccount account=(SysAccount)session.getAttribute(Const.SESSION_USER);
        photo.setXx(account.getXx());
        photo.setNj(account.getNj());
        photo.setBj(account.getBj());
        if(photo.getId()!=null){
            return updatePhoto(photo);
        }
        return savePhoto(filePath,filePrefix,pics,photo);

    }
    public APIResult updatePhoto(ClassPhoto photo){
        int count=photoDao.updateByPrimaryKeySelective(photo);
        if(count>0){
            return APIResult.result(0,"修改成功",0,null);
        }
        return APIResult.result(2,"修改失败",0,null);
    }

    public APIResult savePhoto(String filePath, String filePrefix, MultipartFile[] pics,
                               ClassPhoto photo) throws Exception{

        photo.setCreateTime(DateUtil.getTime());
        int count=photoDao.insert(photo);
        if(count>0){//插入成功，上传图片
            List<String> fileNames=batchInsert(filePath,filePrefix,pics);//上传图片
            List<ClassPhotoPic> picsL=addPhotoPic(photo.getId(),fileNames);//相册中的图片
            if(picsL!=null&&picsL.size()>0){
                picDao.batchInsertPic(picsL);//批量插入图片
            }
            return APIResult.result(0,"保存成功",0,null);
        }
        return APIResult.result(2,"保存失败",0,null);

    }
    public List<String> batchInsert(String filePath,String filePrefix,MultipartFile[] pics) throws Exception{
        List<String> fileNames=new ArrayList<String>();
        if(pics!=null&&pics.length>0){
            for(int i=0;i<pics.length;i++){
                MultipartFile file=pics[i];
                if(file!=null&&!file.isEmpty()){
                    String fileName = file.getOriginalFilename();// 获取文件名
                    String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 获取文件的后缀名
                    String newFileName= UUID.randomUUID().toString()+suffixName;
                    File dest = new File(filePath + newFileName);
                    if (!dest.getParentFile().exists()) { //检测是否存在目录
                        dest.getParentFile().mkdirs();
                    }
                    file.transferTo(dest);
                    fileNames.add(filePrefix+"/"+newFileName);
                }
            }
        }
        return fileNames;
    }
    public List<ClassPhotoPic> addPhotoPic(Long photoId,List<String> fileNames){
        List<ClassPhotoPic> pics=new ArrayList<ClassPhotoPic>();
        if(fileNames!=null&&fileNames.size()>0){
            for(int i=0;i<fileNames.size();i++){
                ClassPhotoPic pic=new ClassPhotoPic();
                pic.setCreateTime(DateUtil.getTime());
                pic.setPhotoId(photoId);
                pic.setPicPath(fileNames.get(i));
                pics.add(pic);
            }
        }
        return pics;
    }


    @Transactional
    public APIResult delphoto(String filePath,Long id){
        if(id==null){
            return APIResult.result(2,"参数为空",0,null);
        }
        int count=photoDao.deleteByPrimaryKey(id);//删除相册记录
        if(count>0){
            List<ClassPhotoPic> pics=picDao.getPicsByPhotoId(id);//获取图片
            int count1 = picDao.deleteByPhotoId(id);//删除相册中的图片记录
            if(count1>0){
                for(ClassPhotoPic pic:pics){
                    String picPath=pic.getPicPath();
                    String[] picPathA=picPath.split("/");
                    File dest = new File(filePath + picPathA[1]);
                    if(dest.exists()){
                        dest.delete();//删除图片
                    }
                }
            }
            return APIResult.result(0,"删除成功",0,null);
        }
        return APIResult.result(2,"删除失败",0,null);
    }
    @Transactional
    public APIResult delPhotoMore(String filePath,String ids){
        if(StringTools.isEmpty(ids)){
            return APIResult.result(2,"参数为空",0,null);
        }
        Long[] idArr = StringTools.strArr2LongArr(ids);
        for(int i=0;i<idArr.length;i++){
            delphoto(filePath,idArr[i]);
        }
        return APIResult.result(0,"删除成功",0,null);
    }

    public APIResult getPhotoDetail(Long id){
        if(id==null){
            return APIResult.result(2,"参数为空",0,null);
        }
        ClassPhoto photo=photoDao.selectByPrimaryKey(id);
        List<ClassPhotoPic> pics=picDao.getPicsByPhotoId(id);
        photo.setPics(pics);
        return APIResult.result(0,"获取相册详情",0,photo);
    }


}
