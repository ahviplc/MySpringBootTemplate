/*
 Navicat Premium Data Transfer

 Source Server         : PG-postgres-nas
 Source Server Type    : PostgreSQL
 Source Server Version : 140007 (140007)
 Source Host           : 192.168.#.#:5432
 Source Catalog        : postgres
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 140007 (140007)
 File Encoding         : 65001

 Date: 08/05/2023 13:03:59
*/


-- ----------------------------
-- Table structure for tb_account
-- ----------------------------
DROP TABLE IF EXISTS "public"."tb_account";
CREATE TABLE "public"."tb_account" (
  "id" int4,
  "user_name" varchar COLLATE "pg_catalog"."default",
  "age" int4,
  "birthday" timestamp(6)
)
;

-- ----------------------------
-- Records of tb_account
-- ----------------------------
INSERT INTO "public"."tb_account" VALUES (1, 'haha1', 1, '2023-05-08 00:30:10');
INSERT INTO "public"."tb_account" VALUES (2, '2', 101, '2023-05-08 01:37:16');
INSERT INTO "public"."tb_account" VALUES (3, '3', 99, '2023-05-08 01:37:29');
