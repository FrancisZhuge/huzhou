-- ------------------------
-- Table data for area_info
-- 园区 - 数据
-- ------------------------
INSERT INTO area_info(area_no, area_name, provice_id, city_id, area_id, address, jigou) VALUES ("1","湖州",11,94,971,"某某大道100号","中节能");
INSERT INTO area_info(area_no, area_name, provice_id, city_id, area_id, address, jigou) VALUES ("2","西湖国际",11,94,971,"某莫某路10000号","中节能");

-- ----------------------------
-- Table data for building_info
-- 大楼 - 数据
-- ----------------------------
INSERT INTO building_info(building_no, building_name, building_addr, area_id) VALUES ("B1","B1","",1);
INSERT INTO building_info(building_no, building_name, building_addr, area_id) VALUES ("B3","B3","",1);
INSERT INTO building_info(building_no, building_name, building_addr, area_id) VALUES ("B7","B7","",1);
INSERT INTO building_info(building_no, building_name, building_addr, area_id) VALUES ("B2","B2","",1);
INSERT INTO building_info(building_no, building_name, building_addr, area_id) VALUES ("B5","B5","",1);
INSERT INTO building_info(building_no, building_name, building_addr, area_id) VALUES ("B6","B6","",1);
INSERT INTO building_info(building_no, building_name, building_addr, area_id) VALUES ("V6","V6","",1);
INSERT INTO building_info(building_no, building_name, building_addr, area_id) VALUES ("V7","V7","",1);
INSERT INTO building_info(building_no, building_name, building_addr, area_id) VALUES ("V8","V8","",1);

-- ---------------------------
-- Table data for company_info
-- 公司 - 数据
-- ---------------------------
INSERT INTO company_info(company_no, company_name, address, building_id) VALUES ("001","001发展有限公司","整楼",1);
INSERT INTO company_info(company_no, company_name, address, building_id) VALUES ("002","002发展有限公司","整楼",2);
INSERT INTO company_info(company_no, company_name, address, building_id) VALUES ("003","003发展有限公司","整楼",3);
INSERT INTO company_info(company_no, company_name, address, building_id) VALUES ("004","004发展有限公司","整楼",4);
INSERT INTO company_info(company_no, company_name, address, building_id) VALUES ("005","005发展有限公司","整楼",5);
INSERT INTO company_info(company_no, company_name, address, building_id) VALUES ("006","006发展有限公司","整楼",6);
INSERT INTO company_info(company_no, company_name, address, building_id) VALUES ("007","007发展有限公司","整楼",7);

-- -----------------------------
-- Table data for collector_info
-- 采集器 - 数据
-- -----------------------------
INSERT INTO collector_info(number, building_id, address) VALUES ("001",1,"东北角");
INSERT INTO collector_info(number, building_id, address) VALUES ("002",2,"大门口");
INSERT INTO collector_info(number, building_id, address) VALUES ("003",3,"西北角");
INSERT INTO collector_info(number, building_id, address) VALUES ("004",4,"东南角");
INSERT INTO collector_info(number, building_id, address) VALUES ("005",5,"正东");

-- --------------------------
-- Table data for water_price
-- 水费 - 数据
-- --------------------------
INSERT INTO water_price(description, price, available, update_time ) VALUES ("8月份水费",2.88,FALSE,'2017-08-01 00:00:00');
INSERT INTO water_price(description, price, available, update_time ) VALUES ("9月份水费",2.88,FALSE,'2017-09-01 00:00:00');
INSERT INTO water_price(description, price, available, update_time ) VALUES ("10月份水费",2.88,FALSE,'2017-10-01 00:00:00');
INSERT INTO water_price(description, price, available, update_time ) VALUES ("11月份水费",2.88,FALSE,'2017-11-01 00:00:00');

-- --------------------------
-- Table data for power_price
-- 电费 - 数据
-- --------------------------
INSERT INTO power_price(description, price, available, update_time ) VALUES ("8月份水费",2.88,FALSE,'2017-08-01 00:00:00');
INSERT INTO power_price(description, price, available, update_time ) VALUES ("9月份水费",2.88,FALSE,'2017-09-01 00:00:00');
INSERT INTO power_price(description, price, available, update_time ) VALUES ("10月份水费",2.88,FALSE,'2017-10-01 00:00:00');
INSERT INTO power_price(description, price, available, update_time ) VALUES ("11月份水费",2.88,FALSE,'2017-11-01 00:00:00');

