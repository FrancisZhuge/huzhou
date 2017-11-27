-- ------------------------
-- Table data for area_info
-- 园区 - 数据
INSERT INTO area_info(area_no, area_name, provice_id, city_id, area_id, address, jigou) VALUES
  ("hz","湖州",11,94,971,"某某大道100号","中节能"),
  ("xhgj","西湖国际",11,94,971,"某莫某路10000号","中节能");

-- ----------------------------
-- Table data for building_info
-- 大楼 - 数据
-- ----------------------------
INSERT INTO building_info(building_no, building_name, area_id) VALUES
  ("01","B1",1),
  ("02","B3",1),
  ("03","B7",1),
  ("04","B2",1),
  ("05","B5",1),
  ("06","B6",1),
  ("07","V6",1),
  ("08","V7",1),
  ("09","V8",1),
  ("10","V10",1),
  ("11","V11",1),
  ("12","A10",1),
  ("13","A16",1),
  ("14","B8",1),
  ("15","B9",1),
  ("16","B10",1),
  ("17","B11",1),
  ("18","B12",1),
  ("19","食堂",1),
  ("20","V1",1),
  ("21","V2",1),
  ("22","V3",1),
  ("23","V12",1),
  ("24","V5",1),
  ("25","A21",1),
  ("26","A22",1),
  ("27","A11",1),
  ("28","A12",1),
  ("29","A15",1),
  ("30","A18",1),
  ("31","A19",1),
  ("32","A17",1),
  ("33","A1",1),
  ("34","A2",1),
  ("35","A3",1),
  ("36","A5",1),
  ("37","A6",1),
  ("38","A7",1),
  ("39","A8",1),
  ("40","A9",1);

INSERT INTO company_info(company_no, company_name, area_id) VALUES
  ("01","湖州三盟纺织科技有限公司",1),
  ("02","湖州隆成智能科技有限公司",1),
  ("03","湖州恩赐智能科技有限公司",1),
  ("04","湖州市宇恒网络科技有限公司",1),
  ("05","湖州丽锦环保科技有限公司",1),
  ("06","湖州织里派格锐思电子商务有限公司",1),
  ("07","浙江家宇信息科技有限公司",1),
  ("08","V7",1),
  ("09","湖州凯妍生物科技有限公司",1),
  ("10","湖州亿意质量技术服务有限公司",1),
  ("11","V11",1),
  ("12","A10",1),
  ("13","湖州恒怡节能科技有限公司",1),
  ("14","B8",1),
  ("15","湖州织里沂鑫环保科技有限公司",1),
  ("16","湖州舒乐网络科技有限公司",1),
  ("17","湖州优创电子商务有限公司",1),
  ("18","B12",1),
  ("19","食堂",1),
  ("20","V1",1),
  ("21","V2",1),
  ("22","V3",1),
  ("23","V12",1),
  ("24","V5",1),
  ("25","闵利强",1),
  ("26","浙江拿酒网供应链管理有限公司",1),
  ("27","浙江久厨节能科技有限公司",1),
  ("28","湖州君皓环保材料有限公司",1),
  ("29","湖州朗途合金科技有限公司",1),
  ("30","湖州三荣节能环保产品贸易有限公司",1),
  ("31","浙江国鼎环境工程有限公司",1),
  ("32","浙江德赛堡建筑材料科技有限公司",1),
  ("33","湖州宇豪网络科技有限公司",1),
  ("34","湖州隆成智能科技有限公司",1),
  ("35","湖州创鼎实业有限公司",1),
  ("36","湖州创鼎实业有限公司",1),
  ("37","湖州赛德新材料科技有限公司",1),
  ("38","湖州三鼎信息科技有限公司",1),
  ("39","湖州酷美特智能科技有限公司",1);

INSERT INTO building_company VALUES
  (1,1),
  (2,2),
  (3,3),
  (4,4),
  (5,5),
  (6,6),
  (7,7),
  (8,8),
  (9,9),
  (10,10),
  (11,11),
  (12,12),
  (13,13),
  (14,14),
  (15,15),
  (16,16),
  (17,17),
  (18,18),
  (19,19),
  (20,20),
  (21,21),
  (22,22),
  (23,23),
  (24,24),
  (25,25),
  (26,26),
  (27,27),
  (28,28),
  (29,29),
  (30,30),
  (31,31),
  (32,32),
  (33,33),
  (34,34),
  (35,35),
  (36,36),
  (37,37),
  (38,38),
  (39,38),
  (40,39);

-- -----------------------
-- Data for collector_info
-- 采集器 - 数据
-- ------------------------
INSERT INTO collector_info(number, building_id, address) VALUES
  ("001",1,"东北角"),
  ("002",2,"大门口"),
  ("003",3,"西北角"),
  ("004",4,"东南角"),
  ("005",5,"正东");

