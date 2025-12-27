# Big Event 项目

这是一个基于Spring Boot的博客管理系统，提供用户管理、文章分类、文章发布等功能。

## 项目特性

- 用户注册/登录
- 文章分类管理
- 文章发布与管理
- 文件上传（阿里云OSS）
- Redis缓存支持

## 技术栈

- Spring Boot 3.1.5
- MyBatis
- MySQL
- Redis
- 阿里云OSS
- Lombok
- JWT

## 环境配置

1. 复制 `.env.example` 文件为 `.env` 并填入实际的配置值：

```bash
cp .env.example .env
```

2. 在 `.env` 文件中填入数据库、Redis和阿里云OSS的配置信息

## 本地运行

1. 确保安装了 JDK 25 和 Maven
2. 配置好 MySQL 和 Redis 服务
3. 设置阿里云OSS相关信息
4. 运行项目：

```bash
mvn spring-boot:run
```

## 项目结构

```
src/
├── main/
│   ├── java/com/itheima/
│   │   ├── controller/     # 控制器层
│   │   ├── service/        # 服务层
│   │   ├── mapper/         # 数据访问层
│   │   ├── pojo/           # 实体类
│   │   ├── utils/          # 工具类
│   │   ├── config/         # 配置类
│   │   └── interceptors/   # 拦截器
│   └── resources/          # 配置文件
└── test/                   # 测试文件
```

## 注意事项

- 请勿将真实凭证提交到代码仓库
- 使用环境变量管理敏感信息
- 项目中包含 `.gitignore` 文件以避免提交敏感文件