-- 公司链接授权表 - 用于账号与公司的关联授权
CREATE TABLE IF NOT EXISTS company_link (
    link_author VARCHAR(100) NOT NULL COMMENT '授权作者名称',
    link_company VARCHAR(200) NOT NULL COMMENT '关联公司名称',
    link_verified BOOLEAN DEFAULT TRUE COMMENT '验证状态',
    PRIMARY KEY (link_author, link_company),
    INDEX idx_author (link_author),
    INDEX idx_company (link_company)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='账号公司授权关联表';
