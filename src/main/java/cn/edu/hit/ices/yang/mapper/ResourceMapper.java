package cn.edu.hit.ices.yang.mapper;

import cn.edu.hit.ices.yang.model.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("resourceMapper")
public interface ResourceMapper {
    List<Resource> selectAllPassResources();  // 获取全部通过的资源

    List<Resource> selectPassResourcesByUser(int userid);  // 获取某用户全部通过的资源

    List<Resource> selectToPassResourceByUser(int userid);  // 获取某用户全部待审核的资源

    List<Resource> selectNotPassResourceByUser(int userid);  // 获取某用户全部未通过的资源

    List<Resource> selectResourceById(int resourceid);  // 获取特定id的资源

    List<Resource> selectResourceByAuth(String auth);
}
