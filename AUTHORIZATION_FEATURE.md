# 公司授权功能 (Company Authorization Feature)

## 概述 (Overview)

此功能实现了账号与公司组织的关联授权机制，允许用户将其账号与特定公司进行绑定。

This feature implements an authorization mechanism for linking user accounts to company organizations, allowing users to associate their accounts with specific companies.

## 功能说明 (Features)

### 1. 授权关联 (Authorization Linking)
- 用户可以将自己的账号授权给公司
- 防止重复授权
- 支持验证状态管理

### 2. API 接口 (API Endpoints)

#### 授权接口 (Authorization Endpoint)
```
POST /companylink/authorize
```

参数 (Parameters):
- `authorName`: 作者名称 (必填, 最大100字符)
- `companyName`: 公司名称 (必填, 最大200字符)

响应示例 (Response Example):
```json
{
  "code": 200,
  "msg": "授权成功",
  "data": null
}
```

#### 查询接口 (Query Endpoint)
```
GET /companylink/mycompanies?authorName=xxx
```

参数 (Parameters):
- `authorName`: 作者名称 (必填, 最大100字符)

响应示例 (Response Example):
```json
{
  "code": 200,
  "msg": "success",
  "data": [
    {
      "linkAuthor": "张三",
      "linkCompany": "ABC科技公司",
      "linkVerified": true
    }
  ]
}
```

## 数据库表结构 (Database Schema)

### company_link 表

| 字段 | 类型 | 说明 |
|------|------|------|
| link_author | VARCHAR(100) | 授权作者名称 (主键) |
| link_company | VARCHAR(200) | 关联公司名称 (主键) |
| link_verified | BOOLEAN | 验证状态 |

复合主键：(link_author, link_company)

## 安装步骤 (Installation Steps)

1. 运行数据库脚本创建表:
   ```bash
   mysql -u root -p job < src/main/resources/sql/company_link_schema.sql
   ```

2. 重启应用

3. 测试API接口

## 使用示例 (Usage Examples)

### 授权公司 (Authorize Company)
```bash
curl -X POST "http://localhost:8080/companylink/authorize" \
  -d "authorName=张三&companyName=ABC科技公司"
```

### 查询我的公司 (Query My Companies)
```bash
curl "http://localhost:8080/companylink/mycompanies?authorName=张三"
```

## 技术实现 (Technical Implementation)

- **框架**: Spring Boot 3.2.3
- **ORM**: MyBatis Plus 3.5.5
- **验证**: Jakarta Bean Validation
- **数据库**: MySQL 8.0

## 安全说明 (Security Notes)

✅ 已实现:
- 输入参数验证 (长度限制、非空检查)
- SQL注入防护 (MyBatis参数化查询)
- 重复授权检查

⚠️ 待完善:
- 用户身份认证 (需要在系统级别实现)
- 权限验证 (需要配合认证系统)

## 代码检查结果 (Code Review Results)

- ✅ 代码审查通过
- ✅ CodeQL安全扫描通过 (0个安全告警)
- ✅ 构建测试通过
