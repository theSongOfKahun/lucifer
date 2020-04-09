drop table if exists `uc_user`;
create table `uc_user` (
  `id` bigint(20) not null auto_increment comment '用户主键',
  `username` varchar(16) not null comment '名称',
  `nickname` varchar(16) default '' comment '昵称',
  `password` varchar(100) default '' comment '密码',
  `salt` varchar(8) default '' comment '盐值',
  `email` varchar(36) default '' comment '邮箱',
  `mobile` varchar(11) default '' comment '手机',
  `register_date` timestamp default current_timestamp comment '注册',
  `status` tinyint(2) default 0 comment '状态',
  `type` tinyint(2) not null default 0 comment '类型',
  `union_id` varchar(40) comment '' comment '微信用户唯一标识',
  `logo` varchar(200) default '' comment '头像地址',
  `create_time` timestamp default current_timestamp comment '创建时间',
  `ts` timestamp default current_timestamp on update current_timestamp comment '时间戳',
  primary key (`id`)
) engine=innodb default charset=utf8mb4;