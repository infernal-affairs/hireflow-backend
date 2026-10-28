# HireFlow Backend

HireFlow 的 Java 全栈练习项目后端仓库。当前阶段是 M0：建立可编译、可启动的最小工程基线，业务功能在后续里程碑逐步实现。

## 技术栈

- Java 21（Temurin）
- Maven 3.9+
- Spring Boot 3.4.x
- MyBatis-Plus 3.5.x
- MySQL 8.4
- JUnit 5 + MockMvc

## 目录

```text
backend/
├── sql/                    # schema.sql 与 data.sql
├── src/main/java/com/hireflow/
├── src/main/resources/
└── src/test/java/com/hireflow/
```

## 本地环境

1. 使用 JDK 21：

```bash
export JAVA_HOME="/opt/homebrew/opt/openjdk@21/libexec/openjdk.jdk/Contents/Home"
export PATH="$JAVA_HOME/bin:$PATH"
java -version
```

2. 启动 MySQL：

```bash
brew services start mysql@8.4
mysql -uroot -e 'SELECT VERSION();'
```

3. 创建开发库和测试库：

```bash
mysql -uroot -e 'CREATE DATABASE IF NOT EXISTS hireflow CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;'
mysql -uroot -e 'CREATE DATABASE IF NOT EXISTS hireflow_test CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;'
```

4. 复制环境变量示例并填写本地值：

```bash
cp .env.example .env
```

5. 启动后端：

```bash
set -a
source .env
set +a
mvn spring-boot:run
```

当前最小健康接口：

```bash
curl http://localhost:8080/api/v1/health
```

## 数据库脚本

`sql/schema.sql` 和 `sql/data.sql` 会在 M1 里程碑补齐。数据库使用手写 SQL，不启用自动建表。

## 文档

项目 Constitution、接口文档和学习材料在独立的 `docs` 仓库中。
