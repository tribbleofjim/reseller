package com.web.reseller.dao;

import com.web.reseller.model.L2Role2product;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

=======
import com.web.reseller.model.L2Tour;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

>>>>>>> e32a355391da51cce3e26f53c6a3febbbd306185
@Component
@Mapper
public interface L2role2productMapper {
    void distribute2reseller(L2Role2product role);
}
