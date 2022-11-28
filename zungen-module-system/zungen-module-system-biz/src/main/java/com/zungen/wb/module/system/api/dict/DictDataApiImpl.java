package com.zungen.wb.module.system.api.dict;

import com.zungen.wb.module.system.api.dict.dto.DictDataRespDTO;
import com.zungen.wb.module.system.convert.dict.DictDataConvert;
import com.zungen.wb.module.system.dal.dataobject.dict.DictDataDO;
import com.zungen.wb.module.system.service.dict.DictDataService;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * 字典数据 API 实现类
 *
 * @author admin
 */
@Service
public class DictDataApiImpl implements DictDataApi {

    @Resource
    private DictDataService dictDataService;

    @Override
    public void validDictDatas(String dictType, Collection<String> values) {
        dictDataService.validDictDatas(dictType, values);
    }

    @Override
    public DictDataRespDTO getDictData(String dictType, String value) {
        DictDataDO dictData = dictDataService.getDictData(dictType, value);
        return DictDataConvert.INSTANCE.convert02(dictData);
    }

    @Override
    public DictDataRespDTO parseDictData(String dictType, String label) {
        DictDataDO dictData = dictDataService.parseDictData(dictType, label);
        return DictDataConvert.INSTANCE.convert02(dictData);
    }

}
