package com.zungen.wb.module.infra.convert.file;

import com.zungen.wb.framework.common.pojo.PageResult;
import com.zungen.wb.module.infra.controller.admin.file.vo.file.FileRespVO;
import com.zungen.wb.module.infra.dal.dataobject.file.FileDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileConvert {

    FileConvert INSTANCE = Mappers.getMapper(FileConvert.class);

    FileRespVO convert(FileDO bean);

    PageResult<FileRespVO> convertPage(PageResult<FileDO> page);

}