INSERT INTO power_info(company_id,state) VALUES
  (1,TRUE ),
  (2,TRUE ),
  (3,TRUE ),
  (4,TRUE ),
  (5,TRUE ),
  (6,TRUE ),
  (7,TRUE ),
  (8,TRUE ),
  (9,TRUE ),
  (10,TRUE ),
  (11,TRUE ),
  (12,TRUE ),
  (13,TRUE ),
  (14,TRUE ),
  (15,TRUE ),
  (16,TRUE ),
  (17,TRUE ),
  (18,TRUE ),
  (19,TRUE ),
  (20,TRUE ),
  (21,TRUE ),
  (22,TRUE ),
  (23,TRUE ),
  (24,TRUE ),
  (25,TRUE ),
  (26,TRUE ),
  (27,TRUE ),
  (28,TRUE ),
  (29,TRUE ),
  (30,TRUE ),
  (31,TRUE ),
  (32,TRUE ),
  (33,TRUE ),
  (34,TRUE ),
  (35,TRUE ),
  (36,TRUE ),
  (37,TRUE ),
  (38,TRUE ),
  (38,TRUE ),
  (39,TRUE );

INSERT INTO power_meter_record(power_info_id,epp,read_time)VALUES
  (1,11610110758,"2016-10-11 07:58:00"),
  (1,11610110801,"2016-10-11 08:01:00"),
  (1,11610110802,"2016-10-11 08:02:00"),
  (1,11610111200,"2016-10-11 12:00:00"),
  (1,11610111400,"2016-10-11 14:00:00"),
  (1,11610111600,"2016-10-11 16:00:00"),
  (1,11611110758,"2016-11-11 07:58:00"),
  (1,11611110801,"2016-11-11 08:01:00"),
  (1,11611110802,"2016-11-11 08:02:00"),
  (1,11611111200,"2016-11-11 12:00:00"),
  (1,11611111400,"2016-11-11 14:00:00"),
  (1,11611111600,"2016-11-11 16:00:00"),
  (1,11710110758,"2017-10-11 07:58:00"),
  (1,11710110801,"2017-10-11 08:01:00"),
  (1,11710110802,"2017-10-11 08:02:00"),
  (1,11710111200,"2017-10-11 12:00:00"),
  (1,11710111400,"2017-10-11 14:00:00"),
  (1,11710111600,"2017-10-11 16:00:00"),
  (1,11711110758,"2017-11-11 07:58:00"),
  (1,11711110801,"2017-11-11 08:01:00"),
  (1,11711110802,"2017-11-11 08:02:00"),
  (1,11711111200,"2017-11-11 12:00:00"),
  (1,11711111400,"2017-11-11 14:00:00"),
  (1,11711111600,"2017-11-11 16:00:00"),
  (2,21610110758,"2016-10-11 07:58:00"),
  (2,21610110801,"2016-10-11 08:01:00"),
  (2,21610110802,"2016-10-11 08:02:00"),
  (2,21610111200,"2016-10-11 12:00:00"),
  (2,21610111400,"2016-10-11 14:00:00"),
  (2,21610111600,"2016-10-11 16:00:00"),
  (2,21611110758,"2016-11-11 07:58:00"),
  (2,21611110801,"2016-11-11 08:01:00"),
  (2,21611110802,"2016-11-11 08:02:00"),
  (2,21611111200,"2016-11-11 12:00:00"),
  (2,21611111400,"2016-11-11 14:00:00"),
  (2,21611111600,"2016-11-11 16:00:00"),
  (2,21710110758,"2017-10-11 07:58:00"),
  (2,21710110801,"2017-10-11 08:01:00"),
  (2,21710110802,"2017-10-11 08:02:00"),
  (2,21710111200,"2017-10-11 12:00:00"),
  (2,21710111400,"2017-10-11 14:00:00"),
  (2,21710111600,"2017-10-11 16:00:00"),
  (2,21711110758,"2017-11-11 07:58:00"),
  (2,21711110801,"2017-11-11 08:01:00"),
  (2,21711110802,"2017-11-11 08:02:00"),
  (2,21711111200,"2017-11-11 12:00:00"),
  (2,21711111400,"2017-11-11 14:00:00"),
  (2,21711111600,"2017-11-11 16:00:00"),
  (3,31610110758,"2016-10-11 07:58:00"),
  (3,31610110801,"2016-10-11 08:01:00"),
  (3,31610110802,"2016-10-11 08:02:00"),
  (3,31610111200,"2016-10-11 12:00:00"),
  (3,31610111400,"2016-10-11 14:00:00"),
  (3,31610111600,"2016-10-11 16:00:00"),
  (3,31611110758,"2016-11-11 07:58:00"),
  (3,31611110801,"2016-11-11 08:01:00"),
  (3,31611110802,"2016-11-11 08:02:00"),
  (3,31611111200,"2016-11-11 12:00:00"),
  (3,31611111400,"2016-11-11 14:00:00"),
  (3,31611111600,"2016-11-11 16:00:00"),
  (3,31710110758,"2017-10-11 07:58:00"),
  (3,31710110801,"2017-10-11 08:01:00"),
  (3,31710110802,"2017-10-11 08:02:00"),
  (3,31710111200,"2017-10-11 12:00:00"),
  (3,31710111400,"2017-10-11 14:00:00"),
  (3,31710111600,"2017-10-11 16:00:00"),
  (3,31711110758,"2017-11-11 07:58:00"),
  (3,31711110801,"2017-11-11 08:01:00"),
  (3,31711110802,"2017-11-11 08:02:00"),
  (3,31711111200,"2017-11-11 12:00:00"),
  (3,31711111400,"2017-11-11 14:00:00"),
  (3,31711111600,"2017-11-11 16:00:00");


