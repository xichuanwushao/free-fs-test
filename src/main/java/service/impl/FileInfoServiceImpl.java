package service.impl;

import com.free.fs.mapper.FileInfoMapper;
import com.free.fs.model.FilePojo;
import service.IFileInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件资源表 服务实现类
 * </p>
 *
 * @author wuxiao
 * @since 2022-03-14
 */
@Service
public class FileInfoServiceImpl extends ServiceImpl<FileInfoMapper, FilePojo> implements IFileInfoService {

}
