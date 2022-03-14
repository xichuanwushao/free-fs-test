CREATE TABLE `mooc_backend_user_t` (
    `UUID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
    `user_name` varchar(50) DEFAULT NULL COMMENT '用户账号',
    `user_pwd` varchar(50) DEFAULT NULL COMMENT '用户密码',
    `user_phone` varchar(50) DEFAULT NULL COMMENT '用户手机号',
    PRIMARY KEY (`UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后台用户表';



DROP TABLE IF EXISTS `file_info`;
CREATE TABLE `file_info` (
     `id` int(11) NOT NULL AUTO_INCREMENT,
     `url` varchar(255) DEFAULT NULL COMMENT '资源路径',
     `name` varchar(128) DEFAULT NULL COMMENT '资源原始名称',
     `file_name` varchar(128) DEFAULT NULL COMMENT '资源名称',
     `suffix` varchar(20) DEFAULT NULL COMMENT '后缀名',
     `is_img` tinyint(1) DEFAULT NULL COMMENT '是否图片',
     `size` int(11) DEFAULT NULL COMMENT '尺寸',
     `type` varchar(10) DEFAULT NULL COMMENT '文件展示类型，非后缀名',
     `put_time` datetime DEFAULT NULL COMMENT '上传时间',
     `is_dir` tinyint(1) DEFAULT NULL COMMENT '是否目录',
     `parent_id` int(11) DEFAULT NULL,
     `source` varchar(10) DEFAULT NULL COMMENT '来源',
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='文件资源表';