-- --------------------------
-- Table data for water_info
-- 水表基础信息 - 数据
-- --------------------------
INSERT INTO water_info(number, price_id, collector_id, address, company_id, belong, caliber, state ) VALUES ("001",4,1,"第二层角落",1,"","7.25",TRUE );
INSERT INTO water_info(number, price_id, collector_id, address, company_id, belong, caliber, state ) VALUES ("002",4,1,"机柜",2,"","7.25",TRUE );
INSERT INTO water_info(number, price_id, collector_id, address, company_id, belong, caliber, state ) VALUES ("003",4,1,"总线匝",3,"","7.25",TRUE );
INSERT INTO water_info(number, price_id, collector_id, address, company_id, belong, caliber, state ) VALUES ("004",4,1,"水表旁边",4,"","7.25",TRUE );
INSERT INTO water_info(number, price_id, collector_id, address, company_id, belong, caliber, state ) VALUES ("005",4,1,"第一层东北角",5,"","7.25",TRUE );

-- ---------------------------------
-- Table data for water_meter_record
-- 水表读数 - 数据
-- ---------------------------------
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,1.4,'2017-11-01 00:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,1.5,'2017-11-01 07:58:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,1.6,'2017-11-01 08:01:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,1.7,'2017-11-01 08:02:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,1.8,'2017-11-01 12:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,1.9,'2017-11-01 20:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,2.0,'2017-11-02 00:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,2.1,'2017-11-02 07:58:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,2.2,'2017-11-02 08:01:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,2.3,'2017-11-02 08:02:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,2.4,'2017-11-02 12:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,2.5,'2017-11-02 20:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,2.6,'2017-11-03 00:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,2.7,'2017-11-04 07:58:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,2.8,'2017-11-05 08:01:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,2.9,'2017-11-06 08:02:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,3.0,'2017-11-07 12:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (1,3.1,'2017-11-08 20:00:00');

INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,1.4,'2017-11-01 00:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,1.5,'2017-11-01 07:58:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,1.6,'2017-11-01 08:01:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,1.7,'2017-11-01 08:02:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,1.8,'2017-11-01 12:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,1.9,'2017-11-01 20:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,2.0,'2017-11-02 00:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,2.1,'2017-11-02 07:58:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,2.2,'2017-11-02 08:01:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,2.3,'2017-11-02 08:02:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,2.4,'2017-11-02 12:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,2.5,'2017-11-02 20:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,2.6,'2017-11-03 00:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,2.7,'2017-11-04 07:58:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,2.8,'2017-11-05 08:01:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,2.9,'2017-11-06 08:02:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,3.0,'2017-11-07 12:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (2,3.1,'2017-11-08 20:00:00');

INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,1.4,'2017-11-01 00:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,1.5,'2017-11-01 07:58:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,1.6,'2017-11-01 08:01:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,1.7,'2017-11-01 08:02:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,1.8,'2017-11-01 12:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,1.9,'2017-11-01 20:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,2.0,'2017-11-02 00:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,2.1,'2017-11-02 07:58:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,2.2,'2017-11-02 08:01:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,2.3,'2017-11-02 08:02:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,2.4,'2017-11-02 12:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,2.5,'2017-11-02 20:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,2.6,'2017-11-03 00:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,2.7,'2017-11-04 07:58:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,2.8,'2017-11-05 08:01:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,2.9,'2017-11-06 08:02:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,3.0,'2017-11-07 12:00:00');
INSERT INTO water_meter_record(water_info_id, consumption, read_time) VALUES (3,3.1,'2017-11-08 20:00:00');

-- -------------------------
-- Table data for power_info
-- 电表基础信息 - 数据
-- -------------------------
INSERT power_info(number, price_id, collector_id, address, company_id, belong, consumption, outgoing, rate) VALUES ("001",4,1,"第二层角落",1,"","中节能","1P4",1.2);
INSERT power_info(number, price_id, collector_id, address, company_id, belong, consumption, outgoing, rate) VALUES ("002",4,1,"第二层角落",2,"","中节能","1P4",1.2);
INSERT power_info(number, price_id, collector_id, address, company_id, belong, consumption, outgoing, rate) VALUES ("003",4,1,"第二层角落",3,"","中节能","1P4",1.2);
INSERT power_info(number, price_id, collector_id, address, company_id, belong, consumption, outgoing, rate) VALUES ("004",4,1,"第二层角落",4,"","中节能","1P4",1.2);
INSERT power_info(number, price_id, collector_id, address, company_id, belong, consumption, outgoing, rate) VALUES ("005",4,1,"第二层角落",5,"","中节能","1P4",1.2);

-- -------------------------
-- Table data for power_meter_record
-- 电表读数 - 数据
-- -------------------------
