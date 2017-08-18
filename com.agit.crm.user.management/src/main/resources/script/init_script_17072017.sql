-- ----------------------------
-- Records of mst_privilege
-- ----------------------------
INSERT INTO "public"."mst_privilege" VALUES ('0', 'ROOT', 'ROOT', 'DELETED', null, 't', 'Dashboard', 'Dashboard', null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('1', 'ADMINISTRATOR', 'Administrator', 'ACTIVE', 'ROOT', 't', 'Pengurus', null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('2', 'GROUP', 'Group', 'ACTIVE', 'ADMINISTRATOR', 't', 'Pengelolaan Grup', null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('3', 'GROUP_SEARCH', 'Group Search', 'ACTIVE', 'GROUP', 't', 'Pemeliharaan Grup', 'Pemeliharaan Grup', null, '~./ui/fnd/group/search.fnd.group.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('4', 'GROUP_UPDATE', 'Group Update', 'ACTIVE', 'GROUP_SEARCH', 'f', null, null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('5', 'GROUP_VIEW', 'Group View', 'ACTIVE', 'GROUP_SEARCH', 'f', null, null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('6', 'GROUP_DELETE', 'Group Delete', 'ACTIVE', 'GROUP_SEARCH', 'f', null, null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('7', 'GROUP_CREATE', 'Group Create', 'ACTIVE', 'GROUP', 't', 'Pembuatan Grup', 'Pembuatan Grup', null, '~./ui/fnd/group/create.fnd.group.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('8', 'USER_MANAGEMENT', 'User', 'ACTIVE', 'ADMINISTRATOR', 't', 'Pengelolaan Pengguna', null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('9', 'USER_SEARCH', 'User Search', 'ACTIVE', 'USER_MANAGEMENT', 't', 'Pemeliharaan Pengguna', 'Pemeliharaan Pengguna', null, '~./ui/fnd/user/search.fnd.user.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('10', 'USER_UPDATE', 'User Update', 'ACTIVE', 'USER_SEARCH', 'f', null, null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('11', 'USER_VIEW', 'User View', 'ACTIVE', 'USER_SEARCH', 'f', null, null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('12', 'USER_DELETE', 'User Delete', 'ACTIVE', 'USER_SEARCH', 'f', null, null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('13', 'USER_RESET_PASSWORD', 'User Reset Password', 'ACTIVE', 'USER_SEARCH', 'f', null, null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('14', 'USER_LOCK_UNLOCK', 'User Lock Unlock', 'ACTIVE', 'USER_SEARCH', 'f', null, null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('15', 'USER_CREATE', 'User Create', 'ACTIVE', 'USER_MANAGEMENT', 't', 'Pembuatan Pengguna', 'Pembuatan Pengguna', null, '~./ui/fnd/user/create.fnd.user.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('16', 'USER_RELEASE', 'User Release', 'ACTIVE', 'USER_MANAGEMENT', 't', 'Penghapusan Pengguna', 'Penghapusan Pengguna', null, '~./ui/fnd/user/release.fnd.user.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('17', 'MENU', 'Menu Dashboard', 'ACTIVE', 'ADMINISTRATOR', 't', 'Pengelolaan Menu', null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('18', 'MENU_MANAGEMENT', 'Menu Dashboard', 'ACTIVE', 'MENU', 't', 'Beranda - Menu', 'Beranda - Menu', null, '~./ui/fnd/menu/dashboard.privilege.zul', '2016-01-01 00:00:00', 'SYSTEM');

INSERT INTO "public"."mst_privilege" VALUES ('19', 'ADMIN_MANAGEMENT', 'Admin', 'ACTIVE', 'ADMINISTRATOR', 't', 'Pengelolaan Admin', null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('20', 'EVENT_MANAGEMENT', 'Event Management', 'ACTIVE', 'ADMIN_MANAGEMENT', 't', 'Beranda - Acara', 'Beranda - Acara', null, '/crm/admin/event/dashboard_event.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('21', 'FORUM_MANAGEMENT', 'Forum Management', 'ACTIVE', 'ADMIN_MANAGEMENT', 't', 'Beranda - Forum', 'Beranda - Forum', null, '/crm/admin/forum/dashboard_forum.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('23', 'KETRAMPILAN_MANAGEMENT', 'Ketrampilan Management', 'ACTIVE', 'ADMIN_MANAGEMENT', 't', 'Beranda - Data History Ketrampilan', 'Beranda - Data History Ketrampilan', null, '/crm/admin/ketrampilan/dashboard_ketrampilan.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('24', 'MINAT_MANAGEMENT', 'Minat Management', 'ACTIVE', 'ADMIN_MANAGEMENT', 't', 'Beranda - Data History Minat', 'Beranda - Data History Minat', null, '/crm/admin/minat/dashboard_minat.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('25', 'LOWONGAN_MANAGEMENT', 'Lowongan Management', 'ACTIVE', 'ADMIN_MANAGEMENT', 't', 'Beranda - Lowongan', 'Beranda - Lowongan', null, '/crm/admin/lowongan/dashboard_lowongan.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('26', 'JURUSAN_MANAGEMENT', 'Jurusan Management', 'ACTIVE', 'ADMIN_MANAGEMENT', 't', 'Beranda - Data History Jurusan', 'Beranda - Data History Jurusan', null, '/crm/admin/jurusan/dashboard_jurusan.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('27', 'DATA_MAHASISWA', 'Dashboard Data Mahasiswa', 'ACTIVE', 'ADMIN_MANAGEMENT', 't', 'Beranda - Mahasiswa', 'Beranda - Mahasiswa', null, '/crm/admin/dataRegister/dashboard_data_register_mahasiswa.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('28', 'DATA_APPLY', 'Dashboard Data Apply Lowongan', 'ACTIVE', 'ADMIN_MANAGEMENT', 't', 'Beranda - Data Apply Lowongan', 'Beranda - Data Apply Lowongan', null, '/crm/admin/dataApplyLowongan/dashboard_pelamar.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('32', 'DATA_CIVITAS', 'Dashboard Data Civitas', 'ACTIVE', 'ADMIN_MANAGEMENT', 't', 'Beranda - Data History Civitas', 'Beranda - Data History Civitas', null, '/crm/admin/civitas/dashboard_civitas.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('33', 'DATA_DOMISILI', 'Dashboard Data Domisili', 'ACTIVE', 'ADMIN_MANAGEMENT', 't', 'Beranda - Data History Domisili', 'Beranda - Data History Domisili', null, '/crm/admin/domisili/dashboard_domisili.zul', '2016-01-01 00:00:00', 'SYSTEM');

INSERT INTO "public"."mst_privilege" VALUES ('29', 'MAHASISWA_MANAGEMENT', 'Admin', 'ACTIVE', 'ADMINISTRATOR', 't', 'Pengelolaan Data Mahasiswa', null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('31', 'LOWONGAN', 'Beranda Lowongan', 'ACTIVE', 'MAHASISWA_MANAGEMENT', 't', 'Informasi - Lowongan', 'Informasi - Lowongan', null, '/crm/mahasiswa/beranda_lowongan_mahasiswa.zul', '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('34', 'PROFILE', 'Update Profile', 'ACTIVE', 'MAHASISWA_MANAGEMENT', 't', 'Profil - Profilku', 'Profil - Profilku', null, '/crm/mahasiswa/beranda_profile_mahasiswa.zul', '2016-01-01 00:00:00', 'SYSTEM');

INSERT INTO "public"."mst_privilege" VALUES ('35', 'RECRUITER_MANAGEMENT', 'Admin', 'ACTIVE', 'ADMINISTRATOR', 't', 'Pengelolaan Data Pelamar', null, null, null, '2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_privilege" VALUES ('36', 'DATA_PELAMAR', 'Data Pelamar', 'ACTIVE', 'RECRUITER_MANAGEMENT', 't', 'Data - Pelamar', 'Data - Pelamar', null, '/crm/recruiter/DashboardRecruiter.zul', '2016-01-01 00:00:00', 'SYSTEM');

-- ----------------------------
-- Records of mst_role
-- ----------------------------
INSERT INTO "public"."mst_role" VALUES ('1', 'SUPERADMIN', 'SUPERADMIN', 'SUPERADMIN', 'ACTIVE', '2016-01-01 00:00:00', 'SUPERADMIN');
INSERT INTO "public"."mst_role" VALUES ('2', 'ADMIN', 'ADMIN', 'ADMIN', 'ACTIVE', '2016-01-01 00:00:00', 'SUPERADMIN');
INSERT INTO "public"."mst_role" VALUES ('3', 'MAHASISWA', 'MAHASISWA', 'MAHASISWA', 'ACTIVE', '2016-01-01 00:00:00', 'SUPERADMIN');
INSERT INTO "public"."mst_role" VALUES ('4', 'RECUITER', 'RECUITER', 'RECUITER', 'ACTIVE', '2016-01-01 00:00:00', 'SUPERADMIN');

-- ----------------------------
-- Records of mst_role_privilege
-- ----------------------------
INSERT INTO "public"."mst_role_privilege" VALUES ('1', '1', 'ALLOW', '0');
INSERT INTO "public"."mst_role_privilege" VALUES ('2', '19', 'ALLOW', '0');
INSERT INTO "public"."mst_role_privilege" VALUES ('2', '29', 'ALLOW', '1');
INSERT INTO "public"."mst_role_privilege" VALUES ('3', '29', 'ALLOW', '0');
INSERT INTO "public"."mst_role_privilege" VALUES ('4', '35', 'ALLOW', '0');

-- ----------------------------
-- Records of mst_user
-- ----------------------------
INSERT INTO "public"."mst_user" VALUES ('1', 'SUPERADMIN', '$2a$10$vW7zns/PRqfHgaxN3DpJuuH2n1mI152gMxO6Lnm4X6zrAEXDPBAUC', 'USER001', '1200101', 'ACTIVE', '1', 'Super Admin', 'superadmin@agit.com', '0811111111', 'SYSTEM', '001','321354616', null, 'TI', 'JAKARTA', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', null, null, '0', '2016-09-21 15:37:06.305', null, null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '1e2fuhqu103ts1uv76m4k3czc', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,'2016-01-01 00:00:00', 'SYSTEM');
INSERT INTO "public"."mst_user" VALUES ('2', 'ADMIN', '$2a$10$57J57UK4Wxa6GUWig2QyA.KYv5GgiHeXUIUppRtmczWSlTJd35iba', 'USER002', '1200102', 'ACTIVE', '2', 'Admin', 'admin@agit.com', '0811111111', 'SUPERADMIN', '001', '321354617', null, 'TI', 'BANDUNG', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', null, null, '0', null, null, null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,'2016-01-01 00:00:00', 'SUPERADMIN');
INSERT INTO "public"."mst_user" VALUES ('3', 'MAHASISWA', '$2a$10$57J57UK4Wxa6GUWig2QyA.KYv5GgiHeXUIUppRtmczWSlTJd35iba', 'USER003', '1200102', 'ACTIVE', '3', 'Admin', 'admin@agit.com', '0811111111', 'SUPERADMIN', '001','321354618', null, 'TI', 'BANDUNG', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', null, null, '0', null, null, null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,'2016-01-01 00:00:00', 'SUPERADMIN');
INSERT INTO "public"."mst_user" VALUES ('4', 'RECRUITER', '$2a$10$57J57UK4Wxa6GUWig2QyA.KYv5GgiHeXUIUppRtmczWSlTJd35iba', 'USER004', '1200102', 'ACTIVE', '4', 'Admin', 'admin@agit.com', '0811111111', 'SUPERADMIN', '001','321354618', null, 'TI', 'BANDUNG', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', '1970-01-01 00:00:00', '1970-01-01 23:59:00', null, null, '0', null, null, null, '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,'2016-01-01 00:00:00', 'SUPERADMIN');