INSERT INTO power_meter_record(power_info_id,epp,read_time)VALUES(4,1,"2017-11-11 16:00:00");

INSERT INTO power_meter_record(power_info_id,epp,read_time)VALUES
  (5,0.9,"2017-10-11 16:00:00"),
  (5,1.1,"2017-11-11 16:00:00");

INSERT INTO collector_info(building_id,power_water,available)VALUES
  (1,0,1),
  (2,0,1),
  (3,0,1),
  (4,0,1),
  (5,0,1),
  (6,0,1),
  (7,0,1),
  (8,0,1),
  (9,0,1),
  (10,0,1),
  (11,0,1),
  (12,0,1),
  (13,0,1),
  (14,0,1),
  (15,0,1),
  (16,0,1),
  (17,0,1),
  (18,0,1),
  (19,0,1),
  (20,0,1),
  (21,0,1),
  (22,0,1),
  (23,0,1),
  (24,0,1),
  (25,0,1),
  (26,0,1),
  (27,0,1),
  (28,0,1),
  (29,0,1),
  (30,0,1),
  (31,0,1),
  (32,0,1),
  (33,0,1),
  (34,0,1),
  (35,0,1),
  (36,0,1),
  (37,0,1),
  (38,0,1),
  (39,0,1),
  (40,0,1);


INSERT INTO water_info (collector_id,company_id,state)VALUES
  (1,1,1),
  (2,2,1),
  (3,3,1),
  (4,4,1),
  (5,5,1),
  (6,6,1),
  (7,7,1),
  (8,8,1),
  (9,9,1),
  (10,10,1),
  (11,11,1),
  (12,12,1),
  (13,13,1),
  (14,14,1),
  (15,15,1),
  (16,16,1),
  (17,17,1),
  (18,18,1),
  (19,19,1),
  (20,20,1),
  (21,21,1),
  (22,22,1),
  (23,23,1),
  (24,24,1),
  (25,25,1),
  (26,26,1),
  (27,27,1),
  (28,28,1),
  (29,29,1),
  (30,30,1),
  (31,31,1),
  (32,32,1),
  (33,33,1),
  (34,34,1),
  (35,35,1),
  (36,36,1),
  (37,37,1),
  (38,38,1),
  (39,38,1),
  (40,39,1);

