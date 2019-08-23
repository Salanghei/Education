package cn.edu.hit.ices.yang.service;

import cn.edu.hit.ices.yang.mapper.ResourceMapper;
import cn.edu.hit.ices.yang.model.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService{
    @javax.annotation.Resource
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> getAllPassResources(){
        try {
            return resourceMapper.selectAllPassResources();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Resource> getPassResourcesByUser(int userid){
        try{
            return resourceMapper.selectPassResourcesByUser(userid);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Resource> getToPassResourcesByUser(int userid){
        try{
            return resourceMapper.selectToPassResourceByUser(userid);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Resource> getNotPassResourcesByUser(int userid){
        try{
            return resourceMapper.selectNotPassResourceByUser(userid);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Resource> getResourcesById(int resourceid){
        try{
            return resourceMapper.selectResourceById(resourceid);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Resource> getResourceByAuth(String auth){
        try{
            return resourceMapper.selectResourceByAuth(auth);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
