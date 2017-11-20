-- ----------------------------
-- Table structure for province
-- 省
-- ----------------------------
DROP TABLE IF EXISTS province;
CREATE TABLE IF NOT EXISTS province (
  id BIGINT NOT NULL auto_increment,
  province_id int(11) NOT NULL,
  province varchar(20) NOT NULL,
  PRIMARY KEY  (id)
)CHARSET=utf8 ENGINE=InnoDB;

-- ------------------------
-- Table structure for city
-- 城市
-- ------------------------
DROP TABLE IF EXISTS city;
CREATE TABLE IF NOT EXISTS city (
  id BIGINT NOT NULL auto_increment,
  city_id int(11) NOT NULL,
  city varchar(20) NOT NULL,
  father_id int(11) NOT NULL,
  PRIMARY KEY  (id)
)CHARSET=utf8 ENGINE=InnoDB;

-- ------------------------
-- Table structure for area
-- 区域
-- ------------------------
DROP TABLE IF EXISTS area;
CREATE TABLE IF NOT EXISTS area(
  id BIGINT NOT NULL auto_increment,
  area_id int(11) NOT NULL,
  area varchar(20) character set gbk NOT NULL,
  father_id int(11) NOT NULL,
  PRIMARY KEY  (id)
)CHARSET=utf8 ENGINE=InnoDB;

-- ----------------------------
-- Table structure for user_info
-- 用户
-- ----------------------------
DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  user_no VARCHAR(255) COMMENT '用户编号',
  username varchar(255) COMMENT '用户名',
  area_id BIGINT COMMENT '园区信息表主键',
  building_id BIGINT COMMENT '大楼信息表主键',
  company_id BIGINT COMMENT '公司表主键',
  password varchar(255) null COMMENT '密码',
  salt varchar(255) null COMMENT '盐',
  locked bool DEFAULT TRUE COMMENT '是否锁定 0-false-不锁定  1-true-已锁定',
  CONSTRAINT pk_customer_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;
CREATE UNIQUE INDEX idx_sys_users_username ON user_info(username);

-- -------------------------
-- Table structure for roles
-- 角色
-- -------------------------
DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  role VARCHAR(255) COMMENT '权限',
  description VARCHAR(255) COMMENT '描述',
  available bool DEFAULT FALSE COMMENT '是否可获得 0-false-不可获得    1-true-可获得',
  CONSTRAINT pk_sys_roles PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=InnoDB;
CREATE UNIQUE INDEX idx_roles_role ON roles(role);

-- -------------------------------
-- Table structure for permissions
-- 权限
-- -------------------------------
DROP TABLE IF EXISTS permissions;
CREATE TABLE permissions (
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  permission VARCHAR(255) COMMENT '权限',
  description VARCHAR(255) COMMENT '描述',
  available bool DEFAULT FALSE COMMENT '是否可获得 0-false-不可获得    1-true-可获得',
  CONSTRAINT pk_permissions PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=InnoDB;
CREATE UNIQUE INDEX idx_permissions_permission ON permissions(permission);

-- -------------------------------
-- Table structure for users_roles
-- 用户角色
-- -------------------------------
DROP TABLE IF EXISTS users_roles;
CREATE TABLE users_roles (
  user_id BIGINT COMMENT 'user_info的id',
  role_id BIGINT COMMENT 'roles的id',
  CONSTRAINT pk_users_roles PRIMARY KEY(user_id, role_id)
) CHARSET=utf8 ENGINE=InnoDB;

-- -------------------------------------
-- Table structure for roles_permissions
-- 角色权限
-- -------------------------------------
DROP TABLE IF EXISTS roles_permissions;
CREATE TABLE roles_permissions (
  role_id BIGINT COMMENT 'roles的id',
  permission_id BIGINT COMMENT 'permissions的id',
  CONSTRAINT pk_roles_permissions PRIMARY KEY(role_id, permission_id)
) CHARSET=utf8 ENGINE=InnoDB;

-- -----------------------------
-- Table structure for area_info
-- 园区信息表
-- -----------------------------
DROP TABLE IF EXISTS area_info;
create table area_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  area_no VARCHAR(255) NULL COMMENT '园区编号',
  area_name VARCHAR(255) null COMMENT '园区名称（西湖国际，湖州）',
  provice_id BIGINT COMMENT '省id',
  city_id BIGINT COMMENT '城市id',
  area_id BIGINT COMMENT '区域id',
  address VARCHAR(255) NULL COMMENT '地址',
  jigou VARCHAR(255) null COMMENT '所属机构（中节能）',
  CONSTRAINT pk_area_info PRIMARY KEY (id)
) CHARSET=utf8 ENGINE=InnoDB;