INSERT INTO water_meter_record (water_info_id, consumption,read_time) VALUES
  (38,010101,"2017-11-26 01:01:01"),
  (38,010103,"2017-11-26 01:01:03"),
  (38,015901,"2017-11-26 01:59:01"),
  (38,015934,"2017-11-26 01:59:34"),
  (38,020101,"2017-11-26 02:01:01"),
  (38,020103,"2017-11-26 02:01:03"),
  (38,025901,"2017-11-26 02:59:01"),
  (38,025934,"2017-11-26 02:59:34"),
  (38,020101,"2017-11-26 02:01:01"),
  (38,020103,"2017-11-26 02:01:03"),
  (38,025901,"2017-11-26 02:59:01"),
  (38,025934,"2017-11-26 02:59:34"),
  (38,030101,"2017-11-26 03:01:01"),
  (38,030103,"2017-11-26 03:01:03"),
  (38,035901,"2017-11-26 03:59:01"),
  (38,035934,"2017-11-26 03:59:34"),
  (38,040101,"2017-11-26 04:01:01"),
  (38,040103,"2017-11-26 04:01:03"),
  (38,045901,"2017-11-26 04:59:01"),
  (38,045934,"2017-11-26 04:59:34"),
  (38,050101,"2017-11-26 05:01:01"),
  (38,050103,"2017-11-26 05:01:03"),
  (38,055901,"2017-11-26 05:59:01"),
  (38,055934,"2017-11-26 05:59:34"),
  (38,060101,"2017-11-26 06:01:01"),
  (38,060103,"2017-11-26 06:01:03"),
  (38,065901,"2017-11-26 06:59:01"),
  (38,065934,"2017-11-26 06:59:34"),
  (38,070101,"2017-11-26 07:01:01"),
  (38,070103,"2017-11-26 07:01:03"),
  (38,075901,"2017-11-26 07:59:01"),
  (38,075934,"2017-11-26 07:59:34"),
  (38,080101,"2017-11-26 08:01:01"),
  (38,080103,"2017-11-26 08:01:03"),
  (38,085901,"2017-11-26 08:59:01"),
  (38,085934,"2017-11-26 08:59:34"),
  (38,090101,"2017-11-26 09:01:01"),
  (38,090103,"2017-11-26 09:01:03"),
  (38,095901,"2017-11-26 09:59:01"),
  (38,095934,"2017-11-26 09:59:34"),
  (38,100101,"2017-11-26 10:01:01"),
  (38,100103,"2017-11-26 10:01:03"),
  (38,105901,"2017-11-26 10:59:01"),
  (38,105934,"2017-11-26 10:59:34"),
  (38,110101,"2017-11-26 11:01:01"),
  (38,110103,"2017-11-26 11:01:03"),
  (38,115901,"2017-11-26 11:59:01"),
  (38,115934,"2017-11-26 11:59:34"),
  (38,120101,"2017-11-26 12:01:01"),
  (38,120103,"2017-11-26 12:01:03"),
  (38,125901,"2017-11-26 12:59:01"),
  (38,125934,"2017-11-26 12:59:34"),
  (38,130101,"2017-11-26 13:01:01"),
  (38,130103,"2017-11-26 13:01:03"),
  (38,135901,"2017-11-26 13:59:01"),
  (38,135934,"2017-11-26 13:59:34"),
  (38,140101,"2017-11-26 14:01:01"),
  (38,140103,"2017-11-26 14:01:03"),
  (38,145901,"2017-11-26 14:59:01"),
  (38,145934,"2017-11-26 14:59:34"),
  (38,150101,"2017-11-26 15:01:01"),
  (38,150103,"2017-11-26 15:01:03"),
  (38,155901,"2017-11-26 15:59:01"),
  (38,155934,"2017-11-26 15:59:34"),
  (38,160101,"2017-11-26 16:01:01"),
  (38,160103,"2017-11-26 16:01:03"),
  (38,165901,"2017-11-26 16:59:01"),
  (38,165934,"2017-11-26 16:59:34"),
  (38,170101,"2017-11-26 17:01:01"),
  (38,170103,"2017-11-26 17:01:03"),
  (38,175901,"2017-11-26 17:59:01"),
  (38,175934,"2017-11-26 17:59:34"),
  (38,180101,"2017-11-26 18:01:01"),
  (38,180103,"2017-11-26 18:01:03"),
  (38,185901,"2017-11-26 18:59:01"),
  (38,185934,"2017-11-26 18:59:34"),
  (38,190101,"2017-11-26 19:01:01"),
  (38,190103,"2017-11-26 19:01:03"),
  (38,195901,"2017-11-26 19:59:01"),
  (38,195934,"2017-11-26 19:59:34"),
  (38,200101,"2017-11-26 20:01:01"),
  (38,200103,"2017-11-26 20:01:03"),
  (38,205901,"2017-11-26 20:59:01"),
  (38,205934,"2017-11-26 20:59:34"),
  (38,210101,"2017-11-26 21:01:01"),
  (38,210103,"2017-11-26 21:01:03"),
  (38,215901,"2017-11-26 21:59:01"),
  (38,215934,"2017-11-26 21:59:34"),
  (38,220101,"2017-11-26 22:01:01"),
  (38,220103,"2017-11-26 22:01:03"),
  (38,225901,"2017-11-26 22:59:01"),
  (38,225934,"2017-11-26 22:59:34"),
  (38,230101,"2017-11-26 23:01:01"),
  (38,230103,"2017-11-26 23:01:03"),
  (38,235901,"2017-11-26 23:59:01"),
  (38,235934,"2017-11-26 23:59:34"),
  (38,000101,"2017-11-27 00:01:01"),
  (38,000103,"2017-11-27 00:01:03"),
  (38,005901,"2017-11-27 00:59:01"),
  (38,005934,"2017-11-27 00:59:34"),
  (38,010101,"2017-11-27 01:01:01"),
  (38,010103,"2017-11-27 01:01:03"),
  (38,015901,"2017-11-27 01:59:01"),
  (38,015934,"2017-11-27 01:59:34"),
  (38,020101,"2017-11-27 02:01:01"),
  (38,020103,"2017-11-27 02:01:03"),
  (38,025901,"2017-11-27 02:59:01"),
  (38,025934,"2017-11-27 02:59:34"),
  (38,020101,"2017-11-27 02:01:01"),
  (38,020103,"2017-11-27 02:01:03"),
  (38,025901,"2017-11-27 02:59:01"),
  (38,025934,"2017-11-27 02:59:34"),
  (38,030101,"2017-11-27 03:01:01"),
  (38,030103,"2017-11-27 03:01:03"),
  (38,035901,"2017-11-27 03:59:01"),
  (38,035934,"2017-11-27 03:59:34"),
  (38,040101,"2017-11-27 04:01:01"),
  (38,040103,"2017-11-27 04:01:03"),
  (38,045901,"2017-11-27 04:59:01"),
  (38,045934,"2017-11-27 04:59:34"),
  (38,050101,"2017-11-27 05:01:01"),
  (38,050103,"2017-11-27 05:01:03"),
  (38,055901,"2017-11-27 05:59:01"),
  (38,055934,"2017-11-27 05:59:34"),
  (38,060101,"2017-11-27 06:01:01"),
  (38,060103,"2017-11-27 06:01:03"),
  (38,065901,"2017-11-27 06:59:01"),
  (38,065934,"2017-11-27 06:59:34"),
  (38,070101,"2017-11-27 07:01:01"),
  (38,070103,"2017-11-27 07:01:03"),
  (38,075901,"2017-11-27 07:59:01"),
  (38,075934,"2017-11-27 07:59:34"),
  (38,080101,"2017-11-27 08:01:01"),
  (38,080103,"2017-11-27 08:01:03"),
  (38,085901,"2017-11-27 08:59:01"),
  (38,085934,"2017-11-27 08:59:34"),
  (38,090101,"2017-11-27 09:01:01"),
  (38,090103,"2017-11-27 09:01:03"),
  (38,095901,"2017-11-27 09:59:01"),
  (38,095934,"2017-11-27 09:59:34"),
  (38,100101,"2017-11-27 10:01:01"),
  (38,100103,"2017-11-27 10:01:03"),
  (38,105901,"2017-11-27 10:59:01"),
  (38,105934,"2017-11-27 10:59:34"),
  (38,110101,"2017-11-27 11:01:01"),
  (38,110103,"2017-11-27 11:01:03"),
  (38,115901,"2017-11-27 11:59:01"),
  (38,115934,"2017-11-27 11:59:34"),
  (38,120101,"2017-11-27 12:01:01"),
  (38,120103,"2017-11-27 12:01:03"),
  (38,125901,"2017-11-27 12:59:01"),
  (38,125934,"2017-11-27 12:59:34"),
  (38,130101,"2017-11-27 13:01:01"),
  (38,130103,"2017-11-27 13:01:03"),
  (38,135901,"2017-11-27 13:59:01"),
  (38,135934,"2017-11-27 13:59:34"),
  (38,140101,"2017-11-27 14:01:01"),
  (38,140103,"2017-11-27 14:01:03"),
  (38,145901,"2017-11-27 14:59:01"),
  (38,145934,"2017-11-27 14:59:34"),
  (38,150101,"2017-11-27 15:01:01"),
  (38,150103,"2017-11-27 15:01:03"),
  (38,155901,"2017-11-27 15:59:01"),
  (38,155934,"2017-11-27 15:59:34"),
  (38,160101,"2017-11-27 16:01:01"),
  (38,160103,"2017-11-27 16:01:03"),
  (38,165901,"2017-11-27 16:59:01"),
  (38,165934,"2017-11-27 16:59:34");

