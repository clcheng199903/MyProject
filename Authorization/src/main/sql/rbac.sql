-- ----------------------------

-- Table structure for menu

-- ----------------------------

DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
                         `id` bigint NOT NULL AUTO_INCREMENT COMMENT '权限id',
                         `menu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限名',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------

-- Records of menu

-- ----------------------------

INSERT INTO `menu` VALUES (1, 'sys:user:insert');
INSERT INTO `menu` VALUES (2, 'sys:user:delete');
INSERT INTO `menu` VALUES (3, 'sys:student:insert');
INSERT INTO `menu` VALUES (4, 'sys:student:delete');
INSERT INTO `menu` VALUES (5, 'sys:studet:update');
INSERT INTO `menu` VALUES (6, 'sys:user:login');

-- ----------------------------

-- Table structure for role

-- ----------------------------

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
                         `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色id',
                         `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------

-- Records of role

-- ----------------------------

INSERT INTO `role` VALUES (1, 'admin');
INSERT INTO `role` VALUES (2, 'student');
INSERT INTO `role` VALUES (3, 'teacher');

-- ----------------------------

-- Table structure for role_menu

-- ----------------------------

DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
                              `role_id` bigint NOT NULL COMMENT '角色id',
                              `menu_id` bigint NOT NULL COMMENT '权限id',
                              PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------

-- Records of role_menu

-- ----------------------------

INSERT INTO `role_menu` VALUES (1, 1);
INSERT INTO `role_menu` VALUES (1, 2);
INSERT INTO `role_menu` VALUES (1, 3);
INSERT INTO `role_menu` VALUES (1, 4);
INSERT INTO `role_menu` VALUES (1, 5);
INSERT INTO `role_menu` VALUES (1, 6);
INSERT INTO `role_menu` VALUES (2, 1);
INSERT INTO `role_menu` VALUES (2, 3);
INSERT INTO `role_menu` VALUES (2, 6);
INSERT INTO `role_menu` VALUES (3, 1);
INSERT INTO `role_menu` VALUES (3, 3);
INSERT INTO `role_menu` VALUES (3, 4);
INSERT INTO `role_menu` VALUES (3, 6);

-- ----------------------------

-- Table structure for user

-- ----------------------------

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
                         `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
                         `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------

-- Records of user

-- ----------------------------

INSERT INTO `user` VALUES (1, 'cx', '$10$S47LvooOhnDT0sVZ7DlShuqfEqcwhyhU3F9GKt0mbgx1vym.zZXWS');
INSERT INTO `user` VALUES (2, 'cxx', '$10$S47LvooOhnDT0sVZ7DlShuqfEqcwhyhU3F9GKt0mbgx1vym.zZXWS');
INSERT INTO `user` VALUES (3, 'cxxx', '$10$S47LvooOhnDT0sVZ7DlShuqfEqcwhyhU3F9GKt0mbgx1vym.zZXWS');

-- ----------------------------

-- Table structure for user_role

-- ----------------------------

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
                              `user_id` bigint NOT NULL COMMENT '用户ID',
                              `role_id` bigint NOT NULL COMMENT '角色ID',
                              PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------

-- Records of user_role

-- ----------------------------

INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 2);
INSERT INTO `user_role` VALUES (3, 2);
INSERT INTO `user_role` VALUES (3, 3);

SET FOREIGN_KEY_CHECKS = 1;