-- ----------------------------------
-- Table structure for building_info
-- 大楼信息表
-- ---------------------------------
DROP TABLE IF EXISTS building_info;
create table building_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  building_no VARCHAR(255) NULL  COMMENT '大楼编号',
  building_name varchar(255) null COMMENT '大楼名称',
  building_addr varchar(255) null COMMENT '地址',
  area_id BIGINT COMMENT '所在园区id',
  CONSTRAINT pk_building_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

-- ----------------------------------
-- Table structure for company_info
-- 公司信息表
-- ---------------------------------
DROP TABLE IF EXISTS company_info;
CREATE TABLE company_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  company_no VARCHAR(255) NULL  COMMENT '公司编号',
  company_name VARCHAR(255) NULL COMMENT '公司名称',
  address varchar(255) null COMMENT '地址',
  building_id BIGINT COMMENT '所在大楼id',
  CONSTRAINT pk_company_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;
-- -----------------------------------
-- Table structure for user_meter_info
-- 用户-水电表
-- -----------------------------------
DROP TABLE IF EXISTS user_meter_info;
create table user_meter_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  user_id BIGINT COMMENT '用户id,对应用户信息表id',
  meter_type int null COMMENT '(0,水表，1电表）',
  meter_id varchar(255) null COMMENT '电表或水表号',
  CONSTRAINT pk_customer_meter_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