INSERT INTO water_meter_record (water_info_id, consumption,read_time) VALUES
  (39,010101,"2017-11-26 01:01:01"),
  (39,010103,"2017-11-26 01:01:03"),
  (39,015901,"2017-11-26 01:59:01"),
  (39,015934,"2017-11-26 01:59:34"),
  (39,020101,"2017-11-26 02:01:01"),
  (39,020103,"2017-11-26 02:01:03"),
  (39,025901,"2017-11-26 02:59:01"),
  (39,025934,"2017-11-26 02:59:34"),
  (39,020101,"2017-11-26 02:01:01"),
  (39,020103,"2017-11-26 02:01:03"),
  (39,025901,"2017-11-26 02:59:01"),
  (39,025934,"2017-11-26 02:59:34"),
  (39,030101,"2017-11-26 03:01:01"),
  (39,030103,"2017-11-26 03:01:03"),
  (39,035901,"2017-11-26 03:59:01"),
  (39,035934,"2017-11-26 03:59:34"),
  (39,040101,"2017-11-26 04:01:01"),
  (39,040103,"2017-11-26 04:01:03"),
  (39,045901,"2017-11-26 04:59:01"),
  (39,045934,"2017-11-26 04:59:34"),
  (39,050101,"2017-11-26 05:01:01"),
  (39,050103,"2017-11-26 05:01:03"),
  (39,055901,"2017-11-26 05:59:01"),
  (39,055934,"2017-11-26 05:59:34"),
  (39,060101,"2017-11-26 06:01:01"),
  (39,060103,"2017-11-26 06:01:03"),
  (39,065901,"2017-11-26 06:59:01"),
  (39,065934,"2017-11-26 06:59:34"),
  (39,070101,"2017-11-26 07:01:01"),
  (39,070103,"2017-11-26 07:01:03"),
  (39,075901,"2017-11-26 07:59:01"),
  (39,075934,"2017-11-26 07:59:34"),
  (39,080101,"2017-11-26 08:01:01"),
  (39,080103,"2017-11-26 08:01:03"),
  (39,085901,"2017-11-26 08:59:01"),
  (39,085934,"2017-11-26 08:59:34"),
  (39,090101,"2017-11-26 09:01:01"),
  (39,090103,"2017-11-26 09:01:03"),
  (39,095901,"2017-11-26 09:59:01"),
  (39,095934,"2017-11-26 09:59:34"),
  (39,100101,"2017-11-26 10:01:01"),
  (39,100103,"2017-11-26 10:01:03"),
  (39,105901,"2017-11-26 10:59:01"),
  (39,105934,"2017-11-26 10:59:34"),
  (39,110101,"2017-11-26 11:01:01"),
  (39,110103,"2017-11-26 11:01:03"),
  (39,115901,"2017-11-26 11:59:01"),
  (39,115934,"2017-11-26 11:59:34"),
  (39,120101,"2017-11-26 12:01:01"),
  (39,120103,"2017-11-26 12:01:03"),
  (39,125901,"2017-11-26 12:59:01"),
  (39,125934,"2017-11-26 12:59:34"),
  (39,130101,"2017-11-26 13:01:01"),
  (39,130103,"2017-11-26 13:01:03"),
  (39,135901,"2017-11-26 13:59:01"),
  (39,135934,"2017-11-26 13:59:34"),
  (39,140101,"2017-11-26 14:01:01"),
  (39,140103,"2017-11-26 14:01:03"),
  (39,145901,"2017-11-26 14:59:01"),
  (39,145934,"2017-11-26 14:59:34"),
  (39,150101,"2017-11-26 15:01:01"),
  (39,150103,"2017-11-26 15:01:03"),
  (39,155901,"2017-11-26 15:59:01"),
  (39,155934,"2017-11-26 15:59:34"),
  (39,160101,"2017-11-26 16:01:01"),
  (39,160103,"2017-11-26 16:01:03"),
  (39,165901,"2017-11-26 16:59:01"),
  (39,165934,"2017-11-26 16:59:34"),
  (39,170101,"2017-11-26 17:01:01"),
  (39,170103,"2017-11-26 17:01:03"),
  (39,175901,"2017-11-26 17:59:01"),
  (39,175934,"2017-11-26 17:59:34"),
  (39,180101,"2017-11-26 18:01:01"),
  (39,180103,"2017-11-26 18:01:03"),
  (39,185901,"2017-11-26 18:59:01"),
  (39,185934,"2017-11-26 18:59:34"),
  (39,190101,"2017-11-26 19:01:01"),
  (39,190103,"2017-11-26 19:01:03"),
  (39,195901,"2017-11-26 19:59:01"),
  (39,195934,"2017-11-26 19:59:34"),
  (39,200101,"2017-11-26 20:01:01"),
  (39,200103,"2017-11-26 20:01:03"),
  (39,205901,"2017-11-26 20:59:01"),
  (39,205934,"2017-11-26 20:59:34"),
  (39,210101,"2017-11-26 21:01:01"),
  (39,210103,"2017-11-26 21:01:03"),
  (39,215901,"2017-11-26 21:59:01"),
  (39,215934,"2017-11-26 21:59:34"),
  (39,220101,"2017-11-26 22:01:01"),
  (39,220103,"2017-11-26 22:01:03"),
  (39,225901,"2017-11-26 22:59:01"),
  (39,225934,"2017-11-26 22:59:34"),
  (39,230101,"2017-11-26 23:01:01"),
  (39,230103,"2017-11-26 23:01:03"),
  (39,235901,"2017-11-26 23:59:01"),
  (39,235934,"2017-11-26 23:59:34"),
  (39,000101,"2017-11-27 00:01:01"),
  (39,000103,"2017-11-27 00:01:03"),
  (39,005901,"2017-11-27 00:59:01"),
  (39,005934,"2017-11-27 00:59:34"),
  (39,010101,"2017-11-27 01:01:01"),
  (39,010103,"2017-11-27 01:01:03"),
  (39,015901,"2017-11-27 01:59:01"),
  (39,015934,"2017-11-27 01:59:34"),
  (39,020101,"2017-11-27 02:01:01"),
  (39,020103,"2017-11-27 02:01:03"),
  (39,025901,"2017-11-27 02:59:01"),
  (39,025934,"2017-11-27 02:59:34"),
  (39,020101,"2017-11-27 02:01:01"),
  (39,020103,"2017-11-27 02:01:03"),
  (39,025901,"2017-11-27 02:59:01"),
  (39,025934,"2017-11-27 02:59:34"),
  (39,030101,"2017-11-27 03:01:01"),
  (39,030103,"2017-11-27 03:01:03"),
  (39,035901,"2017-11-27 03:59:01"),
  (39,035934,"2017-11-27 03:59:34"),
  (39,040101,"2017-11-27 04:01:01"),
  (39,040103,"2017-11-27 04:01:03"),
  (39,045901,"2017-11-27 04:59:01"),
  (39,045934,"2017-11-27 04:59:34"),
  (39,050101,"2017-11-27 05:01:01"),
  (39,050103,"2017-11-27 05:01:03"),
  (39,055901,"2017-11-27 05:59:01"),
  (39,055934,"2017-11-27 05:59:34"),
  (39,060101,"2017-11-27 06:01:01"),
  (39,060103,"2017-11-27 06:01:03"),
  (39,065901,"2017-11-27 06:59:01"),
  (39,065934,"2017-11-27 06:59:34"),
  (39,070101,"2017-11-27 07:01:01"),
  (39,070103,"2017-11-27 07:01:03"),
  (39,075901,"2017-11-27 07:59:01"),
  (39,075934,"2017-11-27 07:59:34"),
  (39,080101,"2017-11-27 08:01:01"),
  (39,080103,"2017-11-27 08:01:03"),
  (39,085901,"2017-11-27 08:59:01"),
  (39,085934,"2017-11-27 08:59:34"),
  (39,090101,"2017-11-27 09:01:01"),
  (39,090103,"2017-11-27 09:01:03"),
  (39,095901,"2017-11-27 09:59:01"),
  (39,095934,"2017-11-27 09:59:34"),
  (39,100101,"2017-11-27 10:01:01"),
  (39,100103,"2017-11-27 10:01:03"),
  (39,105901,"2017-11-27 10:59:01"),
  (39,105934,"2017-11-27 10:59:34"),
  (39,110101,"2017-11-27 11:01:01"),
  (39,110103,"2017-11-27 11:01:03"),
  (39,115901,"2017-11-27 11:59:01"),
  (39,115934,"2017-11-27 11:59:34"),
  (39,120101,"2017-11-27 12:01:01"),
  (39,120103,"2017-11-27 12:01:03"),
  (39,125901,"2017-11-27 12:59:01"),
  (39,125934,"2017-11-27 12:59:34"),
  (39,130101,"2017-11-27 13:01:01"),
  (39,130103,"2017-11-27 13:01:03"),
  (39,135901,"2017-11-27 13:59:01"),
  (39,135934,"2017-11-27 13:59:34"),
  (39,140101,"2017-11-27 14:01:01"),
  (39,140103,"2017-11-27 14:01:03"),
  (39,145901,"2017-11-27 14:59:01"),
  (39,145934,"2017-11-27 14:59:34"),
  (39,150101,"2017-11-27 15:01:01"),
  (39,150103,"2017-11-27 15:01:03"),
  (39,155901,"2017-11-27 15:59:01"),
  (39,155934,"2017-11-27 15:59:34"),
  (39,160101,"2017-11-27 16:01:01"),
  (39,160103,"2017-11-27 16:01:03"),
  (39,165901,"2017-11-27 16:59:01"),
  (39,165934,"2017-11-27 16:59:34");

