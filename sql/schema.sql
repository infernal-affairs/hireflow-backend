CREATE TABLE users
(
    id            BIGINT UNSIGNED     NOT NULL AUTO_INCREMENT COMMENT '用户id',
    email         VARCHAR(254) NOT NULL COMMENT '登录邮箱',
    password_hash varchar(100) not null comment '密码哈希',
    name          VARCHAR(50)  NOT NULL COMMENT '用户姓名',
    role          VARCHAR(20)  NOT NULL COMMENT '用户角色',
    created_at     DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    updated_at    DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY uk_users_email (email),
    CONSTRAINT chk_users_role CHECK ( role IN ('CANDIDATE', 'RECRUITER') )
)ENGINE =InnoDB
 DEFAULT CHARSET = utf8mb4
 COLLATE = utf8mb4_0900_ai_ci
 COMMENT = '用户账号';
CREATE TABLE candidate_profiles(
    user_id BIGINT UNSIGNED NOT NULL COMMENT '用户id',
    skills VARCHAR(500) DEFAULT NULL COMMENT '技能',
    bio VARCHAR(500) DEFAULT NULL COMMENT '简介',
    created_at     DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    updated_at    DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (user_id),
    CONSTRAINT fk_candidate_profiles_users FOREIGN KEY (user_id) REFERENCES users(id)
                               ON UPDATE RESTRICT
                               ON DELETE RESTRICT
);
CREATE TABLE companies(
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '公司id',
    display_name VARCHAR(50) NOT NULL COMMENT '公司展示名称',
    normalized_name VARCHAR(50) NOT NULL UNIQUE COMMENT '公司归一化名称',
    created_by BIGINT UNSIGNED NOT NULL COMMENT '创建人用户id',
    created_at     DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    updated_at    DATETIME(3)  NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    PRIMARY KEY (id),
    CONSTRAINT fk_companies_created_by FOREIGN KEY (created_by) REFERENCES users(id)
                      ON UPDATE RESTRICT
                      ON DELETE RESTRICT
);