-- -------------------------------
-- Table structure for power_price
-- 电表价格
-- -------------------------------
DROP TABLE IF EXISTS power_price;
CREATE TABLE power_price(
  id BIGINT AUTO_INCREMENT COMMENT '设置自增主键',
  description VARCHAR(255) COMMENT '描述',
  price NUMERIC COMMENT '价格',
  available bool DEFAULT FALSE COMMENT '是否可获得 0-false-不可获得    1-true-可获得',
  update_time DATETIME DEFAULT current_timestamp COMMENT '更新时间',
  CONSTRAINT pk_power_price PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

-- -------------------------------
-- Table structure for water_price
-- 水表价格
-- -------------------------------
DROP TABLE IF EXISTS water_price;
CREATE TABLE water_price(
  id BIGINT AUTO_INCREMENT COMMENT '设置自增主键',
  description VARCHAR(255) COMMENT '描述',
  price NUMERIC COMMENT '价格',
  available bool DEFAULT FALSE COMMENT '是否可获得 0-false-不可获得    1-true-可获得',
  update_time DATETIME DEFAULT current_timestamp COMMENT '更新时间',
  CONSTRAINT pk_water_price PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

-- ---------------------------------
-- Table structure for collector_info
-- 收集器
-- ---------------------------------
DROP TABLE IF EXISTS collector_info;
CREATE TABLE collector_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置自增主键',
  number VARCHAR(255) DEFAULT NULL COMMENT '采集器编号',
  building_id BIGINT DEFAULT NULL COMMENT '大楼id',
  address VARCHAR(255) DEFAULT NULL COMMENT '详细地址',
  power_water bool DEFAULT TRUE COMMENT '电表采集器或者水表采集器 0-false-水表采集器  1-true-电表采集器',
  available bool DEFAULT FALSE COMMENT '是否可获得 0-false-不可获得    1-true-可获得',
  comment1 VARCHAR(255) DEFAULT NULL COMMENT '备注1',
  comment2 VARCHAR(255) DEFAULT NULL COMMENT '备注2',
  comment3 VARCHAR(255) DEFAULT NULL COMMENT '备注3',
  CONSTRAINT pk_collector_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

-- ------------------------------
-- Table structure for water_info
-- 水表记录表（常规信息表）
-- ------------------------------
DROP TABLE IF EXISTS water_info;
CREATE TABLE water_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置自增主键',
  number VARCHAR(255) DEFAULT NULL COMMENT '电表编号',
  price_id BIGINT DEFAULT NULL COMMENT '电费价格',
  collector_id BIGINT DEFAULT NULL COMMENT '采集器id',
  company_id BIGINT DEFAULT NULL COMMENT '所有者 -- 就是公司',
  address VARCHAR(255) DEFAULT NULL COMMENT '详细地址',
  belong VARCHAR(255) DEFAULT NULL COMMENT '归属',
  caliber VARCHAR(255) DEFAULT NULL COMMENT '口径',
  state BOOL DEFAULT FALSE COMMENT '水表是否有效 0-false-该水表无效  1-true-该水表有效',
  comment1 VARCHAR(255) DEFAULT NULL COMMENT '备注1',
  comment2 VARCHAR(255) DEFAULT NULL COMMENT '备注2',
  comment3 VARCHAR(255) DEFAULT NULL COMMENT '备注3',
  CONSTRAINT pk_water_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

-- --------------------------------------
-- Table structure for water_meter_record
-- 水表记录表（读数记录信息表）
-- --------------------------------------
DROP TABLE IF EXISTS water_meter_record;
CREATE TABLE water_meter_record(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  water_info_id BIGINT DEFAULT NULL COMMENT 'water_info的主键字段',
  consumption FLOAT DEFAULT NULL COMMENT '水表读数',
  read_time DATETIME DEFAULT current_timestamp COMMENT '创建时间',
  CONSTRAINT pk_water_meter_record PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

-- ------------------------------
-- Table structure for power_info
-- 电表记录表（常规信息表）
-- -------------------------------
DROP TABLE IF EXISTS power_info;
CREATE TABLE power_info(
  id BIGINT AUTO_INCREMENT COMMENT '设置自增主键',
  number VARCHAR(255) DEFAULT NULL COMMENT '电表编号',
  price_id BIGINT DEFAULT NULL COMMENT '电费价格',
  collector_id BIGINT DEFAULT NULL COMMENT '采集器id',
  company_id BIGINT DEFAULT NULL COMMENT '所有者 -- 就是公司',
  address VARCHAR(255) DEFAULT NULL COMMENT '详细地址',
  belong VARCHAR(255) DEFAULT NULL COMMENT '归属',
  consumption VARCHAR(255) DEFAULT NULL COMMENT '用电名称',
  outgoing VARCHAR(255) DEFAULT NULL COMMENT '出线号  机柜号',
  rate FLOAT DEFAULT NULL COMMENT '倍率',
  state BOOL DEFAULT FALSE COMMENT '电表是否有效 0-false-该电表无效  1-true-该电表有效',
  comment1 VARCHAR(255) DEFAULT NULL COMMENT '备注1',
  comment2 VARCHAR(255) DEFAULT NULL COMMENT '备注2',
  comment3 VARCHAR(255) DEFAULT NULL COMMENT '备注3',
  CONSTRAINT pk_power_info PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;

-- --------------------------------------
-- Table structure for power_meter_record
-- 电表记录表（读数记录信息表）
-- --------------------------------------
DROP TABLE IF EXISTS power_meter_record;
CREATE TABLE power_meter_record(
  id BIGINT AUTO_INCREMENT COMMENT '设置主键自增',
  power_info_id BIGINT DEFAULT NULL COMMENT 'power_info的主键字段',
  code INT DEFAULT NULL COMMENT '编程设置密码',
  uan FLOAT DEFAULT NULL COMMENT 'A相电压',
  ubn FLOAT DEFAULT NULL COMMENT 'B项电压',
  ucn FLOAT DEFAULT NULL COMMENT 'C项电压',
  uab FLOAT DEFAULT NULL COMMENT '线电压uab',
  ubc FLOAT DEFAULT NULL COMMENT '线电压ubc',
  uca FLOAT DEFAULT NULL COMMENT '线电压uca',
  ia FLOAT DEFAULT NULL COMMENT 'A项电流',
  ib FLOAT DEFAULT NULL COMMENT 'B项电流',
  ic FLOAT DEFAULT NULL COMMENT 'C项电流',
  pa FLOAT DEFAULT NULL COMMENT 'A相有功功率',
  pb FLOAT DEFAULT NULL COMMENT 'B相有功功率',
  pc FLOAT DEFAULT NULL COMMENT 'C相有功功率',
  ps FLOAT DEFAULT NULL COMMENT '合相有功功率',
  qa FLOAT DEFAULT NULL COMMENT 'A相无功功率',
  qb FLOAT DEFAULT NULL COMMENT 'B相无功功率',
  qc FLOAT DEFAULT NULL COMMENT 'C相无功功率',
  qs FLOAT DEFAULT NULL COMMENT '合相无功功率',
  sa FLOAT DEFAULT NULL COMMENT 'A相视在功率',
  sb FLOAT DEFAULT NULL COMMENT 'B相视在功率',
  sc FLOAT DEFAULT NULL COMMENT 'C相视在功率',
  ss FLOAT DEFAULT NULL COMMENT '合相视在功率',
  pfa FLOAT DEFAULT NULL COMMENT 'A相功率因素',
  pfb FLOAT DEFAULT NULL COMMENT 'B相功率因素',
  pfc FLOAT DEFAULT NULL COMMENT 'C相功率因素',
  pfs FLOAT DEFAULT NULL COMMENT '合相功率因素',
  fr FLOAT DEFAULT NULL COMMENT '电网频率',
  by_kwhz FLOAT DEFAULT NULL COMMENT '本月总正向有功电能',
  by_kwhj FLOAT DEFAULT NULL COMMENT '本月尖正向有功电能',
  by_kwhf FLOAT DEFAULT NULL COMMENT '本月峰正向有功电能',
  by_kwhp FLOAT DEFAULT NULL COMMENT '本月平正向有功电能',
  by_kwhg FLOAT DEFAULT NULL COMMENT '本月谷正向有功电能',
  by_hkwhz FLOAT DEFAULT NULL COMMENT '本月总反向有功电能',
  by_hkwhj FLOAT DEFAULT NULL COMMENT '本月尖反向有功电能',
  by_hkwhf FLOAT DEFAULT NULL COMMENT '本月峰反向有功电能',
  by_hkwhp FLOAT DEFAULT NULL COMMENT '本月平反向有功电能',
  by_hkwhg FLOAT DEFAULT NULL COMMENT '本月谷反向有功电能',
  by_kvarhz FLOAT DEFAULT NULL COMMENT '本月总正向无功电能',
  by_kvarhj FLOAT DEFAULT NULL COMMENT '本月尖正向无功电能',
  by_kvarhf FLOAT DEFAULT NULL COMMENT '本月峰正向无功电能',
  by_kvarhp FLOAT DEFAULT NULL COMMENT '本月平正向无功电能',
  by_kvarhg FLOAT DEFAULT NULL COMMENT '本月谷正向无功电能',
  by_hkvarhz FLOAT DEFAULT NULL COMMENT '本月总反向无功电能',
  by_hkvarhj FLOAT DEFAULT NULL COMMENT '本月尖反向无功电能',
  by_hkvarhhf FLOAT DEFAULT NULL COMMENT '本月峰反向无功电能',
  by_hkvarhp FLOAT DEFAULT NULL COMMENT '本月平反向无功电能',
  by_hkvarhg FLOAT DEFAULT NULL COMMENT '本月谷反无功电能',
  sy_kwhz FLOAT DEFAULT NULL COMMENT '上月总正向有功电能',
  sy_kwhj FLOAT DEFAULT NULL COMMENT '上月尖正向有功电能',
  sy_kwhf FLOAT DEFAULT NULL COMMENT '上月峰正向有功电能',
  sy_kwhp FLOAT DEFAULT NULL COMMENT '上月正向有功电能',
  sy_kwhg FLOAT DEFAULT NULL COMMENT '上月谷正向有功电能',
  sy_hkwhz FLOAT DEFAULT NULL COMMENT '上月总反向有功电能',
  sy_hkwhj FLOAT DEFAULT NULL COMMENT '上月尖反向有功电能',
  sy_hkwhf FLOAT DEFAULT NULL COMMENT '上月峰反向有功电能',
  sy_hkwhp FLOAT DEFAULT NULL COMMENT '上月平反向有功电能',
  sy_hkwhg FLOAT DEFAULT NULL COMMENT '上月谷反向有功电能',
  sy_kvarhz FLOAT DEFAULT NULL COMMENT '上月总正向无功电能',
  sy_kvarhj FLOAT DEFAULT NULL COMMENT '上月尖正向无功电能',
  sy_kvarhf FLOAT DEFAULT NULL COMMENT '上月峰正向无功电能',
  sy_kvarhp FLOAT DEFAULT NULL COMMENT '上月平正向无功电能',
  sy_kvarhg FLOAT DEFAULT NULL COMMENT '上月谷正向无功电能',
  sy_hkvarhz FLOAT DEFAULT NULL COMMENT '上月总反向无功电能',
  sy_hkvarhj FLOAT DEFAULT NULL COMMENT '上月尖反向无功电能',
  sy_hkvarhhf FLOAT DEFAULT NULL COMMENT '上月峰反向无功电能',
  sy_hkvarhp FLOAT DEFAULT NULL COMMENT '上月平反向无功电能',
  sy_hkvarhg FLOAT DEFAULT NULL COMMENT '上月谷反无功电能',
  ssy_kwhz FLOAT DEFAULT NULL COMMENT '上上月总正向有功电能',
  ssy_kwhj FLOAT DEFAULT NULL COMMENT '上上月尖正向有功电能',
  ssy_kwhf FLOAT DEFAULT NULL COMMENT '上上月峰正向有功电能',
  ssy_kwhp FLOAT DEFAULT NULL COMMENT '上上月正向有功电能',
  ssy_kwhg FLOAT DEFAULT NULL COMMENT '上上月谷正向有功电能',
  ssy_hkwhz FLOAT DEFAULT NULL COMMENT '上上月总反向有功电能',
  ssy_hkwhj FLOAT DEFAULT NULL COMMENT '上上月尖反向有功电能',
  ssy_hkwhf FLOAT DEFAULT NULL COMMENT '上上月峰反向有功电能',
  ssy_hkwhp FLOAT DEFAULT NULL COMMENT '上上月平反向有功电能',
  ssy_hkwhg FLOAT DEFAULT NULL COMMENT '上上月谷反向有功电能',
  ssy_kvarhz FLOAT DEFAULT NULL COMMENT '上上月总正向无功电能',
  ssy_kvarhj FLOAT DEFAULT NULL COMMENT '上上月尖正向无功电能',
  ssy_kvarhf FLOAT DEFAULT NULL COMMENT '上上月峰正向无功电能',
  ssy_kvarhp FLOAT DEFAULT NULL COMMENT '上上月平正向无功电能',
  ssy_kvarhg FLOAT DEFAULT NULL COMMENT '上上月谷正向无功电能',
  ssy_hkvarhz FLOAT DEFAULT NULL COMMENT '上上月总反向无功电能',
  ssy_hkvarhj FLOAT DEFAULT NULL COMMENT '上上月尖反向无功电能',
  ssy_hkvarhhf FLOAT DEFAULT NULL COMMENT '上上月峰反向无功电能',
  ssy_hkvarhp FLOAT DEFAULT NULL COMMENT '上上月平反向无功电能',
  ssy_hkvarhg FLOAT DEFAULT NULL COMMENT '上上月谷反无功电能',
  epp FLOAT DEFAULT NULL COMMENT '二次侧正向有功电能',
  epn FLOAT DEFAULT NULL COMMENT '二次侧负向有功电能',
  eqp FLOAT DEFAULT NULL COMMENT '二次侧正向无功电能',
  eqn FLOAT DEFAULT NULL COMMENT '二次侧负向无功电能',
  read_time DATETIME DEFAULT current_timestamp COMMENT '创建时间',
  CONSTRAINT pk_power_meter_record PRIMARY KEY (id)
)CHARSET=utf8 ENGINE=InnoDB;