INSERT INTO water_meter_record (water_info_id, consumption,read_time) VALUES
  (40,010101,"2017-11-26 01:01:01"),
  (40,010103,"2017-11-26 01:01:03"),
  (40,015901,"2017-11-26 01:59:01"),
  (40,015934,"2017-11-26 01:59:34"),
  (40,020101,"2017-11-26 02:01:01"),
  (40,020103,"2017-11-26 02:01:03"),
  (40,025901,"2017-11-26 02:59:01"),
  (40,025934,"2017-11-26 02:59:34"),
  (40,020101,"2017-11-26 02:01:01"),
  (40,020103,"2017-11-26 02:01:03"),
  (40,025901,"2017-11-26 02:59:01"),
  (40,025934,"2017-11-26 02:59:34"),
  (40,030101,"2017-11-26 03:01:01"),
  (40,030103,"2017-11-26 03:01:03"),
  (40,035901,"2017-11-26 03:59:01"),
  (40,035934,"2017-11-26 03:59:34"),
  (40,040101,"2017-11-26 04:01:01"),
  (40,040103,"2017-11-26 04:01:03"),
  (40,045901,"2017-11-26 04:59:01"),
  (40,045934,"2017-11-26 04:59:34"),
  (40,050101,"2017-11-26 05:01:01"),
  (40,050103,"2017-11-26 05:01:03"),
  (40,055901,"2017-11-26 05:59:01"),
  (40,055934,"2017-11-26 05:59:34"),
  (40,060101,"2017-11-26 06:01:01"),
  (40,060103,"2017-11-26 06:01:03"),
  (40,065901,"2017-11-26 06:59:01"),
  (40,065934,"2017-11-26 06:59:34"),
  (40,070101,"2017-11-26 07:01:01"),
  (40,070103,"2017-11-26 07:01:03"),
  (40,075901,"2017-11-26 07:59:01"),
  (40,075934,"2017-11-26 07:59:34"),
  (40,080101,"2017-11-26 08:01:01"),
  (40,080103,"2017-11-26 08:01:03"),
  (40,085901,"2017-11-26 08:59:01"),
  (40,085934,"2017-11-26 08:59:34"),
  (40,090101,"2017-11-26 09:01:01"),
  (40,090103,"2017-11-26 09:01:03"),
  (40,095901,"2017-11-26 09:59:01"),
  (40,095934,"2017-11-26 09:59:34"),
  (40,100101,"2017-11-26 10:01:01"),
  (40,100103,"2017-11-26 10:01:03"),
  (40,105901,"2017-11-26 10:59:01"),
  (40,105934,"2017-11-26 10:59:34"),
  (40,110101,"2017-11-26 11:01:01"),
  (40,110103,"2017-11-26 11:01:03"),
  (40,115901,"2017-11-26 11:59:01"),
  (40,115934,"2017-11-26 11:59:34"),
  (40,120101,"2017-11-26 12:01:01"),
  (40,120103,"2017-11-26 12:01:03"),
  (40,125901,"2017-11-26 12:59:01"),
  (40,125934,"2017-11-26 12:59:34"),
  (40,130101,"2017-11-26 13:01:01"),
  (40,130103,"2017-11-26 13:01:03"),
  (40,135901,"2017-11-26 13:59:01"),
  (40,135934,"2017-11-26 13:59:34"),
  (40,140101,"2017-11-26 14:01:01"),
  (40,140103,"2017-11-26 14:01:03"),
  (40,145901,"2017-11-26 14:59:01"),
  (40,145934,"2017-11-26 14:59:34"),
  (40,150101,"2017-11-26 15:01:01"),
  (40,150103,"2017-11-26 15:01:03"),
  (40,155901,"2017-11-26 15:59:01"),
  (40,155934,"2017-11-26 15:59:34"),
  (40,160101,"2017-11-26 16:01:01"),
  (40,160103,"2017-11-26 16:01:03"),
  (40,165901,"2017-11-26 16:59:01"),
  (40,165934,"2017-11-26 16:59:34"),
  (40,170101,"2017-11-26 17:01:01"),
  (40,170103,"2017-11-26 17:01:03"),
  (40,175901,"2017-11-26 17:59:01"),
  (40,175934,"2017-11-26 17:59:34"),
  (40,180101,"2017-11-26 18:01:01"),
  (40,180103,"2017-11-26 18:01:03"),
  (40,185901,"2017-11-26 18:59:01"),
  (40,185934,"2017-11-26 18:59:34"),
  (40,190101,"2017-11-26 19:01:01"),
  (40,190103,"2017-11-26 19:01:03"),
  (40,195901,"2017-11-26 19:59:01"),
  (40,195934,"2017-11-26 19:59:34"),
  (40,200101,"2017-11-26 20:01:01"),
  (40,200103,"2017-11-26 20:01:03"),
  (40,205901,"2017-11-26 20:59:01"),
  (40,205934,"2017-11-26 20:59:34"),
  (40,210101,"2017-11-26 21:01:01"),
  (40,210103,"2017-11-26 21:01:03"),
  (40,215901,"2017-11-26 21:59:01"),
  (40,215934,"2017-11-26 21:59:34"),
  (40,220101,"2017-11-26 22:01:01"),
  (40,220103,"2017-11-26 22:01:03"),
  (40,225901,"2017-11-26 22:59:01"),
  (40,225934,"2017-11-26 22:59:34"),
  (40,230101,"2017-11-26 23:01:01"),
  (40,230103,"2017-11-26 23:01:03"),
  (40,235901,"2017-11-26 23:59:01"),
  (40,235934,"2017-11-26 23:59:34"),
  (40,000101,"2017-11-27 00:01:01"),
  (40,000103,"2017-11-27 00:01:03"),
  (40,005901,"2017-11-27 00:59:01"),
  (40,005934,"2017-11-27 00:59:34"),
  (40,010101,"2017-11-27 01:01:01"),
  (40,010103,"2017-11-27 01:01:03"),
  (40,015901,"2017-11-27 01:59:01"),
  (40,015934,"2017-11-27 01:59:34"),
  (40,020101,"2017-11-27 02:01:01"),
  (40,020103,"2017-11-27 02:01:03"),
  (40,025901,"2017-11-27 02:59:01"),
  (40,025934,"2017-11-27 02:59:34"),
  (40,020101,"2017-11-27 02:01:01"),
  (40,020103,"2017-11-27 02:01:03"),
  (40,025901,"2017-11-27 02:59:01"),
  (40,025934,"2017-11-27 02:59:34"),
  (40,030101,"2017-11-27 03:01:01"),
  (40,030103,"2017-11-27 03:01:03"),
  (40,035901,"2017-11-27 03:59:01"),
  (40,035934,"2017-11-27 03:59:34"),
  (40,050101,"2017-11-27 05:01:01"),
  (40,050103,"2017-11-27 05:01:03"),
  (40,055901,"2017-11-27 05:59:01"),
  (40,055934,"2017-11-27 05:59:34"),
  (40,060101,"2017-11-27 06:01:01"),
  (40,060103,"2017-11-27 06:01:03"),
  (40,065901,"2017-11-27 06:59:01"),
  (40,065934,"2017-11-27 06:59:34"),
  (40,070101,"2017-11-27 07:01:01"),
  (40,070103,"2017-11-27 07:01:03"),
  (40,075901,"2017-11-27 07:59:01"),
  (40,075934,"2017-11-27 07:59:34"),
  (40,090101,"2017-11-27 09:01:01"),
  (40,090103,"2017-11-27 09:01:03"),
  (40,095901,"2017-11-27 09:59:01"),
  (40,095934,"2017-11-27 09:59:34"),
  (40,100101,"2017-11-27 10:01:01"),
  (40,100103,"2017-11-27 10:01:03"),
  (40,105901,"2017-11-27 10:59:01"),
  (40,105934,"2017-11-27 10:59:34"),
  (40,110101,"2017-11-27 11:01:01"),
  (40,110103,"2017-11-27 11:01:03"),
  (40,115901,"2017-11-27 11:59:01"),
  (40,115934,"2017-11-27 11:59:34"),
  (40,120101,"2017-11-27 12:01:01"),
  (40,120103,"2017-11-27 12:01:03"),
  (40,125901,"2017-11-27 12:59:01"),
  (40,125934,"2017-11-27 12:59:34"),
  (40,130101,"2017-11-27 13:01:01"),
  (40,130103,"2017-11-27 13:01:03"),
  (40,135901,"2017-11-27 13:59:01"),
  (40,135934,"2017-11-27 13:59:34"),
  (40,140101,"2017-11-27 14:01:01"),
  (40,140103,"2017-11-27 14:01:03"),
  (40,145901,"2017-11-27 14:59:01"),
  (40,145934,"2017-11-27 14:59:34"),
  (40,150101,"2017-11-27 15:01:01"),
  (40,150103,"2017-11-27 15:01:03"),
  (40,155901,"2017-11-27 15:59:01"),
  (40,155934,"2017-11-27 15:59:34"),
  (40,160101,"2017-11-27 16:01:01"),
  (40,160103,"2017-11-27 16:01:03"),
  (40,165901,"2017-11-27 16:59:01"),
  (40,165934,"2017-11-27 16:59:34");