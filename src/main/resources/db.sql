-- ----------------------------
-- Table structure for chain
-- ----------------------------
DROP TABLE IF EXISTS `chain`;
CREATE TABLE `chain`  (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                          `application_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                          `chain_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                          `chain_desc` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                          `el_data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
                          `create_time` datetime NULL DEFAULT NULL,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chain
-- ----------------------------
INSERT INTO `chain` VALUES (1, 'demo', 'chain1', '测试流程', 'THEN(a, b, c,s1);', '2022-09-19 19:31:00');
INSERT INTO `chain` VALUES (2, 'demo', 'chain2', '测试流程', 'THEN(a, b, c,s2);', '2022-09-19 19:31:00');
INSERT INTO `chain` VALUES (3, 'demo', 'old_man_tag', '老人标签', 'IF(old_man,THEN(hit));', '2023-06-09 09:50:27');
INSERT INTO `chain` VALUES (4, 'demo', 'female_tag', '女性标签', 'IF(female,THEN(hit));', '2023-06-09 09:50:27');
INSERT INTO `chain` VALUES (5, 'demo', 'female_retire_tag', '退休女学员标签', 'IF(AND(female,retire),THEN(hit));', '2023-06-09 09:50:27');

-- ----------------------------
-- Table structure for script
-- ----------------------------
DROP TABLE IF EXISTS `script`;
CREATE TABLE `script`  (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `application_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                           `script_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                           `script_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                           `script_data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
                           `script_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                           `script_language` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of script
-- ----------------------------
INSERT INTO `script` VALUES (1, 'demo', 's1', '脚本s1', 'defaultContext.setData(\"s1\",\"hello\")', 'script', 'qlexpress');
INSERT INTO `script` VALUES (2, 'demo', 's2', '脚本s2', 'import cn.hutool.core.date.DateUtil\r\n\r\ndef date = DateUtil.parse(\"2022-10-17 13:31:43\")\r\nprintln(date)\r\ndefaultContext.setData(\"demoDate\", date)\r\n\r\nclass Student {\r\n   int studentID\r\n   String studentName\r\n}\r\n\r\nStudent student = new Student()\r\nstudent.studentID = 100301\r\nstudent.studentName = \"张三\"\r\ndefaultContext.setData(\"student\",student)\r\n\r\ndef a=3\r\ndef b=2\r\ndefaultContext.setData(\"s1\",a*b)', 'script', 'groovy');
INSERT INTO `script` VALUES (3, 'demo', 'old_man', '老年人', 'getAge(userContext)>30', 'if_script', 'aviator');
INSERT INTO `script` VALUES (4, 'demo', 'female', '女学员', 'getSex(userContext)==1', 'if_script', 'aviator');
INSERT INTO `script` VALUES (5, 'demo', 'retire', '退休学员', 'isRetire(userContext)', 'if_script', 'aviator');

SET FOREIGN_KEY_CHECKS = 1;