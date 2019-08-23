package cn.edu.hit.ices.yang.service;


import cn.edu.hit.ices.yang.model.Resource;

import java.util.List;

public interface ResourceService {
    List<Resource> getAllPassResources();

    List<Resource> getPassResourcesByUser(int userid);

    List<Resource> getToPassResourcesByUser(int userid);

    List<Resource> getNotPassResourcesByUser(int userid);

    List<Resource> getResourcesById(int resourceid);

    List<Resource> getResourceByAuth(String auth);
}
